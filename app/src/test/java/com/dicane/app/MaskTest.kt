package com.dicane.app

import com.dicane.app.compose.unmaskAlphanumerics
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MaskTest {

    @Test
    fun textFieldValue() {
        assertEquals("1a2b3c", "1/#a$2¨b3&$:c/".unmaskAlphanumerics())
    }
}