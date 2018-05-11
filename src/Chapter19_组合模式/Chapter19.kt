package Chapter19_组合模式

/**
 * 组合模式：：将对象组合成树形结构以表示'部分-整体'的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性
 */

abstract class Component(val name: String){
    abstract fun add(component: Component)
    abstract fun remove(component: Component)
    abstract fun display(depth: Int)
}

class Leaf(name: String) : Component(name){
    override fun add(component: Component) {
        println("can't add to a leaf")
    }

    override fun remove(component: Component) {
        println("can't remove to a leaf")
    }

    override fun display(depth: Int) {
        for (i in 0..depth){
            print("-")
        }
        println(name)
    }
}

class Composite(name: String) : Component(name){

    val children = ArrayList<Component>()

    override fun add(component: Component) {
        children.add(component)
    }

    override fun remove(component: Component) {
        children.remove(component)
    }

    override fun display(depth: Int) {
        for (i in 0..depth){
            print("-")
        }
        println(name)
        for (child in children){
            child.display(depth + 2)
        }
    }
}

fun main(args: Array<String>) {

    val root = Composite("root")
    root.add(Leaf("leaf A"))
    root.add(Leaf("leaf B"))

    val composite1 = Composite("composite X")
    composite1.add(Leaf("XA"))
    composite1.add(Leaf("XB"))
    root.add(composite1)

    val composite2 = Composite("composite Y")
    composite2.add(Leaf("XYA"))
    composite2.add(Leaf("XYB"))

    composite1.add(composite2)

    root.display(1)

}