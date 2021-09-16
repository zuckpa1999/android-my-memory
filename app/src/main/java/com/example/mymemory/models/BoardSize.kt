package com.example.mymemory.models

enum class BoardSize(val numCards: Int){
    EASY(8),
    MEDIUM(18),
    HARD(24);


    fun getWidth(): Int{
        return when(this){
            EASY -> 2
            MEDIUM -> 3
            HARD -> 4
        }
    }
    fun getHeight(): Int {
        return numCards / getWidth()
    }

    // numPairs = all the box /2 === number of unique pgotos
    fun getNumpairs(): Int{
        return numCards / 2

    }
}