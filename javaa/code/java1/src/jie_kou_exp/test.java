package jie_kou_exp;


public class test {
    public static void main(String[] args) {
        // 1. 定义学生类，创建学生对象，封装学生数据
        // 2. 准备学生数据
        Student[] allstu = new Student[10];

        // 初始化学生对象
        allstu[0] = new Student("Alice", 'F', 85.5);
        allstu[1] = new Student("Bob", 'M', 90.0);
        allstu[2] = new Student("Charlie", 'M', 78.0);
        allstu[3] = new Student("Diana", 'F', 92.5);
        allstu[4] = new Student("Eve", 'F', 88.0);
        allstu[5] = new Student("Frank", 'M', 75.5);
        allstu[6] = new Student("Grace", 'F', 80.0);
        allstu[7] = new Student("Hank", 'M', 85.0);
        allstu[8] = new Student("Ivy", 'F', 91.0);
        allstu[9] = new Student("Jack", 'M', 89.5);


        //提供两套业务实现方案，支持灵活切换
        class1 cdi = new classimpl2(allstu);
        cdi.printscore();
        cdi.pritallstu();
    }
}