import data.Data
import data.NodesName
import data.getNodeName
import kotlin.math.ln


/*
*Entropy([positive,negative])= − positive/total * log2(positive/total) − negative/total * log2(negative/total)
*
* */
fun entropy(positive: Double, negative: Double, total: Double = positive + negative) =
    - (positive / total * log2(positive, negative) + negative / total * log2(negative, positive))

fun informationGain(
    dataList: List<Data>,
    information: (Data) -> Pair<String, Boolean>
): Double {

    val (positive, negative) = dataList.map { information(it) }.partition { it.second }

    val attributes = dataList.map { information(it) }.groupBy { it.first }.map {
        val (positiveSv, negativeSv) = it.value.partition { it.second }
        Triple(it.key, positiveSv.size.toDouble(), negativeSv.size.toDouble())
    }
    return (entropy(positive.size.toDouble(), negative.size.toDouble())
            + attributes.sumOf { -entropy(it.second, it.third, dataList.size.toDouble()) })

}

fun printInformationGain(
    dataList: List<Data>,
    nodesName: NodesName,
    information: (Data) -> Pair<String, Boolean>
): Double {

    val (positive, negative) = dataList.map { information(it) }.partition { it.second }

    val attributes = dataList.map { information(it) }.groupBy { it.first }.map {
        val (positiveSv, negativeSv) = it.value.partition { it.second }
        Triple(it.key, positiveSv.size.toDouble(), negativeSv.size.toDouble())
    }

    println("attributes : $attributes\n")

    println("Node is (${getNodeName(nodesName)})\n+ positive items is $positive\n- negative items is $negative\n" +
            "* Information gain for this node is: ${
                entropy(positive.size.toDouble(), negative.size.toDouble())
                        + attributes.sumOf { -entropy(it.second, it.third, dataList.size.toDouble()) }
            }\n")

    return (entropy(positive.size.toDouble(), negative.size.toDouble())
            + attributes.sumOf { -entropy(it.second, it.third, dataList.size.toDouble()) })
}


fun log2(positive: Double, negative: Double) =
    if (positive == 0.0) 1.0 else ln(positive / (positive + negative)) / ln(2.0)