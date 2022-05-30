package dev.puppet.leetcode.editor.cn.algos.binary_search;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import sun.security.util.Length;

import java.awt.font.NumericShaper;

/**
 * 寻找旋转排序数组中的最小值
 * @author puppet
 * @since 2022/4/4 19:45
 */
public class LC153FindMinimumInRotatedSortedArray {
    /**
     * @Tag 二分查找、迭代、双指针、位运算、剪枝
     * @Solution 核心点：旋转后的数组分为两个部分，两个部分都是正序，右边部分的最大值永远小于左边部分的最小值
     * @Tip
     * @TimeComplexity O(logN)
     * @SpaceComplexity O(1)
     */
    public static int solve(int[] nums) {
        int numsLen = nums.length;
        // 如果最后一个值大于第一个值，所以 nums 整个为正序或 nums.length == 1，则直接放回 nums[0]
        if (nums[numsLen - 1] >= nums[0]) return nums[0];
        // 双指针
        int low = 0, high = numsLen - 1;
        // 迭代运算
        while (low < high) {
            // 取中点，位运算效率更快，但需要注意运算优先级问题
            int pivot = low + ((high - low) >> 1);
            if (nums[pivot] < nums[high]) {
                // 如果当前支点的值比前一个值小，则说明它是最小的 —— 剪枝
                if (nums[pivot] < nums[pivot - 1]) return nums[pivot];
                high = pivot;
            } else {
                // 如果当前中点的值比后一个值大，所以后一个值为最小的 —— 剪枝
                if (nums[pivot] > nums[pivot + 1]) return nums[pivot + 1];
                low = pivot;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        System.out.println(solve(nums));
    }
}
