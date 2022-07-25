package top.puppetdev.da.leetcode.editor.cn;

import java.util.Random;

/**
 * 题目：215 数组中的第K个最大元素
 * @author puppet
 * @since 2022-07-24 14:28:59
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * 根据题意，我们假设数组的长度为 n，则要求的是数组排序后的倒数第 k 个位置
     * 思路：
     * <p>
     * 改进快排算法，在进行分治拆分左右部分的时候，判断当前划分到的 q 正好是我们的需要的下标，则可以直接返回 a[q]
     * 如果 q 下标比目标的小，则递归右子区间，否则递归左子区间
     * </p>
     * @TimeComplexity logN
     * @SpaceComplexity N
     * @Classification 算法思想
     * @Tag 快排、数组、分治
     */
    class Solution {
        private int target;
        
        public int findKthLargest(int[] nums, int k) {
            // 求倒数第 K 大，说明该值在排序后的数组中的下边位置为 nums.length - k
            this.target = nums.length - k;
            return quickSelect(nums, 0, nums.length - 1);
        }
        
        private int quickSelect(int[] nums, int left, int right) {
            if (left >= right) return nums[left];
            
            int l = left, r = right;
            int pivot = nums[l];
            
            while (l < r) {
                while (l < r && nums[r] >= pivot) r--;
                nums[l] = nums[r];
                
                while (l < r && nums[l] <= pivot) l++;
                nums[r] = nums[l];
            }
            if (l == target) return pivot;
            // 如果没有返回，则将当前 pivot 赋值回去
            nums[l] = pivot;
            if (l > target) return quickSelect(nums, left, l - 1);
            else return quickSelect(nums, l + 1, right);
        }
        
        private int getRandomNum(int start, int end) {
            return new Random().nextInt(end - start + 1) + start;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}