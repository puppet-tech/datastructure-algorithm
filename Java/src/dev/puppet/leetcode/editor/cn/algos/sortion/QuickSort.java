package dev.puppet.leetcode.editor.cn.algos.sortion;

import java.util.Arrays;

/**
 * 快速排序
 * @author puppet
 * @since 2022/2/5 8:49 下午
 */
public class QuickSort {
    public static void solve(int[] arr, int start, int end) {
        if (arr.length <= 1 || arr == null) {
            return;
        }
        if (start >= end) {
            return;
        }
        int pivot = arr[start];
        int p = start;
        int r = end;
        while (p < r) {
            while (p < r) {
                if (arr[r] < pivot) {
                    arr[p] = arr[r];
                    break;
                }
                r--;
            }
            while (p < r) {
                if (arr[p] > pivot) {
                    arr[r] = arr[p];
                    break;
                }
                p++;
            }
        }
        arr[p] = pivot;
        solve(arr, start, p - 1);
        solve(arr, p + 1, end);
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
            solve(arr1, 0, arr1.length - 1);
            // 用系统自带的算法测试一遍
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                // 打印 arr1
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
        // quickSort(arr, 0, arr.length - 1);
        // printArray(arr);
    }
}
