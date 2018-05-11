package Chapter12_外观模式

/**
 * 外观模式：：为子系统中的一组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 */

class GuPiao{
    fun sell(){
        println("Gupiao sell")
    }

    fun buy(){
        println("Gupiao buy")
    }
}

class Guozhai{
    fun sell(){
        println("Guozhai sell")
    }

    fun buy(){
        println("Guozhai buy")
    }
}

class Fund(val gupiao:GuPiao, val guozhai: Guozhai){

    fun sell(){
        gupiao.sell()
        guozhai.sell()
    }

    fun buy(){
        gupiao.buy()
        guozhai.buy()
    }
}

fun main(args: Array<String>) {
    val fund = Fund(GuPiao(), Guozhai())
    fund.buy()
    fund.sell()
}