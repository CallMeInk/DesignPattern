package Chapter08_工厂方法

/**
 *  工厂方法模式：定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到子类
 */

import Chapter01_简单工厂模式.Operation1
import Chapter01_简单工厂模式.OperationAdd
import Chapter01_简单工厂模式.OperationSub

interface IFactory{
    fun createOperation(): Operation1
}

class AddFactory: IFactory{
    override fun createOperation(): Operation1 {
        return OperationAdd()
    }
}

class SubFactory: IFactory{
    override fun createOperation(): Operation1 {
        return OperationSub()
    }
}

fun main(args: Array<String>) {
    val operFactory = AddFactory()
    val oper = operFactory.createOperation()
    oper.numberA = 1.0
    oper.numberB = 2.0
    println(oper.getResult())
}