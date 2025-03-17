//import java.io.*;
//
//class Solution {
//    static final int MOD = 1000000007;
//    static final int MAX_N = 1000000;
//    long[] results = new long[MAX_N + 1];
//    int[] spf = new int[MAX_N + 1];
//
//    private void sieve() {
//        // 埃拉托斯特尼筛法初始化最小质因数（smallest prime factor）
//        for (int i = 1; i <= MAX_N; i++) spf[i] = i;
//        for (int i = 2; i * i <= MAX_N; i++) {
//            if (spf[i] == i) { // 如果i是一个质数
//                for (int j = i * i; j <= MAX_N; j += i) {
//                    if (spf[j] == j) spf[j] = i;
//                }
//            }
//        }
//    }
//
//    private long gcdSum(int n) {
//        long total = 0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                int g = gcd(i, j);
//                total = (total + (i + j) / g) % MOD;
//            }
//        }
//        return total;
//    }
//
//    private int gcd(int a, int b) {
//        while (b != 0) {
//            int t = b;
//            b = a % b;
//            a = t;
//        }
//        return a;
//    }
//
//    public void solve() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(reader.readLine().trim()); // 读取测试数据组数
//        sieve(); // 筛选出所有数的最小质因数
//        StringBuilder output = new StringBuilder();
//        for (int t = 0; t < T; t++) {
//            int n = Integer.parseInt(reader.readLine().trim());
//            if (results[n] == 0) {
//                results[n] = gcdSum(n); // 仅当未计算过时才进行计算
//            }
//            output.append(results[n]).append("\n");
//        }
//        System.out.print(output.toString());
//    }
//
//    public static void main(String[] args) throws IOException {
//        new Solution().solve();
//    }
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // 读取测试用例的数量
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            if (n % 3 != 0) {
                System.out.println("-1"); // 如果 n 不是3的倍数，则输出-1
            } else {
                for (int j = 1; j <= n; j++) {
                    System.out.print(j + " "); // 输出从1到n的排列
                }
                System.out.println(); // 换行
            }
        }
        scanner.close();
    }
}


