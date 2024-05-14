package com.example.ws_13_52024

import android.util.Patterns
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(true, Patterns.EMAIL_ADDRESS.matcher("home@oleg.gnom"))
    }
}