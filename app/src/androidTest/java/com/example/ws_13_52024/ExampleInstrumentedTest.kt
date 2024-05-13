package com.example.ws_13_52024

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule


//RED
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {


    private lateinit var viewModel: OnboardViewModel
    private lateinit var useCases: QueueUseCase

    @get:Rule
    private val rule = Rule()

    @Before
    fun setUp(){
        val manger = QueueManger(application)
        useCases = (
                GetItemFromQueue(manger),
                AddItemQueue(manger),
                ClearQueue(manger),
                GetSize(manger),
        )
        viewModel = OnboardViewModel(
            useCases
        )
    }


    @Test
    fun getItem(){
        useCases.ClearQueue()
        useCases.AddItemQueue(OnboardPage(R.drawable.icon, "title", "description"))


    }
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.ws_13_52024", appContext.packageName)
    }
}