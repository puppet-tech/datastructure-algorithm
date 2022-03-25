package org.example.array;

/**
 * 寻找两个正序数组的中位数
 * @author puppet
 * @since 2022/3/21 17:38
 */
public class LC4MedianOfTwoSortedArrays {
    /**
     * 算法思想：归并思想
     * 编程技巧：双指针 该做法自己想出来的，但不符合要求，要求时间复杂度为：O(log(M+N))
     * <p>
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

    /*
        上面的解法如果想要将空间复杂度将到 O(1) 可以这样子做：
        不需要合并两个有序数组，只要找到中位数的位置即可。
        由于两个数组的长度已知，因此中位数对应的两个数组的下标之和也是已知的。
        维护两个指针，初始时分别指向两个数组的下标 00 的位置，每次将指向较小值的指针后移一位，
        如果一个指针已经到达数组末尾，则只需要移动另一个数组的指针，直到到达中位数的位置。

        但是这种解法的时间复杂度同样需要达到 O(M+N)

        该怎么去降低这个时间复杂度呢？一般如果时间复杂度为 log 型，会考虑用借用"二分查找"的思想.
        所以这道题也是需要用到"二分查找"的思想的.
     */

    /**
     * 算法思想：二分查找思想（一般时间复杂度为 log 的都可以先想一下二分查找思想）
     * 编程技巧：双指针、递归
     * 查找两个正序数组的中位数，根据中位数的定义，可以转换为在这两个正序数组中查找：
     * 1. 如果 nums1.length + nums2.length 为奇数：第 K 小的值
     * 2. 如果 nums1.length + nums2.length 为偶数：第 K 小的值与第 K + 1 小的值的和的一半
     * @param nums1
     * @param nums2
     * @return
     */
    public static double solve2(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen % 2 == 1) {
            // 说明为奇数
            return getKth(nums1, nums2, 0, 0, totalLen / 2 + 1);
        } else {
            // 说明是偶数
            // 个人不喜欢 ÷2，所以乘以 0.5，这样子也能更直观地看出返回值会被转为 double 类型
            return (getKth(nums1, nums2, 0, 0, totalLen / 2) + getKth(nums1, nums2, 0, 0, totalLen / 2 + 1)) * 0.5;
        }
    }

    /**
     * 获取两个正序数组中的第 k 小的数
     * @param nums1 数组 1
     * @param nums2 数组 2
     * @param lp    数组 1 的指针，指示边界
     * @param rp    数组 2 的指针，指示边界
     * @param k     第 k 小
     * @return
     */
    private static double getKth(int[] nums1, int[] nums2, int lp, int rp, int k) {
        if (lp >= nums1.length || rp >= nums2.length) {
            // 递归终止条件：当数组 nums1 或 nums2 的剩余长度小于 k/2 时，直接返回另一个数组的第 k 小的数
            // 因为根据题意，中位数必然存在，所以可以大胆返回第 k 小的值
            return ((nums1.length - 1) - lp) > ((nums2.length - 1) - rp) ? nums1[lp + k - 1] : nums2[rp + k - 1];
        }
        if (k == 1) {
            // 递归终止条件二：如果 k = 1 时 nums1 和 nums2 的剩余长度不为 0，则比较 nums1 和 nums2 剩余长度中的第一个数，返回较小的数
            return Math.min(nums1[lp], nums2[rp]);
        }

        // 代码美观版本：抽离出该轮要比较的数的索引位置
        // 分别计算出 nums1 和 nums2 该轮要比较的数的为索引位置
        int lIndex = nums1.length - 1 - lp >= k / 2 - 1 ? lp + k / 2 - 1 : nums1.length - 1;
        int rIndex = nums2.length - 1 - rp >= k / 2 - 1 ? rp + k / 2 - 1 : nums2.length - 1;

        // 根据比较结果，更新 k 和 lp 或 rp
        // 边界是 lIndex + 1 或 rIndex + 1
        // k 则用前后边界相减即可得到
        if (nums1[lIndex] <= nums2[rIndex]) {
            return getKth(nums1, nums2, lIndex + 1, rp, k - (lIndex + 1 - lp));
        } else {
            return getKth(nums1, nums2, lp, rIndex + 1, k - (rIndex + 1 - rp));
        }

        // 代码不美观版本：因为没有抽离出该轮要比较的数的索引位置
        // if ((nums1.length - lp) > (k / 2 - 1) && (nums2.length - rp) > (k / 2 - 1)) {
        //     // 如果 nums1 和 nums2 的剩余长度大于 k/2
        //     if (nums1[lp + k / 2 - 1] <= nums2[rp + k / 2 - 1]) {
        //         // 如果 nums1 的剩余长度中的 k/2 的位置的数 小于等于 nums2 剩余长度的 k/2 的位置的数，则更新 lp 和 k
        //         return getKth(nums1, nums2, lp + k / 2, rp, k - k / 2);
        //     } else {
        //         return getKth(nums1, nums2, lp, rp + k / 2, k - k / 2);
        //     }
        // } else if ((nums1.length - lp) < (k / 2 - 1)) {
        //     // 如果 nums1 的剩余长度小于 k/2
        //     if (nums1[nums1.length - 1] <= nums2[rp + k / 2 - 1]) {
        //         // 取 nums1 的最后一个元素与 nums2 剩余长度的 k/2 位置的数进行比较，然后更新 k 和 lp 或 rp
        //         return getKth(nums1, nums2, nums1.length, rp, k - (nums1.length - lp));
        //     } else {
        //         return getKth(nums1, nums2, lp, rp + k / 2, k - k / 2);
        //     }
        // } else {
        //     // 其他情况，其实就是 nums2 的剩余长度小于 k/2
        //     if (nums1[lp + k / 2 - 1] <= nums2[nums2.length - 1]) {
        //         return getKth(nums1, nums2, lp + k / 2, rp, k - k / 2);
        //     } else {
        //         return getKth(nums1, nums2, lp, nums2.length, k - (nums2.length - rp));
        //     }
        // }
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4, 5, 6};
        double result = solve2(nums1, nums2);
        System.out.println(result);
    }
}
