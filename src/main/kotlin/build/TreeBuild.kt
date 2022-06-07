package build

import data.Data
import informationGain
import tree.Tree

fun build(dataPoints: List<Data>): Tree {

    val (positive, negative) = dataPoints.partition { it.play!! }

    if (positive.size == 0) return Tree.Leaf(false)
    if (negative.size == 0) return Tree.Leaf(true)

    val attributes = dataPoints.map { it.map.keys }.flatMap { it }.distinct()

    if (attributes.size == 1) {
        return if (dataPoints.count { it.play!! } > dataPoints.count { !it.play!! }) Tree.Leaf(true) else Tree.Leaf(
            false)
    } else {
        val (attribute) = attributes.map { attr ->
            Pair(attr, informationGain(dataPoints) { Pair(it.map[attr].toString(), it.play!!) })
        }.maxByOrNull { it.second }!!

        val remainingNodes = dataPoints.groupBy { it.map[attribute] }

        val filteredRemaining = remainingNodes.entries.map { entry ->
            Pair(entry.key, entry.value.map { dataPoint ->
                Data(dataPoint.map.filterKeys { it != attribute }, dataPoint.play)
            })
        }

        val children = filteredRemaining.map { Pair(it.first.toString(), build(it.second)) }.toMap();
        return Tree.Node(attribute, children)
    }
}