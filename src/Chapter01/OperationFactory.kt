package Chapter01

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