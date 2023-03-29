package top.puppetdev.da.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：39 组合总和
 * @author puppet
 * @since 2023-03-27 23:43:56
 */
public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrack(candidates, target);
            return ret;
        }

        private void backtrack(int[] candidates, int target) {

            for (int i = 0; i < candidates.length; i++) {
                path.add(candidates[i]);
                target -= candidates[i];
                if (target == 0) {
                    ret.add(new ArrayList<>(path));
                    return;
                }
                if (target < 0) {
                    path.remove(path.size() - 1);
                    target += candidates[i];
                    continue;
                }
                backtrack(candidates, target);
                path.remove(path.size() - 1);
                target += candidates[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}