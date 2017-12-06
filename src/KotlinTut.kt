
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
}