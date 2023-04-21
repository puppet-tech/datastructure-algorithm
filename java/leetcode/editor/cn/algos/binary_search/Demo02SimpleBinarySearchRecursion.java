package leetcode.editor.cn.algos.binary_search;

/**
 * 简单二分查找的递归实现
 * <p>
 * 分析：相比非递归，两者基本差不多，虽然递归需要调用系统栈，但由于二分查找的次数很少，
 * 所以哪怕规模很大的数据，也基本不会出现栈溢出。需要注意的是递归终止的条件；
 * 非递归写法相对复杂，但还是比递归效率更高，所以大都用非递归写法。
 * </p>
 * 时间复杂度：O(logN)
 * 空间复杂度：O(1)
 * @author puppet
 * @since 2022/2/15 23:18
 */
public class Demo02SimpleBinarySearchRecursion {
    
    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        return process(arr, low, high, target);
    }
    
    private static int process(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        
        // 注意：位运算的优先级跟加减一致，所以要注意括号
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return process(arr, low, mid - 1, target);
        } else {
            return process(arr, mid + 1, high, target);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 8, 11, 18};
        int result = search(arr, 8);
        System.out.println(result);
    }
}
