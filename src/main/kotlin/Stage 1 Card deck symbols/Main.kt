package `Stage 1 Card deck symbols`

fun main() {
    val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    val suits = listOf("♦", "♥", "♠", "♣")
    val deckCards = mutableListOf<String>()

    for (suit in suits) {
        for (rank in ranks) {
            deckCards += "$rank$suit"
        }
    }

    println(ranks.joinToString(" "))
    println(suits.joinToString(" "))
    println(deckCards.joinToString(" "))
}

