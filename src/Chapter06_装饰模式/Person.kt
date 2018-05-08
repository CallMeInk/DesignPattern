package Chapter06_装饰模式

open class Person(val name: String){
    open fun show(){
        println("Person::show()")
    }
}

open class Finery(name: String) : Person(name){
    var component: Person? = null

    override fun show() {
        component?.show()
    }
}

class TShirts(name: String) : Finery(name){
    override fun show() {
        println("TShirts")
        super.show()
    }
}

class BigTrouser(name: String) : Finery(name){
    override fun show() {
        println("BigTrouser")
        super.show()
    }
}

fun main(args: Array<String>) {
    val alice = Person("Alice")

    val bt = BigTrouser("Alice")
    val ts = TShirts("Alice")

    bt.component = alice
    ts.component = bt
    ts.show()
}