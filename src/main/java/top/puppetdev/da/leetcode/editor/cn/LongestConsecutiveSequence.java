package top.puppetdev.da.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：128 最长连续序列
 * @author puppet
 * @since 2022-07-21 23:19:35
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * See LeetCode answer parsing
     * @TimeComplexity N need careful consideration
     * @SpaceComplexity N
     * @Classification hashmap
     * @Tag
     */
    class Solution {
        public int longestConsecutive(int[] nums) {
            // put all elements of nums into the hashmap to reduce the time complexity of search
            Set<Integer> integers = new HashSet<>();
            for (int num : nums) integers.add(num);
            // define a variable to record the answer
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                // the brush of magic!!! to reduce time complexity
                if (integers.contains(nums[i] - 1)) continue;

                int y = 1;
                while (integers.contains(nums[i] + y)) {
                    y++;
                }
                ans = Math.max(y, ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}