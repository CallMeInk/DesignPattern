package reflection;

import java.lang.annotation.*;

public class Test05 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("reflection.Student");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Table table = (Table) c1.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value);

        java.lang.reflect.Field name = c1.getDeclaredField("name");
        Field annotation = name.getAnnotation(Field.class);
        String s = annotation.columnName();
        String type = annotation.type();
        int length = annotation.length();
        System.out.println(s + type + length);
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field {
    String columnName();

    String type();

    int length();
}
