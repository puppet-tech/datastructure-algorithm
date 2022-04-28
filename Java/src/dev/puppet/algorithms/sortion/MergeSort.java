package dev.puppet.algorithms.sortion;

import java.util.Arrays;

/**
 * 归并排序
 * @author puppet
 * @since 2022/2/5 8:49 下午
 */
public class MergeSort {
    public static void solve(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    
    private static void process(int[] arr, int left, int right) {
        // 终止条件
        if (left == right) {
            return;
        }
        // left 和 right 均为 arr 数组的下标，取下标中点位
        // 此处 ((right - left) >> 1) 即为 除以 2
        int mid = left + ((right - left) >> 1);
        // 分治，进入递归
        process(arr, left, mid);
        process(arr, mid + 1, right);
        // 合并数组
        merge(arr, left, mid, right);
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        // lp 即为 left pointer，rp 即为 right pointer
        int lp = left;
        int rp = mid + 1;
        int i = 0;
        while (lp <= mid && rp <= right) {
            // 左右指针还没遍历完所有的元素，则一直持续地进行判断
            help[i++] = arr[lp] <= arr[rp] ? arr[lp++] : arr[rp++];
        }
        while (lp <= mid) {
            // 如果 arr[left...mid] 还有剩余元素，则均加入 help 数组中
            help[i++] = arr[lp++];
        }
        while (rp <= right) {
            // 如果 arr[mid+1...right] 还有剩余元素，则均加入 help 数组中
            help[i++] = arr[rp++];
        }
        // 将数据搬移回原数组
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }
    
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // 长度随机
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        // 值随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
    
    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    
    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    
    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    
    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    // for test
    public static void main(String[] args) {
        int testTimes = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            // 用自己的排序算法排序，例如插入排序
            solve(arr1);
            // 用系统自带的算法测试一遍
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                // 打印 arr1
                printArray(arr1);
                printArray(arr2);
                // 打印 arr2
                succeed = false;
                // 如果不对，则跳出循环，不再测试
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        
        // 常规测试
        // int[] arr = generateRandomArray(maxSize, maxValue);
        // printArray(arr);
        // mergeSort(arr);
        // printArray(arr);
    }
}
