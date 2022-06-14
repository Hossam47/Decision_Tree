package data

enum class NodesName {
    OUTLOOK,
    TEMPERATURE,
    HUMIDITY,
    WIND,
}
fun getNodeName(node: NodesName): String = when (node) {
    NodesName.OUTLOOK -> "Outlook"
    NodesName.TEMPERATURE -> "Temperature"
    NodesName.HUMIDITY -> "Humidity"
    NodesName.WIND -> "Wind"
}