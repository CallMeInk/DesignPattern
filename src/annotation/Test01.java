package annotation;

/**
 *
 */
public class Test01 {
    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        return super.toString();
    }

    private void metaAnnotation(){
        /**
         * 元注解
         * @Target 描述注解使用范围
         * @Retention 描述注解生命周期
         * @Document 注解将被包含在javadoc中
         * @Inherited 子类可以继承
         */
    }
}
