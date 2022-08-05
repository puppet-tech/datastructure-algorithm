package top.puppetdev.da.leetcode.editor.cn.algos.bit;

/**
 * 题目：136 只出现一次的数字
 * @author puppet
 * @since 2022-08-05 08:48:54
 */
public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * 核心：位的异或运算，两个数异或，两数相同为 0，不同为 1，且任何数与 0 异或，都等于自身
     * 根据交换律，将所有的数相互异或一遍，则最后的值即为只出现一次的值
     * @TimeComplexity N
     * @SpaceComplexity 1
     * @Classification 算法
     * @Tag 位运算
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = nums[0];
            int length = nums.length;
            for (int i = 1; i < length; i++) {
                ans ^= nums[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}