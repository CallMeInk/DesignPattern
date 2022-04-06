package reflection;

@Table("db_student")
public class Student {
    @Field(columnName = "db_id", type = "int", length = 10)
    private int id;
    @Field(columnName = "db_age", type = "int", length = 10)
    private int age;
    @Field(columnName = "db_name", type = "varchar", length = 3)
    private String name;

    public Student(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
