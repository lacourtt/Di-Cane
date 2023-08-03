package com.dicane.app

import androidx.compose.ui.text.input.TextFieldValue
import com.dicane.app.compose.MaskTransformation
import com.dicane.app.compose.unmaskAlphanumerics
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MaskTest {
//
//    @Test
//    fun unmask() {
//        val s = "1-2,3.4/5abc"
//        assertEquals("12345", MaskTransformation.unMask(s))
//    }
//
//    @Test
//    fun maskCNPJ() {
//        val s = "1234567890123"
//        assertEquals("12.345.678/9012-3", MaskTransformation.mask(s, MaskTransformation.Type.CNPJ))
//    }
//
//    @Test
//    fun maskCNPJ1() {
//        val s = "1234567890"
//        assertEquals("12.345.678/90", MaskTransformation.mask(s, MaskTransformation.Type.CNPJ))
//    }
//
//    @Test
//    fun maskCNPJ2() {
//        val s = "1"
//        assertEquals("1", MaskTransformation.mask(s, MaskTransformation.Type.CNPJ))
//    }
//
//    @Test
//    fun maskCNPJ3() {
//        val s = "12345678901234"
//        assertEquals("12.345.678/9012-34", MaskTransformation.mask(s, MaskTransformation.Type.CNPJ))
//    }
//
    @Test
    fun textFieldValue() {
        assertEquals("1a2b3c", "1/#a$2¨b3&$:c/".unmaskAlphanumerics())
    }
}