package Chapter15_抽象工厂模式

/**
 * 抽象工厂模式（Abstract Factory）：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类
 */

data class Department(val departmentName: String)
data class User(val userName: String)

interface IUser{
    fun insert(user: User)
    fun getUser(id: Int): User?
}

class SqlserverUser : IUser{
    override fun insert(user: User) {
        println("SqlserverUser insert")
    }

    override fun getUser(id: Int): User? {
        println("SqlserverUser getUser")
        return null
    }
}

class AccessUser : IUser{
    override fun insert(user: User) {
        println("AccessUser insert")
    }

    override fun getUser(id: Int): User? {
        println("AccessUser getUser")
        return null
    }
}

interface IDepartment{
    fun insert(department: Department)
    fun getDepartment(id: Int): Department?
}

class SqlserverDepartment : IDepartment{
    override fun insert(department: Department) {
        println("sql insert")
    }

    override fun getDepartment(id: Int): Department? {
        println("sql getDepartment")
        return null
    }
}

class AccessDepartment : IDepartment{
    override fun insert(department: Department) {
        println("access insert")
    }

    override fun getDepartment(id: Int): Department? {
        println("access getDepartment")
        return null
    }
}

interface IFactory{
    fun createUser(): IUser
    fun createDepartment(): IDepartment
}

class SqlServerFactory : IFactory{
    override fun createUser(): IUser {
        return SqlserverUser()
    }

    override fun createDepartment(): IDepartment {
        return SqlserverDepartment()
    }
}

class AccessFactory : IFactory{
    override fun createUser(): IUser {
        return AccessUser()
    }

    override fun createDepartment(): IDepartment {
        return AccessDepartment()
    }
}

fun main(args: Array<String>) {
    val user: User = User("Alice")
    val department: Department = Department("department one")
    val factory: IFactory = AccessFactory()
    val iuser = factory.createUser()
    iuser.insert(user)
    iuser.getUser(1)
    val idepartment: IDepartment = factory.createDepartment()
    idepartment.insert(department)
    idepartment.getDepartment(1)
}