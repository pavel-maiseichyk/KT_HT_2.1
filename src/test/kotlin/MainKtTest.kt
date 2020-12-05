import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun getCommissionPrice_Mastercard_spent_from_300_to_75000() {
        val transitionType = "Mastercard"
        val spentAlreadySum = 1_000
        val transitionSum = 3_000
        val commissionPrice = getCommissionPrice(
            transitionType, spentAlreadySum.toDouble(), transitionSum.toDouble()
        )
        assertEquals(0, commissionPrice)
    }

    @Test
    fun getCommissionPrice_Mastercard_spent_else() {
        val transitionType = "Mastercard"
        val spentAlreadySum = 10
        val transitionSum = 3_000
        val commissionPrice = getCommissionPrice(
                transitionType, spentAlreadySum.toDouble(), transitionSum.toDouble()
        )
        assertEquals(38.0, commissionPrice)
    }

    @Test
    fun getCommissionPrice_Visa_Mir() {
        val transitionType = "Visa/Мир"
        val spentAlreadySum = 10
        val transitionSum = 100_000
        val commissionPrice = getCommissionPrice(
                transitionType, spentAlreadySum.toDouble(), transitionSum.toDouble()
        )
        assertEquals(750.0, commissionPrice)
    }

    @Test
    fun getCommissionPrice_VK() {
        val transitionType = "VK Pay"
        val spentAlreadySum = 10
        val transitionSum = 3_000
        val commissionPrice = getCommissionPrice(
                transitionType, spentAlreadySum.toDouble(), transitionSum.toDouble()
        )
        assertEquals(1.0, commissionPrice)
    }
}