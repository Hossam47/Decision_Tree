package data

data class Data(val map: Map<String, Any?>, val play: Boolean? = null) {
    val outlook: String by map
    val temperature: String by map
    val humidity: String by map
    val wind: String by map
}
