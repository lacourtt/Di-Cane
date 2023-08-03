package com.dicane.app.compose

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.math.absoluteValue

class MaskTransformation(private val mask: String): VisualTransformation {

    sealed class MaskType(val mask: String, val count: Int) {
        object CNPJ: MaskType("##.###.###/####-##", 14)
        object CPF: MaskType("###.###.###-##", 11)
        object DATE: MaskType("##/##/####", 8)
    }

    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }

    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        var maskIndex = 0
        text.forEach { char ->
            while (specialSymbolsIndices.contains(maskIndex)) {
                out += mask[maskIndex]
                maskIndex++
            }
            out += char
            maskIndex++
        }
        return TransformedText(AnnotatedString(out), offsetTranslator())
    }

    private fun offsetTranslator() = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            val offsetValue = offset.absoluteValue
            if (offsetValue == 0) return 0
            var numberOfHashtags = 0
            val masked = mask.takeWhile {
                if (it == '#') numberOfHashtags++
                numberOfHashtags < offsetValue
            }
            return masked.length + 1
        }

        override fun transformedToOriginal(offset: Int): Int {
            return mask.take(offset.absoluteValue).count { it == '#' }
        }
    }
}

fun String.unmaskAlphanumerics(): String {
    val reg = "[^A-Za-z0-9 ]".toRegex()
    return this.replace(reg, "")
}

fun String.unmaskNumbers(): String {
    val reg = "[^0-9]*".toRegex()
    return this.replace(reg, "")
}