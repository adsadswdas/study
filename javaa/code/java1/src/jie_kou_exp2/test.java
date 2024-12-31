package jie_kou_exp2;

public class test {
    public static void main(String[] args) {
        D d = new D();
        d.show1();
        d.show2();
        d.show3();
        dog d2 = new dog();
        d2.go();
    }
}
interface A{
    void show1();

}
interface B{
    void show2();
}
interface C extends A,B{
    void show3();
}
class D implements C{
    @Override
    public void show1() {
        System.out.println("show1");
    }

    @Override
    public void show2() {
        System.out.println("show2");
    }

    @Override
    public void show3() {
        System.out.println("show3");
    }

}
interface A2{
    default void show(){
        System.out.println("a2 show");
    }
}
class Animal{
    public void show(){
        System.out.println("animal show");
    }
}
class dog extends Animal implements A2{
    public void go(){
        show();
        super.show();
        A2.super.show();
    }
}