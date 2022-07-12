package top.puppetdev.da.leetcode.editor.cn.data_structures.string;

/**
 * 罗马数字转整数
 * @author puppet
 * @since 2022/3/27 15:10
 */
public class LC13RomanToInteger {
    /**
     * 算法思想：无
     * 编程技巧：无
     * <p>
     * 核心点：若左边的值(preNum)小于右边的值，则左边的值(preNum)作减法，否则做加法
     * <p>
     * 时间复杂度：O(N) —— N 为字符串长度
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public static int solve(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            // 如果小于右边的值，则直接减去 preNum
            if (preNum < getValue(s.charAt(i))) sum -= preNum;
                // 如果大于右边你的值，则直接加上 preNum
            else sum += preNum;
            // 更新 preNum，即将 preNum 右移一个
            preNum = getValue(s.charAt(i));
        }
        // 最后一个值必然为正，所以直接作加法
        // 同时，如果只有 s.length() == 1，则不会进入 for 循环，直接加上 preNum 即可返回
        sum += preNum;
        return sum;
    }
    
    private static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
