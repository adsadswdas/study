import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入节点数和询问次数
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        // 父节点数组，father[0]为根节点，值为0
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = scanner.nextInt() - 1; // 索引从0开始
        }

        // 节点上的字母
        char[] letters = scanner.next().toCharArray();

        // 用于查询的路径
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt() - 1; // 起点
            queries[i][1] = scanner.nextInt() - 1; // 终点
        }

        // 求解
        for (int i = 0; i < q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            // 如果u和v相同，直接输出YES
            if (u == v) {
                System.out.println("YES");
                continue;
            }

            // 找到u和v的最近公共祖先（LCA）
            int lca = findLCA(u, v, father);

            // 检查从u到lca和从v到lca的路径上是否存在子序列"BUG"
            if (hasBug(u, lca, father, letters) || hasBug(v, lca, father, letters)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    // 找到两个节点的最近公共祖先（LCA）
    private static int findLCA(int u, int v, int[] father) {
        Set<Integer> ancestors = new HashSet<>();
        while (u != -1) { // 收集u的所有祖先
            ancestors.add(u);
            u = father[u];
        }
        while (v != -1) { // 查找v的祖先中第一个出现在u的祖先中的节点
            if (ancestors.contains(v)) {
                return v;
            }
            v = father[v];
        }
        return -1; // 不应该出现，因为树是有根的
    }

    // 检查从节点u到祖先lca的路径上是否存在子序列"BUG"
    private static boolean hasBug(int u, int lca, int[] father, char[] letters) {
        int bugIndex = 0; // 当前匹配到"BUG"的哪个字符
        while (u != -1) {
            if (u == lca) break; // 到达LCA停止
            char letter = letters[u];
            if (letter == "BUG".charAt(bugIndex)) { // 匹配"BUG"中的字符
                bugIndex++;
                if (bugIndex == 3) { // 匹配完成"BUG"
                    return true;
                }
            }
            u = father[u]; // 向上移动到父节点
        }
        return false;
    }
}