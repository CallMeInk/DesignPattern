package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test03 {

    public static void test01() {
        User user = new User();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            String name = user.getName();
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }

    public static void test02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = Class.forName("reflection.User");
        Method getName = c1.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            Object invoke = getName.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }

    public static void test03() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = Class.forName("reflection.User");
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            Object invoke = getName.invoke(user, null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }

}
