package Chapter01_简单工厂模式

/**
 * 需求：实现计算器
 * 设计模式：简单工厂模式
 */
fun main(args: Array<String>) {

    //method1
    val numberA = 1.0
    val numberB = 2.0
    val operation = "+"
    println(Operation.getResult(numberA, numberB, operation))

    //method2
    val operation1: Operation1 = OperationFactory.createOperate("+")
    operation1.numberA = 1.0
    operation1.numberB = 2.0
    println(operation1.getResult())
}