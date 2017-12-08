import java.util.*

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
}
