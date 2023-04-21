package leetcode.editor.cn;

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
        int[] nums = new int[]{0, 0, 0, 0};
        solution.threeSum(nums);
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
            if (nums == null || nums.length < 3) return List.of();

            List<List<Integer>> ans = new ArrayList<>();
//            if ((nums.length == 3) && (Arrays.stream(nums).sum() == 0)) {
//                ans.add(List.of(nums[0], nums[1], nums[2]));
//                return ans;
//            }
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) break;
                if (i != 0 && nums[i - 1] == nums[i]) continue;
                int lp = i + 1, rp = nums.length - 1;
                while (lp < rp) {
                    int sum = nums[i] + nums[lp] + nums[rp];
                    if (sum < 0) lp++;
                    else if (sum > 0) rp--;
                    else {
                        ans.add(List.of(nums[i], nums[lp], nums[rp]));
                        while (lp < rp && nums[lp] == nums[lp + 1]) lp++;
                        while (lp < rp && nums[rp] == nums[rp - 1]) rp--;
                        lp++;
                        rp--;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}