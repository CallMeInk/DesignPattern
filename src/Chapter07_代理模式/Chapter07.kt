package Chapter07_代理模式

data class SchoolGirl(var name: String)

interface IGiveGift{
    fun giveDolls()
    fun giveFlowers()
    fun giceChocolate()
}

class Pursuit(val mm: SchoolGirl) : IGiveGift{
    override fun giveDolls() {
        println("giveDolls")
    }

    override fun giveFlowers() {
        println("giveFlowers")
    }

    override fun giceChocolate() {
        println("giceChocolate")
    }
}

class Proxy(val mm: SchoolGirl) : IGiveGift{

    val gg: Pursuit = Pursuit(mm)

    override fun giveDolls() {
        gg.giveDolls()
    }

    override fun giveFlowers() {
        gg.giveFlowers()
    }

    override fun giceChocolate() {
        gg.giceChocolate()
    }
}

fun main(args: Array<String>) {
    val alice = SchoolGirl("alice")
    val proxy = Proxy(alice)
    proxy.giceChocolate()
    proxy.giveDolls()
    proxy.giveFlowers()
}