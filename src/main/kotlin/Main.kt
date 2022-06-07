import data.DataSet
import data.NodesName
import messages.printEntropy
import messages.printNumbersOfNegative
import messages.printNumbersOfPositive
import messages.printTotalItems

fun main() {

    val (positive, negative) = DataSet.data.partition { it.play!! }

    printTotalItems(positive.size.plus(negative.size))

    printNumbersOfPositive(positive.size)

    printNumbersOfNegative(negative.size)

    printEntropy(positive.size, negative.size)

    NodesName.values().forEach { nodeName ->

        informationGain(DataSet.data, nodeName) {
            Pair(
                when (nodeName) {
                    NodesName.OUTLOOK -> it.outlook
                    NodesName.HUMIDITY -> it.humidity
                    NodesName.TEMPERATURE -> it.temperature
                    NodesName.WIND -> it.wind
                }, it.play!!
            )
        }
    }

    println("Tree is : ${build.build(DataSet.data)}")

}