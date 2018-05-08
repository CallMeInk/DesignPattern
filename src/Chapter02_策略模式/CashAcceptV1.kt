package Chapter02_策略模式

/**
 * pros
 * cons
 */

class CashAcceptV1{
    companion object {
        fun getTotalPrice(priceOffType: Int, originalPrice: Double): Double{
            var cutOffPrice = when(priceOffType){
                                    0 -> originalPrice
                                    1 -> originalPrice * 0.8
                                    2 -> originalPrice * 0.7
                                    3 -> originalPrice * 0.5
                                    else -> originalPrice
                                }
            return cutOffPrice
        }
    }
}