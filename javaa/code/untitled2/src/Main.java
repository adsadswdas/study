import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 学生人数
        int m = sc.nextInt(); // 课程数

        int[] finalExamScores = new int[n]; // 期末成绩
        for (int i = 0; i < n; i++) {
            finalExamScores[i] = sc.nextInt();
        }

        int[][] attendance = new int[n][m]; // 记录每个学生的出勤情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                attendance[i][j] = sc.nextInt();
            }
        }

        int[] absentCount = new int[n]; // 统计旷课次数

        for (int j = 0; j < m; j++) {
            int k = sc.nextInt(); // 本节课点名的人数
            Set<Integer> calledStudents = new HashSet<>();
            for (int t = 0; t < k; t++) {
                calledStudents.add(sc.nextInt() - 1); // 学生编号从1开始，需要-1
            }

            // 统计旷课情况
            for (int student : calledStudents) {
                if (attendance[student][j] == 0) {
                    absentCount[student]++;
                }
            }
        }

        // 计算最终成绩
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int attendanceScore = Math.max(100 - absentCount[i] * 10, 0);
            double finalScore = attendanceScore * 0.4 + finalExamScores[i] * 0.6;
            students.add(new Student(i + 1, finalScore));
        }

        // 按照最终成绩降序排列，成绩相同按学号升序
        students.sort((a, b) -> {
            if (Double.compare(b.finalScore, a.finalScore) == 0) {
                return Integer.compare(a.id, b.id);
            }
            return Double.compare(b.finalScore, a.finalScore);
        });

        // 输出结果
        for (Student s : students) {
            System.out.printf("%d %.2f\n", s.id, s.finalScore);
        }
    }
    static class Student {
        int id;
        double finalScore;

        Student(int id, double finalScore) {
            this.id = id;
            this.finalScore = finalScore;
        }
    }
}
