package org.example.dev.puppet.algorithms.sortion;

/**
 * 求解一个数组的小和
 * @author puppet
 * @since 2022/2/6 10:03 下午
 */
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null | arr.length <= 1) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }
    
    private static int process(int[] arr, int left, int right) {
        // 递归终止条件
        if (left == right) {
            return 0;
        }
        // 去下标中点
        int mid = left + (right - left) >> 1;
        // 假设数组左右两侧均已求出小和，则直接将小和相加后返回
        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }
    
    private static int merge(int[] arr, int left, int mid, int right) {
        // 辅助数组
        int[] help = new int[right - left + 1];
        // lp 和 rp 分别代表左右指针
        int lp = left;
        int rp = mid + 1;
        int i = 0;
        // 小和
        int result = 0;
        while (lp <= mid && rp <= right) {
            // 如果左侧数组中的数小于右侧的数，由于右侧已经是排好序的，故左侧的数会小于右侧之后所有的数
            result += arr[lp] < arr[rp] ? (right - rp + 1) * arr[lp] : 0;
            help[i++] = arr[lp] <= arr[rp] ? arr[lp++] : arr[rp++];
        }
        while (lp <= mid) {
            help[i++] = arr[lp++];
        }
        while (rp <= right) {
            help[i++] = arr[rp++];
        }
        // 将数搬移回原数组
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[left + i1] = help[i1];
        }
        return result;
    }
}
