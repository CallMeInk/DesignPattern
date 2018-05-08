package Chapter02_策略模式

/**
 * 策略加简单工厂
 */
abstract class Strategy{
    abstract fun algorithmInterface()
}
class CashContext{
    var cs: CashSuper? = null

    constructor(type: Int){
        when(type){
            0 -> cs = CashNormal()
            1 -> cs = CashRebate(0.8)
        }
    }

    fun getResult(money: Double) = cs?.acceptCash(money) ?: 0
}

