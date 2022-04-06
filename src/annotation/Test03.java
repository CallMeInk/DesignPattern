package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test03 {
    @MyAnnotation(name = "test", schools = {"school1"})
    public void test() {

    }
}


@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String name() default "default";
    int age() default 0;
    int id() default 1;
    String[] schools();
}