package jie_kou_exp1;

public interface A {
    // 1、默认方法（普通实例方法） 必须使用default修饰
    // 默认用public修饰
    // 如何调用：实现类对象.方法名()
    default void go(){
        System.out.println("A go");
        go1();
    }

    // 2、私有方法
    // 私有方法只能在接口内部使用
    // 使用接口中的其他方法调用私有方法
    private void go1(){
        System.out.println("A go1");
    }

    // 3、静态方法
    // 默认用public修饰
    // 如何调用：用当前接口名调用，如A.go2()
    static void go2(){
        System.out.println("A go2");
    }
}
