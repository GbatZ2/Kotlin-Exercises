package com.example.fundamentals

fun main() {
    //*val Constructor = Constructors("Morales")
    //*Constructor.TrailingLambda("SSSSUMAAAA"){Constructor.sum2(4,5)}
    //*println("Helloo".append(" Carlao"))
    //*println("This is fun".removeWord())

    /*val prs1 = Person("Carlao1", "Zaragoza1", 21)
    val prs2 = Person("Carlao2", "Zaragoza2", 22)
    val prs3 = Person("Carlao3", "Zaragoza3", 23)
    val prs4 = Person("Carlao4", "Zaragoza4", 24)


    var listPersons = listOf<Person>(prs1, prs2, prs3, prs4)
    listPersons.forEach {
        println(it)
    }*/

    /*val listOfItems = listOf("Carlao","Gaucho","Orgaz",23)
    val finder = Finder(listOfItems)
    finder.findItem("Carlao"){ println("Found $it")}
    finder.findItem(23){ println("Found $it")}*/
    Repository.startFetch()
    getResult(result = Repository.getCurrentState())
}



/*Enums*/
/*enum class Result{
    SUCCESS,
    ERROR,
    IDLE,
    LOADING
}*/
/*Abstract Class*/
sealed class Result

data class  Success(val dataFetched:String?):Result()

data class  Error(val exception:Exception?):Result()

data class  IDLE(val dataFetched:String?):Result()

object  Loading:Result()

object notLoading:Result()

/*fun getResult(result:Result){
    return when(result){
                Result.ERROR()-> println("Error")
                Result.SUCCESS()-> println("Success")
                Result.IDLE()-> println("Idle")
                Result.LOADING()-> println("Loading...")
                else -> println("nothing")
    }
}*/
fun getResult(result: Result){
    return when(result){
            is Error-> {
                println(result.exception.toString())
            }
            is Success->{
                println(result.dataFetched?:"Ensure you start the fetch function first")
            }
            is Loading->{
                println("Loading...")
            }
            is notLoading->{
                println("IDLE")
            }
            else-> {
                println("N/A")
            }
    }
}


object Repository{
    private var loadState:Result = notLoading
    private var dataFetched:String? = null
    fun startFetch(){
        loadState = Loading
        dataFetched = "Data"
    }
    fun finishedFetch(){
        loadState = Success(dataFetched)
        dataFetched = null
    }
    fun errorFetch(){
        loadState = Error(exception = Exception("Exception"))
    }
    fun getCurrentState():Result{
        return loadState
    }
}

/* **Generics */

class Finder<T>(private val list:List<T>){
    fun findItem(element:T, foundItem: (element:T?)-> Unit){
        val itemFound = list.filter {
            it === element
        }
        if(itemFound.isNullOrEmpty()) foundItem(null)
        else foundItem(itemFound.first())

    }
}

data class Person(val name:String, val lastName:String, val age:Int){

}



fun String.append(toAppend:String):String = this.plus(toAppend)


fun String.removeWord():String{
    return this.substring(1, this.length - 1)
}


class Button (var label:String):ClickEvent{
    override fun onClick(message: String) {
        println("Print by $label and here's the message: $message")
    }
}
class Chara (var chara:Char):ClickEvent{
    override fun onClick(message: String) {
        println("$chara $message")
    }

}

interface ClickEvent{
    fun onClick(message:String)


}

class Constructors (var firstName: String="Musico", var lastName:String="Morales", var isPlatinum:Boolean) {

    private var fullName:String = "$firstName $lastName"
    private var fullNameLength:Int = fullName.length





    //*Collections

    //*Set
    val mySet = setOf<String>("AU","ES","EU","PR")
    val myMutableSet = mutableSetOf<String>("AU","ES","EU")


    //*Map
    val secretMap = mapOf<Int,String>(1 to "ES", 2 to "FR", 3 to "GER", 4 to "AUS")
    val mutableMap = mutableMapOf<String, Int>("Up" to 1, "Right" to 2, "Down" to 3, "Left" to 4)

    //*Read Only
    var myListOfNames = listOf("CArlao","Paul","Gaucho","MUSICO")


    //*Mutable List
    var MutableList = mutableListOf<Boolean>(true, false, true,false)


    //*Init
    init{
        println(fullName)
    }


    //*Constructors
    constructor(firstName:String, lastName: String) : this(firstName,lastName, isPlatinum = false)

    constructor(firstName: String):this(firstName, "Unkown")

    constructor(lastName: String, isPlatinum: Boolean):this("Unkown",lastName,isPlatinum)


    /*Lambda Expressions*/

    val sum2:(Int,Int) -> Int = {a, b -> a+b}
    val msg:(String) -> Unit = {a-> println(a)}

    /*Normal function*/
    fun sum(a:Int, b:Int):Int{
        return a+b
    }

    //*Cat Age Calculator
    //*Normal Function
    fun CalculatorAge(age:Int, messsage:String){
        println("$messsage ${age*7}")
    }
    //*Lambda Function
    val CalculatorAge2:(Int, String) -> Unit ={age, msg -> println("$msg ${age*7}")};


    //* Trailing lambda
    fun TrailingLambda(msg:String, addFun:()->Int){
        println("$msg ${addFun()}")
    }


    //* Method and functions
    fun printFullName(){
        println("Name: $firstName \n" +
                "Surname: $lastName \n" +
                "Platinum: $isPlatinum")
    }
    fun updateName(newName:String){
        firstName = newName
    }
    fun firstNameLength(){
        println("The length of the first name is: ${firstName.length}")
    }



}

open class Car(var Dimensions:Double, var Doors:Int){

    open fun Speed(minSpeed:Int, maxSpeed:Int){
        println("Min Speed: $minSpeed\n" +
                "Max Speed: $maxSpeed")
    }
    open fun Drive(){
        println("Dimensions: $Dimensions\n" +
                "Doors: $Doors")
    }
}

class Ford(Dimensions: Double, Doors:Int): Car(Dimensions,Doors) {

    override fun Drive(){
        println("VRrRRRIM")
    }
    override fun Speed(minSpeed:Int, maxSpeed:Int){

    }

}