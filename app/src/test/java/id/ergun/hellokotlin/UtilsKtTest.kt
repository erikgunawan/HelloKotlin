package id.ergun.hellokotlin

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat

class UtilsKtTest {

    @Test
    fun toSimpleStringTest() {
        val dateFormat = SimpleDateFormat("MM/dd/yyyy")
        val date = dateFormat.parse("02/28/2018")
        assertEquals("Wed, 28 02 2018", toSimpleString(date))
    }
}