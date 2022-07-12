package top.puppetdev.da.leetcode.editor.cn.algo_ideas.math;

/**
 * 回环数
 * @author puppet
 * @since 2022/3/26 12:13
 */
public class LC9PalindromeNumber {
    /**
     * 算法思想：无
     * 编程技巧：双指针
     * <p>普通解法
     * 将整数 x 转为 char 型数组 chars，利用两个指针 lp 和 rp，分别从数组的开头和结尾开始遍历：
     * lp 向右移，rp 向左移，直到两个指针相互接触，遍历判断 chars[lp] 与 chars[rp] 是否相等
     * 如果均相等，则说明是回环数，否则不是
     * <p>
     * 时间复杂度：O(N)，N 为 x 转换为 数组后的长度
     * 空间复杂度：O(N)，N 为 x 转换为 数组后的长度
     * @param x
     * @return
     */
    public static boolean solve(int x) {
        // 先整数转换为 char[]
        char[] chars = String.valueOf(x).toCharArray();
        // 定义两个指针，分别从 0 和 length - 1 开始
        int lp = 0, rp = chars.length - 1;
        while (rp >= lp) {
            if (chars[lp] != chars[rp]) {
                return false;
            }
            // 更新 lp 和 rp，使 lp 右移，rp 左移
            lp++;
            rp--;
        }
        return true;
    }
    
    /**
     * 算法思想：无
     * 编程技巧：无
     * <p>利用数学运算，反转后一半数字，跟前一半对比 —— 这种方法更快（虽然更上面 solve 方法差不多）、更节省空间
     * 首先、需要注意边界情况：
     * 1. x 大于 0
     * 2. x 不能被 0 整除，但 0 除外。因为 0123210 不存在
     * 其次，如何知道已经翻转了一半的数字了呢？
     * 当 x <= revertedNum 时，说明已经翻转一半
     * 最后，详细思路不知道如何表达，看代码
     * <p>
     * 时间复杂度：O(log(n))，n 为 x 的大小
     * 空间复杂度：O(1)
     * @param x
     * @return
     */
    public static boolean solve1(int x) {
        // 边界条件
        if (x < 0) return false;
        if (x != 0 && x % 10 == 0) return false;
        
        int revertedNum = 0;
        while (x > revertedNum) {
            // 更新 revertedNum 和 x
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        
        // 对于一个回环数来说，如果位数为偶数，则最终 x == revertedNum，如果是奇数，则 x == revertedNum / 10
        return x == revertedNum || x == revertedNum / 10;
    }
}
