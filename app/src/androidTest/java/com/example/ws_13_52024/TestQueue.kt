package com.example.ws_13_52024

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.AddItemInQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.CheckIsQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.ClearQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.CreateDefaultQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.GetItemFromQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.GetSizeQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.QueueUseCase
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardItem
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardScreen
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


//RED
@RunWith(AndroidJUnit4::class)
class TestQueue {


    private lateinit var viewModel: OnboardViewModel
    private lateinit var useCases: QueueUseCase

    @get:Rule
    private val rule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        val manger = QueueTestMangerImpl()
        useCases = QueueUseCase(
            AddItemInQueue(manger),
            ClearQueue(manger),
            GetItemFromQueue(manger),
            GetSizeQueue(manger),
            CheckIsQueue(manger),
            CreateDefaultQueue(manger)
        )
        viewModel = OnboardViewModel(
            useCases
        )
        Log.i("client", "init complete")
    }


    @Test
    fun getItem() {
        runBlocking {
            useCases.clearQueue()
            useCases.addItemInQueue(OnboardItem(1, "title1", "description1"))
            useCases.addItemInQueue(OnboardItem(2, "title2", "description2"))
        }

        rule.setContent {
            OnboardScreen(
                navController = rememberNavController(),
                viewModel = viewModel
            )
        }

        rule.onNodeWithText("title1").assertExists()

        rule.onNodeWithText("Начать").performClick()

        rule.onNodeWithText("title2").assertExists()

    }

}