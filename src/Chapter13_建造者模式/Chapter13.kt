package Chapter13_建造者模式

/**
 * 建造者模式（Builder）：：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 */

class Product{
    val partList = ArrayList<String>()

    fun add(part: String){
        partList.add(part)
    }

    fun show(){
        for (part in partList){
            println(part)
        }
    }
}

interface Builder{
    fun buildPartA()
    fun buildPartB()
    fun getResult(): Product
}

class ConcreteBuilder1 : Builder{

    private val product: Product = Product()

    override fun buildPartA() {
        product.add("partA")
    }

    override fun buildPartB() {
        product.add("partB")
    }

    override fun getResult(): Product = product
}

class ConcreteBuilder2 : Builder{

    private val product: Product = Product()

    override fun buildPartA() {
        product.add("partX")
    }

    override fun buildPartB() {
        product.add("partY")
    }

    override fun getResult(): Product = product
}

class Director{
    fun contruct(builder: Builder){
        builder.buildPartA()
        builder.buildPartB()
    }
}

fun main(args: Array<String>) {
    val director = Director()
    val builder1 = ConcreteBuilder1()
    val builder2 = ConcreteBuilder2()
    director.contruct(builder1)
    director.contruct(builder2)
    val result1 = builder1.getResult()
    val result2 = builder2.getResult()
    result1.show()
    result2.show()
}