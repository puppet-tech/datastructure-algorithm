package top.puppetdev.da.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：15 三数之和
 *
 * @author puppet
 * @since 2022-07-21 13:26:42
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * @Classification
     * @Tag
     * @Solution
     * @TimeComplexity
     * @SpaceComplexity
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) return new ArrayList<>(0);

            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 0) break;
                if (i != 0 && nums[i - 1] == nums[i]) continue;
                int lp = i + 1, rp = nums.length - 1;
                while (lp != rp) {
                    if (nums[i] + nums[lp] + nums[rp] < 0) lp++;
                    if (nums[i] + nums[lp] + nums[rp] > 0) rp--;
                    if (nums[i] + nums[lp] + nums[rp] == 0) ans.add(List.of(nums[i], nums[lp], nums[rp]));
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}