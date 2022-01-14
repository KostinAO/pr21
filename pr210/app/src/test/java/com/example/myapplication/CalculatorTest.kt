import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import ru.samsung.itacademy.mdev.simplecalctemplate.Calculator

class CalculatorTest {
    private var calculator: Calculator? = null
    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun add() {
        Assert.assertEquals(6, calculator!!.add(3, 3).toLong())
    }

    @Test
    fun substract() {
        Assert.assertEquals(3, calculator!!.subtract(6, 3).toLong())
    }

    @Test
    fun multiply() {
        Assert.assertEquals(10, calculator!!.multiply(1, 10).toLong())
    }

    @Test
    fun divide() {
        Assert.assertEquals(2, calculator!!.divide(10, 5).toLong())
    }

    @Test
    fun all() {
        Assert.assertEquals(-7, calculator!!.add(13, -20).toLong())
        Assert.assertEquals(13, calculator!!.subtract(10, -3).toLong())
        Assert.assertEquals(0, calculator!!.multiply(10, 0).toLong())
        Assert.assertEquals(0, calculator!!.divide(10, 0).toLong())
    }


    @After
    fun tearDown() {
        calculator = null
    }
}