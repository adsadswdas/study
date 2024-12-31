package jie_kou_exp1;

public class test {
    public static void main(String[] args) {
        // 搞清楚接口新增的三种方法
        AImpl a = new AImpl();
        a.go();
        A.go2();

    }
}

class AImpl implements A{

}