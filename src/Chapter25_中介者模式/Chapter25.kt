package Chapter25_中介者模式

/**
 * 中介者模式：：用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显示的相互引用，从而使其耦合松散，
 * 而且可以独立的改变它们之间的交互
 */


//抽象的中介者类
abstract class Mediator{
    abstract fun send(message: String, colleague: Colleague)
}

//抽象同事类
abstract class Colleague(val mediator: Mediator){

}

class ConcreteColleague1(mediator: Mediator): Colleague(mediator){

    fun send(string: String){
        mediator.send(string, this)
    }

    fun notifyOthers(message: String){
        println("concrete1 notify $message")
    }

}

class ConcreteColleague2(mediator: Mediator): Colleague(mediator){

    fun send(string: String){
        mediator.send(string, this)
    }

    fun notifyOthers(message: String){
        println("concrete2 notify $message")
    }

}

class ConcreteMediator: Mediator(){

    var colleague1: ConcreteColleague1? = null
    var colleague2: ConcreteColleague2? = null

    override fun send(message: String, colleague: Colleague) {
        if (colleague == colleague1){
            colleague1?.notifyOthers(message)
        }else if (colleague == colleague2){
            colleague2?.notifyOthers(message)
        }
    }
}

fun main(args: Array<String>) {
    val mediator = ConcreteMediator()
    val c1 = ConcreteColleague1(mediator)
    val c2 = ConcreteColleague2(mediator)

    mediator.colleague1 = c1
    mediator.colleague2 = c2

    c1.send("c1")
    c2.send("c2")
}