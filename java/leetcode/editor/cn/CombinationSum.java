package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：39 组合总和
 * @author puppet
 * @since 2023-03-27 23:43:56
 */
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrack(candidates, target, 0);
            return ret;
        }

        private void backtrack(int[] candidates, int target, int begin) {
            if (target == 0) {
                ret.add(new ArrayList<>(path));
                return;
            }
            if (target < 0) return;
            for (int i = begin; i < candidates.length; i++) {
                path.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}