package Chapter14_观察者模式

/**
 * 观察者模式：：定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己
 */

abstract class Observer(val name: String, val subject: Subject){
    abstract fun update()
}

interface Subject{
    fun attach(observer: Observer)
    fun detash(observer: Observer)
    fun notifyObservers()
}

class Boss : Subject{

    val observerList = ArrayList<Observer>()

    override fun attach(observer: Observer) {
        observerList.add(observer)
    }

    override fun detash(observer: Observer) {
        observerList.remove(observer)
    }

    override fun notifyObservers() {
        for(observer in observerList){
            observer.update()
        }
    }
}

class StockObserver(name: String, subject: Subject) : Observer(name, subject){
    override fun update() {
        println("$name + ${subject.javaClass}")
    }
}


fun main(args: Array<String>) {
    val boss = Boss()
    val client1 = StockObserver("alice", boss)
    val client2 = StockObserver("Bob", boss)
    boss.attach(client1)
    boss.attach(client2)
    boss.notifyObservers()

    boss.detash(client1)
    boss.notifyObservers()
}