package leetcode.editor.cn.algos.binary_search;

/**
 * 题目：69 x 的平方根
 * @author puppet
 * @since 2022-07-27 23:58:49
 */
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * 核心点：ans^2 <= x，在边界 0-x 内不断进行二分查找，判断
     * 1. 算术平方根一定是正整数
     * 2. 注意整型截断问题
     * @TimeComplexity logN
     * @SpaceComplexity 1
     * @Classification 算法
     * @Tag 二分查找、数学
     */
    class Solution {
        public int mySqrt(int x) {
            if (x == 0) return 0;
            int left = 0, right = x, ans = 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                // 注意：要将 mid * mid 转成 long 型，否则可能会发生整数截断，导致答案错误
                if ((long) mid * mid <= x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}