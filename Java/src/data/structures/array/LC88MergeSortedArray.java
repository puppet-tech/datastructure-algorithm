package org.example.data.structures.array;

import java.util.Currency;

/**
 * 合并两个有序数组
 * @author puppet
 * @since 2022/3/29 16:51
 */
public class LC88MergeSortedArray {
    /**
     * @Tag 数组、双指针、归并
     * @Solution 逆向双指针
     *         已知 nums1 的长度为 m+n，且 nums1 和 nums2 均为有序，如果采用普通的双指针，则需要借助一个长度 m+n 的额外数组
     *         但是如果我们采用逆向双指针的方式，
     *         从 nums1 和 nums2 的最大值开始比较，向前遍历，取较大的，从后往前填充 nums1 即可解决。
     * @Tip 注意边界条件：均满足
     * @TimeComplexity O(m + n)
     * @SpaceComplexity O(1)
     */
    public static void solve(int[] nums1, int m, int[] nums2, int n) {
        // 定义左右指针，并将其放置在两个数组的最大值位置
        int lp = m - 1, rp = n - 1;
        // 定义一个游标，初始位置指示在 nums1 最后一个位置上
        int cur = nums1.length - 1;
        
        // 因为我们最终要返回的是 nums1，所以我们只需要将 nums2 遍历完就可以了
        while (rp >= 0) {
            // 比较 nums1[lp] 和 nums2[rp]，将较大的填充到 nums1 的后面
            if (lp >= 0 && nums1[lp] > nums2[rp]) {
                nums1[cur] = nums1[lp];
                lp--;
            } else {
                nums1[cur] = nums2[rp];
                rp--;
            }
            // 更新 cur
            cur--;
        }
    }
}
