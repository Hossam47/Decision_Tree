package data

object DataSet {
    val data = listOf(
        Data(mapOf("outlook" to "Sunny", "temperature" to "Hot", "humidity" to "High", "wind" to  "Weak"), false),
        Data(mapOf("outlook" to "Sunny", "temperature" to "Hot", "humidity" to "High", "wind" to "Strong"), false),
        Data(mapOf("outlook" to "Overcast", "temperature" to "Hot", "humidity" to "High", "wind" to "Weak"), true),
        Data(mapOf("outlook" to "Rain", "temperature" to "Mild", "humidity" to "High", "wind" to "Weak"), true),
        Data(mapOf("outlook" to "Rain", "temperature" to "Cool", "humidity" to "Normal", "wind" to "Weak"), true),
        Data(mapOf("outlook" to "Rain", "temperature" to "Cool", "humidity" to "Normal", "wind" to "Strong"), false),
        Data(mapOf("outlook" to "Overcast", "temperature" to "Cool", "humidity" to "Normal", "wind" to "Strong"), true),
        Data(mapOf("outlook" to "Sunny", "temperature" to "Mild", "humidity" to "High", "wind" to "Weak"), false),
        Data(mapOf("outlook" to "Sunny", "temperature" to "Cool", "humidity" to "Normal", "wind" to "Weak"), true),
        Data(mapOf("outlook" to "Rain", "temperature" to "Mild", "humidity" to "Normal", "wind" to "Weak"), true),
        Data(mapOf("outlook" to "Sunny", "temperature" to "Mild", "humidity" to "Normal", "wind" to "Strong"), true),
        Data(mapOf("outlook" to "Overcast", "temperature" to "Mild", "humidity" to "High", "wind" to "Strong"), true),
        Data(mapOf("outlook" to "Overcast", "temperature" to "Hot", "humidity" to "Normal", "wind" to "Weak"), true),
        Data(mapOf("outlook" to "Rain", "temperature" to "Mild", "humidity" to "High", "wind" to "Strong"), false)
    )
}