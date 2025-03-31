import java.util.*;
import java.io.*;

public class Main {
    static class Block {
        String str;
        int count;
        Block(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        // Convert to blocks
        List<Block> blocks = new ArrayList<>();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        String prev = arr[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i].equals(prev)) {
                count++;
            } else {
                blocks.add(new Block(prev, count));
                prev = arr[i];
                count = 1;
            }
        }
        blocks.add(new Block(prev, count));

        // Compute max_original
        int max_original = 0;
        for (Block block : blocks) {
            if (block.count > max_original) {
                max_original = block.count;
            }
        }

        // Build map: str -> list of counts
        Map<String, List<Integer>> map = new HashMap<>();
        for (Block block : blocks) {
            String s = block.str;
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(block.count);
        }

        // Compute max_merge
        int max_merge = 0;
        for (List<Integer> list : map.values()) {
            if (list.size() < 2) {
                continue;
            }
            int max1 = 0, max2 = 0;
            for (int num : list) {
                if (num > max1) {
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max2 = num;
                }
            }
            int current = max1 + max2;
            if (current > max_merge) {
                max_merge = current;
            }
        }

        System.out.println(Math.max(max_original, max_merge));
    }
}