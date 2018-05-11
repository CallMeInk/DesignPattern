package Chapter17_适配器模式

/**
 * 适配器模式：：将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得由于接口不兼容而不能一起工作的那些类可以一起工作
 */

open class Target{
    open fun request(){
        println("target request")
    }
}

class Adaptee{
    fun specifyRequest(){
        println("adaptee specify request")
    }
}

class Adapter : Target(){

    private val adaptee = Adaptee()

    override fun request() {
        adaptee.specifyRequest()
    }
}

fun main(args: Array<String>) {
    val target = Adapter()
    target.request()
}