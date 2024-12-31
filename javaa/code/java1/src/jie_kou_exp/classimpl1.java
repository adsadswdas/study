package jie_kou_exp;

public class classimpl1 implements class1{
    private Student[] students;
    public classimpl1(Student[] students){
        this.students = students;
    }

    @Override
    public void pritallstu() {
        System.out.println("All students:");
        for(int i = 0; i < students.length; i++){
            Student student = students[i];
            System.out.println("student name: " + student.getName() +" student sex: " + student.getSex() + " student score: " + student.getScore());
        }
    }

    @Override
    public void printscore() {
        System.out.println("All students' scores:");
        double sum = 0;
        for(int i = 0; i < students.length; i++){
            Student student = students[i];
            sum += student.getScore();
        }
        System.out.println("The average score is: " + sum/students.length);
    }
}
