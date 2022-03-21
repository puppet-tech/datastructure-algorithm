package org.example.array;

import com.oracle.tools.packager.linux.LinuxRpmBundler;

import java.util.Arrays;

/**
 * 寻找两个正序数组的中位数
 * @author puppet
 * @since 2022/3/21 17:38
 */
public class LC4MedianOfTwoSortedArrays {
    /**
     * 算法思想：归并思想
     * 编程技巧：双指针
     * 该做法自己想出来的，但不符合要求，要求时间复杂度为：O(log(M+N))
     * 时间复杂度：O(M+N)
     * 空间复杂度：O(M+N)
     * @param nums1
     * @param nums2
     * @return
     */
    public static double solve(int[] nums1, int[] nums2) {
        // 计算两个数组的长度和
        int len = nums1.length + nums2.length;
        // 创建一个临时数组，用来存放两个数组的合并结果
        int[] temp = new int[len];
        // 定义两个指针，分别用来遍历 nums1 和 nums2
        int lp = 0, rp = 0, index = 0;
        // 借助归并排序的思想，将两个正序数组合并为一个正序数组
        while (lp < nums1.length && rp < nums2.length) {
            if (nums1[lp] <= nums2[rp]) {
                temp[index] = nums1[lp];
                lp++;
            } else {
                temp[index] = nums2[rp];
                rp++;
            }
            index++;
        }
        // System.out.println("temp is " + Arrays.toString(temp));
        // System.out.println("lp is " + lp);
        // System.out.println("rp is " + rp);
        // System.out.println("index is " + index);
        // 合并剩下的数
        if (lp < nums1.length) {
            while (index < len) {
                temp[index] = nums1[lp];
                index++;
                lp++;
            }
        }
        if (rp < nums2.length) {
            while (index < len) {
                temp[index] = nums2[rp];
                index++;
                rp++;
            }
        }
        // System.out.println("temp is " + Arrays.toString(temp));
        // 位运算，更高效
        int i = temp.length >> 1;
        // 如果为偶数个数
        if (temp.length % 2 == 0) {
            return (Double.valueOf(temp[i - 1]) + Double.valueOf(temp[i])) / 2;
        } else {
            // 如果为奇数个数
            return temp[i];
        }
    }

    public static double solve2(int[] nums1, int[] nums2) {

        return 0.0f;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double result = solve(nums1, nums2);
        System.out.println(result);
    }
}
