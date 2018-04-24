package Chapter01

/**
 * pros:面向对象
 * cons:若添加开方运算，必须暴露原来的运算规则，也有可能对原来的运算规则进行破坏
 */

class Operation{
    companion object {
        fun getResult(numberA: Double, numberB: Double, operate: String): Double{
            var result = 0.0
            when(operate){
                "+" -> result = numberA + numberB
                "-" -> result = numberA - numberB
                "*" -> result = numberA * numberB
                "/" -> result = numberA / numberB
            }
            return result
        }
    }
}