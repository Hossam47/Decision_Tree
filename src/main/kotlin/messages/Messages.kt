package messages

import entropy

fun printTotalItems(number: Int) = println("\nTotal items are : $number \n")

fun printNumbersOfPositive(number: Int) = println("Positive items are : $number \n")

fun printNumbersOfNegative(number: Int) = println("Negative items are : $number \n")

fun printEntropy(positive: Int, negative: Int, total: Int = positive + negative) =
    println(
        "Entropy: − $positive/$total * log2( $positive/ $total) −  $negative/ $total * log2( $negative/ $total ) = ${
            entropy(
                positive.toDouble(),
                negative.toDouble()
            )
        }\n"
    )



