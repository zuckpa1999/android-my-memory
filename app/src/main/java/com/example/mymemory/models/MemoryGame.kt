package com.example.mymemory.models

import com.example.mymemory.utils.DEFAULT_ICONS

class MemoryGame (private val boardSize: BoardSize){


    val cards: List<MemoryCard>
    var numPairFound = 0
    private var numCardFLips = 0
    private var indexOfSingleSelectedCard: Int? = null

    init{
        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumpairs())
        val randomizedImages = (chosenImages + chosenImages).shuffled()
        //data class
        cards = randomizedImages.map { MemoryCard(it) }
    }
    fun flipCard(position: Int): Boolean {
        numCardFLips++
            val card = cards[position]
        //Three cases:
        //0 card flipped ->  restore cards + flip over the selected card
        //1 card flipped -> flip over the selected card + check if the images match
        //2 cards flipped -> restore cards + flip over the selected card
        var foundMatch = false
        if(indexOfSingleSelectedCard== null){
            // 0 or 2 card previously flipped over
            restoreCards()
            indexOfSingleSelectedCard = position

        } else{
            //exactly 1 card flipped
                // !!
           foundMatch =  checkForMatch(indexOfSingleSelectedCard!!,position)
            indexOfSingleSelectedCard = null
        }
        card.isFaceUp = !card.isFaceUp
        return foundMatch
    }

    private fun checkForMatch(pos1: Int, pos2: Int): Boolean {
        if(cards[pos1].identifier != cards[pos2].identifier)
        {
            return false
        }
        cards[pos1].isMatched = true
        cards[pos2].isMatched = true
        numPairFound++
        return true
    }

    private fun restoreCards() {
        for(card in cards){
            if(!card.isMatched){
                card.isFaceUp = false
            }
        }
    }

    fun haveWonGame(): Boolean {
        return numPairFound == boardSize.getNumpairs()
    }

    fun isCardFaceUp(position: Int): Boolean {
        return cards[position].isFaceUp
    }

    fun getNumMoves():Int {
        return numCardFLips /2
    }

}