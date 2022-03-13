package `Stage 2 Virtual card deck`

fun main() {
    val indigoGame = IndigoGame()
    indigoGame.fillDeck()

    while (true) {
        println("Choose an action (reset, shuffle, get, exit):")
        when (readln()) {
            "reset" -> indigoGame.resetDeck()
            "shuffle" -> indigoGame.shuffleDeck()
            "get" -> {
                try {
                    println("Number of cards:")
                    when (val numCards = readln().toInt()) {
                        !in 1..52 -> println("Invalid number of cards.")
                        in 1..indigoGame.deckCards.size -> indigoGame.getCards(numCards)
                        else -> println("The remaining cards are insufficient to meet the request.")
                    }
                } catch (e: Exception) {
                    println("Invalid number of cards.")
                }
            }
            "exit" -> break
            else -> println("Wrong action.")
        }
    }
    println("Bye")
}

class IndigoGame {
    private val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    private val suits = listOf("♦", "♥", "♠", "♣")
    val deckCards = mutableListOf<String>()
    private val gotCards = mutableListOf<String>()

    fun fillDeck(): MutableList<String> {
        for (suit in suits) {
            for (rank in ranks) {
                deckCards += "$rank$suit"
            }
        }
        return deckCards
    }

    fun shuffleDeck() {
        println("Card deck is shuffled.")
        return deckCards.shuffle()
    }

    fun resetDeck(): MutableList<String> {
        deckCards.clear()
        for (suit in suits) {
            for (rank in ranks) {
                deckCards += "$rank$suit"
            }
        }
        println("Card deck is reset.")
        return deckCards
    }

    fun getCards(numCards: Int): MutableList<String> {
        gotCards.clear()
        for (i in deckCards.indices) {
            if (i < numCards) {
                gotCards += deckCards[i]
            }
        }

        println(gotCards.joinToString(" "))
        deckCards -= gotCards.toSet()

        return deckCards
    }
}