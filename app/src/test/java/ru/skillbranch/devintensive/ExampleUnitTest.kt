package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {

//        val user = User(id = "1")
        val user2 = User(id = "2", firstName = "John", lastName = "Cena")

    }

    @Test
    fun test_factory(){
//        val user = User.makeUser("John Cena")
//        val user2 = User.makeUser("John Wick")
        val user = User.makeUser("John Wick")
        val user2 = user.copy(id = "2", lastName = "Cena", lastVisit = Date())
        print("$user \n$user2")
    }

    @Test
    fun test_decomposition(){

        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val(id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")

    }

    @Test
    fun test_copy(){
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
          ${user.lastVisit?.format()}
          ${user2.lastVisit?.format()}
          ${user3.lastVisit?.format()}
          ${user4.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun dataq_maping(){
        val user = User.makeUser("Макеев Михаил")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        println(newUser)
        val userView = newUser.toUserView()
        userView.printMe()

    }

    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Макеев Михаил")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())

    }

    @Test
    fun parse_full_name(){
        val user = User.makeUser("John ")
        println(user)
        println("${user.firstName} ${user.lastName}")
//        println(Utils.toInitials(user.firstName, user.lastName))

    }

    @Test
    fun toInitials(){
        val user = User.makeUser("john doe")
        println(Utils.toInitials(user.firstName, user.lastName))
    }
}
