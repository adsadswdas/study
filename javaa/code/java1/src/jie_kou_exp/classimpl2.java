package jie_kou_exp;

public class classimpl2 implements class1{
// 第二套实现类，实现接口：打印学生信息（男女人数），打印平均分（去掉最高分和最低分）
    private Student[] students;
    public classimpl2(Student[] students){
        this.students = students;
    }
    @Override
    public void pritallstu() {
        System.out.println("All students");
        int male = 0;
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            System.out.println("student name: " + student.getName() + " student sex: " + student.getSex() + " student score: " + student.getScore());
            if (student.getSex() == 'M') {
                male++;
            }

        }
        System.out.println("The number of mail students is" + male);
        System.out.println("The number of female students is" + (students.length - male));
    }

    @Override
    public void printscore() {
        System.out.println("All students' scores:");
        double sum = 0;
        double max = 0;
        double min = 100;
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            sum += student.getScore();
            if (student.getScore() > max) {
                max = student.getScore();
            }
            if (student.getScore() < min) {
                min = student.getScore();
            }
        }
        System.out.println("The highest score is: " + max);
        System.out.println("The lowest score is: " + min);
        System.out.println("The average score is: " + (sum - max - min) / (students.length - 2));
    }
}
