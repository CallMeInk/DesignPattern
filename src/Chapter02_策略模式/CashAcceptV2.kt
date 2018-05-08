package Chapter02_策略模式

/**
 * 用简单工厂模式实现
 */

abstract class CashSuper{
    abstract fun acceptCash(money: Double):Double
}

//正常收费
class CashNormal: CashSuper(){
    override fun acceptCash(money: Double): Double {
        return money
    }
}

//打折收费
class CashRebate(val cashRebateRate: Double): CashSuper(){

    override fun acceptCash(money: Double): Double {
        return money * cashRebateRate
    }
}

class CashFactory{
    companion object {
        fun createCashAccept(type: Int): CashSuper{
            when(type){
                0 -> return CashNormal()
                1 -> return CashRebate(0.8)
                2 -> return CashRebate(0.7)
                3 -> return CashRebate(0.5)
                else -> return CashNormal()
            }
        }
    }
}