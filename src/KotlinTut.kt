
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
}
