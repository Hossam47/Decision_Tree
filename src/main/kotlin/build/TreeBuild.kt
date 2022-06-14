package build

import data.Data
import data.DataSet
import informationGain
import tree.Tree

fun build(dataPoints: List<Data>): Tree {

//    Starting off, we determine whether the DataSet is made up of all positive or all negative sample points (Entropy 0):
    val (positive, negative) = dataPoints.partition { it.play!! }
    if (positive.size == 0) return Tree.Leaf(false)
    if (negative.size == 0) return Tree.Leaf(true)

//    It such a case we return a Tree.Leaf with the corresponding result.
//
//    Next we will check how many attributes there are in the DataSet:
    val attributes = dataPoints.map { it.map.keys }.flatten().distinct()

//    If there is only one attribute, then the most common value of the target attribute is returned.
    if (attributes.size == 1) {
        return if (dataPoints.count { it.play!! } > dataPoints.count { !it.play!! }) Tree.Leaf(true)
        else Tree.Leaf(false)
    } else {
//        Otherwise, we will first determine “Which attribute is the best?” by working the Information Gain of each
//        attribute and retrieve the one with the highest Information Gain:
        val (attribute) = attributes.map { attr ->
            Pair(attr, informationGain(dataPoints) { Pair(it.map[attr].toString(), it.play!!) })
        }.maxByOrNull { it.second }!!


//        For all the values of the chosen attribute:
        val remainingNodes = dataPoints.groupBy { it.map[attribute] }


//we will add a new subtree below the parent node and select the DataSet subset such that the attribute A in the parent subset matches the value vi.
        val filteredRemaining = remainingNodes.entries.map { entry ->
            Pair(entry.key, entry.value.map { dataPoint ->
                Data(dataPoint.map.filterKeys { it != attribute }, dataPoint.play)
            })
        }

//        Finally we will call the build function recursively on this DataSet subset.

        val children = filteredRemaining.map { Pair(it.first.toString(), build(it.second)) }.toMap();
        return Tree.Node(attribute, children)
    }
}