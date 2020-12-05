import java.lang.Exception

fun main() {
    try {
        println("Введите сумму перевода:")
        val transitionSum = readLine()!!.toDouble()
        println("Введите сумму, потраченную ранее:")
        val spentAlreadySum = readLine()!!.toDouble()

        println("Введите номер Вашего оператора:\n1.Mastercard\n2.Visa или Мир\n3.VK Pay")
        val transitionType = when (readLine()!!.toInt()) {
            1 -> "Mastercard"
            2 -> "Visa/Мир"
            3 -> "VK Pay"
            else -> "0"
        }
        if (transitionType != "0") {
            val commissionPrice: Double = getCommissionPrice(
                transitionType = transitionType,
                spentAlreadySum = spentAlreadySum,
                transitionSum = transitionSum
            ).toDouble()
            print("Стоимость с учетом комиссии составит ${transitionSum + commissionPrice}")
        } else println("Кто-то накосячил...")
    } catch (e: Exception) {
        println("Кто-то накосячил...")
    }
}


fun getCommissionPrice(
    transitionType: String,
    spentAlreadySum: Double,
    transitionSum: Double
): Number {
    return when (transitionType) {
        "Mastercard" -> if ((spentAlreadySum < 75_000) && (spentAlreadySum > 300)) 0 else transitionSum * 0.6 / 100 + 20
        "Visa/Мир" -> if (transitionSum * 0.75 / 100 < 35) 35 else transitionSum * 0.75 / 100
        "VK Pay" -> 0.0
        else -> 0.0
    }
}