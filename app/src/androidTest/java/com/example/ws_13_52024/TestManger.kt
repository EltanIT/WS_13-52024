package com.example.ws_13_52024

import java.util.LinkedList

class TestManger {

    val queue = LinkedList<OnboardPage>()


    fun getItem(): OnboardPage{
        return queue.pop()
    }

    fun clearQueue(){
        queue.clear()
    }

    fun addItem(item: OnboardPage){
        queue.add(item)
    }


    fun getSize(){
        return queue.size()
    }
}