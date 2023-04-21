package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：78 子集
 * @author puppet
 * @since 2023-03-16 00:15:14
 */
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ret;
        List<Integer> path;

        public List<List<Integer>> subsets(int[] nums) {
            ret = new ArrayList<>();
            path = new ArrayList<>(nums.length);

            backtrack(nums, 0);
            ret.add(new ArrayList<>(0));
            return ret;
        }

        private void backtrack(int[] nums, int depth) {
            if (depth == nums.length) return;
            for (int i = depth; i < nums.length; i++) {
                path.add(nums[i]);
                ret.add(new ArrayList<>(path));
                depth++;
                backtrack(nums, depth);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}