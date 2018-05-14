package Chapter24_职责链模式

/**
 * 职责链模式：：使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系。将这个对象连成一条链，
 * 并沿着这条链传递该请求，直到有一个对象处理它为止
 */

abstract class Handler{
    var successor: Handler? = null

    abstract fun handleRequest(request: Int)

}

class ConcreteHandler1: Handler(){
    override fun handleRequest(request: Int) {
        if (request in 0..10){
            println("concrete1 handle the request")
        }else{
            successor?.handleRequest(request)
        }
    }
}

class ConcreteHandler2: Handler(){
    override fun handleRequest(request: Int) {
        println("concrete2 handle the request")
    }
}

fun main(args: Array<String>) {
    val handler1 = ConcreteHandler1()
    val handler2 = ConcreteHandler2()
    handler1.successor = handler2

    val requests = listOf(1, 2, 15)

    for (request in requests){
        handler1.handleRequest(request)
    }

}
