package leetcode.editor.cn.algos.other;

/**
 * 题目：169 多数元素
 * @author puppet
 * @since 2022-07-21 22:46:34
 */
public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 该思路非常巧妙，借助具体的算法可以在时间复杂度为 O(N)，空间复杂度为 O(1) 的情况下解决
     * Boyer-Moore vote algorithm
     * 1. maintain a candidate and a variable "count", "count" records the number of occurrences of "candidate"
     * in the initial state, "candidate" can be any value and "count" will be zero.
     * 2. traverse the array. every element will be compared with "candidate"
     * if it is equal to the candidate, the "count" plus 1, or minus 1
     * but before compared with candidate, we should Determine if count is 0,
     * if it is 0, assign the current element to candidate, and then compare
     * 3. finally, the candidate is the result
     * @TimeComplexity N
     * @SpaceComplexity 1
     * @Classification algorithm
     * @Tag array
     */
    class Solution {
        public int majorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) candidate = nums[i];
                if (nums[i] == candidate) count++;
                else count--;
            }
            return candidate;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}