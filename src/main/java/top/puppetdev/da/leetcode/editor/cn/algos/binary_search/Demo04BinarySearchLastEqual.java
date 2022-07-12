package top.puppetdev.da.leetcode.editor.cn.algos.binary_search;

/**
 * 二分查找变型题：在给定的数组中，查找最后一个等于 `target` 元素，如果存在，则返回下标，否则，返回 `-1`。
 * <p>
 * 时间复杂度：O(logN)
 * 空间复杂度：O(1)
 * @author puppet
 * @since 2022/2/15 23:18
 */
public class Demo04BinarySearchLastEqual {
    
    public static int search(int[] arr, int target) {
        int size = arr.length;
        return process(arr, size, target);
    }
    
    private static int process(int[] arr, int size, int target) {
        // 定义两个指针
        int low = 0;
        int high = size - 1;
        
        while (high >= low) {
            // 注意：位运算的优先级跟加减一致，所以要注意括号
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                if (mid == size - 1 || arr[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        // int[] arr = {1, 3, 4, 5, 6, 8, 11, 18};
        int result = search(arr, 8);
        System.out.println(result);
    }
}
