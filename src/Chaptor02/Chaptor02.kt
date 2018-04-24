package Chaptor02

/**
 * 商场促销打折、算总价
 * 策略模式(Strategy):它定义了算法家族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化，影响到使用算法的客户
 */

fun main(args: Array<String>) {

    //method1
    println(CashAcceptV1.getTotalPrice(1, 100.0))

    //method2 暴露了CashSuper和CashFactory
    val cashSuper: CashSuper = CashFactory.createCashAccept(1)
    println(cashSuper.acceptCash(100.0))

    //method3 只暴露了CashContext
    val cashContext: CashContext = CashContext(1)
    println(cashContext.getResult(100.0))

}