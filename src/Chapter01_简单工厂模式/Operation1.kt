package Chapter01_简单工厂模式

interface Operation1{
    var numberA: Double
    var numberB: Double
    fun getResult(): Double
}

class OperationAdd : Operation1{
    override var numberA: Double = 0.0
    override var numberB: Double = 0.0

    override fun getResult(): Double = numberA + numberB
}

class OperationSub : Operation1{
    override var numberA: Double = 0.0
    override var numberB: Double = 0.0

    override fun getResult(): Double = numberA - numberB
}

class OperationMul : Operation1{
    override var numberA: Double = 0.0
    override var numberB: Double = 0.0

    override fun getResult(): Double = numberA * numberB
}

class OperationDiv : Operation1{
    override var numberA: Double = 0.0
    override var numberB: Double = 0.0

    override fun getResult(): Double = numberA / numberB
}