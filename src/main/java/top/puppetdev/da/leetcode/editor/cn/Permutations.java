package top.puppetdev.da.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：46 全排列
 * @author puppet
 * @since 2023-03-07 23:09:50
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        solution.permute(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final List<List<Integer>> res = new ArrayList<>();
        private boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            visited = new boolean[nums.length];
            backtrack(nums, new ArrayList<>());
            return res;
        }

        private void backtrack(int[] nums, List<Integer> tmp) {
            if (tmp.size() == nums.length) {
                res.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                tmp.add(nums[i]);
                backtrack(nums, tmp);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}