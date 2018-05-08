package Chapter01_简单工厂模式

class OperationFactory{
    companion object {
        fun createOperate(operate: String): Operation1 =
            when(operate){
                "+" -> OperationAdd()
                "-" -> OperationSub()
                "*" -> OperationMul()
                "/" -> OperationDiv()
                else -> OperationAdd()
            }
    }
}