import java.util.*
import javax.swing.text.html.ObjectView

fun main(args: Array<String>){

    /** Variables */
    val name = "Miguel"     // variable value cannot change
    var age = 25            // variable value can change
    println("age: $age")    // string interpolation is when a variable can go inside a string followed by a $ sign

    var letterGrade: Char = 'A'
    println("A is a Char: ${letterGrade is Char}")

    /** Casting */
    println("3.14 to Int: " + (3.14.toInt()))
    println("A to Int: " + ('A').toInt())
    println("65 to Char: " + 65.toChar())

    /** Strings */
    val longStr = "this a long long string just for test"
    println("long string size: ${longStr.length}")
    var str1 = "A random string"
    var str2 = "a random string"
    println("String equals: ${str1.equals(str2)}" )
    println("Compare A to A: ${"A".compareTo("A")}")
    println("Compare A to B: ${"A".compareTo("B")}")
    println("2nd Index of str1: ${str1[2]}")
    println("Index 2 - 7: ${str1.subSequence(2,7)}")
    println("Contains random: ${str1.contains("random")}")

    /** Arrays */
    var mArray = arrayOf(9, 1.23, "Mike")
    println(mArray[2])
    mArray[1] = 3.1416
    println("Array length: ${mArray.size}")
    println("Mike is in array: ${mArray.contains("Mike")}")
    var partArray = mArray.copyOfRange(0, 1)
    println("First element : ${mArray.first()}")
    println("Mike index: ${mArray.indexOf("Mike")}")

    var sqArray = Array(5, {x -> x * x})
    println("Square of 4: ${sqArray[4]}")

    var intArray: Array<Int> = arrayOf(1, 2, 3)

    // Ranges
    val oneTo10 = 1..10
    val alpha = "A".."Z"
    println("R in alpha: ${"R" in alpha}")
    val tenTo1 = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)
    val rng3 = oneTo10.step(3)

    for (x in rng3) println("rng2: $x")

    for (x in tenTo1.reversed()) println("Reverse: $x")

    /** Conditionals */
    when (age){
        0,1,2,3,4 -> println("Go to preschool")
        5 -> println("Go to Kindergarten")
        in 6..17 -> {
            val grade = age - 5
            println("Go to Grade $grade")
        }
        else -> println("Go to College")
    }

    /** Loops */
    for(x in 1..10){
        println("Loop: $x")
    }

    val rand = Random()
    val magicNum = rand.nextInt(50) + 1

    var guess = 0

    while (magicNum != guess){
        guess += 1
    }

    println("Magic number was $guess")

    for (x in 1..20){
        if (x % 2 == 0){
            continue        // continue jumps to the step in loop
        }
        println("Odd: $x")
        if (x == 15) break  // break exits the loop
    }

    var arr3: Array<Int> = arrayOf(3, 6, 9)

    for (i in arr3.indices){
        println("Mult 3: ${arr3[i]}")
    }

    for ((index, value) in arr3.withIndex()){
        println("Index: $index - Value: $value")
    }

    /**  functions */
    fun add(num1: Int, num2: Int) : Int = num1 + num2
    println("5 + 4 = ${add(5,4)}")

    fun subtract(num1: Int = 1, num2: Int = 1) = num1 - num2    // Default values. No need for return type
    println("5 - 4 = ${subtract(5, 4)}")
    println("4 - 5 = ${subtract(num1 = 5, num2 = 4)}")

    fun sayHello(name: String) : Unit = println("Hello $name")
    sayHello("Miguel")

    fun nextTwo(num: Int): Pair<Int, Int>{
        return Pair(num + 1, num + 2)
    }

    val (two, three) = nextTwo(1)
    println("1 $two $three")

    fun getSum(vararg nums: Int): Int{  // vararg acts like an array
        var sum = 0

        nums.forEach { i -> sum += i }  // for each i -> (do something); i contains the value

        return sum
    }

    println("1 + 2 + 3 + 4 + 5 = ${getSum(1,2,3,4,5)}")

    val multiply = {num1: Int, num2: Int -> num1 * num2}
    println("5 * 3 = ${multiply(5,3)}")

    // Higher Order Functions
    val numList = 1..20
    val evenList = numList.filter {it % 2 == 0}
    evenList.forEach { i -> println(i) }

    // function that returns a created function
    // (Int) is the function that is going to be returned
    fun makeMathFunc(num1: Int): (Int) -> Int = {num2 -> num1 * num2}

    val mult3 = makeMathFunc(3)
    println("5 * 3 = ${mult3(5)}")

    fun mathOnList(numList: Array<Int>, mFunction: (num: Int) -> Int){  // receives a list and a function that returns an int
        for (num in numList){
            println("MathOnList ${mFunction(num)}")
        }
    }

    val multiply2 = {num1: Int -> num1 * 2}     // this is a function that multiples by 2 a number passed in
    val numList2 = arrayOf(1, 2, 3, 4, 5)
    mathOnList(numList2, multiply2)

    /** Exception handling */
    val divisor = 0
    try {
        if (divisor == 0) {
            throw IllegalArgumentException("Can't divide by zero")
        } else {
            println("5 / $divisor =  ${5/divisor}")
        }
    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }

    /** Lists */
    var list1: MutableList<Int> = mutableListOf(1,2,3,4,5)
    val list2: List<Int> = listOf(1,2,3,4)

    list1.add(6)

    println("First: ${list1.first()}")
    println("Last: ${list1.last()}")

    println("2nd: ${list1[2]}")

    var list3 = list1.subList(0, 3)

    println("Length: ${list1.size}")

    list3.clear()

    list1.remove(1)
    list1.removeAt(1)
    list1.forEach { n -> println("Mutable list item $n") }

    val map = mutableMapOf<Int, Any?>()
    val map2 = mutableMapOf(1 to "Mike", 2 to 25)       // this is how to initialize a map with values

    map[1] = "Guz"
    map[2] = 50

    println("Map Size: ${map.size}")

    map.put(3, "Tarzana")

    map.remove(1)
    
    for ((x, y) in map){
        println("Key: $x Value: $y")
    }

    /** Classes */
    val bowser = Animal("Bowser", 20.0, 13.5)
    bowser.getInfo()

    /** Inheritance */
    val spot = Dog("Spot", 20.0, 14.5, "Paul Smith")
    spot.getInfo()

    /** Interfaces */
    val tweety = Bird("Tweety", true)
    tweety.fly(10.0)

}

open class Animal(val name: String,
                  val height: Double,
                  val weight: Double){
    // Objects are initialized inside init function.
    // Basically it checks is values are ok
    init {
        val regex = Regex(".*\\d+.*")
        require(!name.matches(regex)) {"Animal can't contain numbers"}
        require(height > 0) {"Height must be greater than zero"}
        require(weight > 0) {"Weight must be greater than zero"}
    }

    open fun getInfo(): Unit{
        println("Name: $name Height: $height Weight: $weight")
    }
}

class Dog(name: String,
          height: Double,
          weight: Double,
          var owner: String) : Animal(name, height, weight) {
    override fun getInfo(): Unit {
        println("$name is $height, weights $weight and the owner is $owner")
    }
}

interface Flyable{
    var flies: Boolean

    fun fly(distMile: Double): Unit
}

class Bird constructor(val name: String, override var flies: Boolean = true) : Flyable {
    override fun fly(distMiles: Double): Unit {
        if (flies){
            println("$name flies $distMiles miles")
        }
    }
}