package leetcode.editor.cn;

/**
 * 题目：165 比较版本号
 * @author puppet
 * @since 2023-02-16 22:26:03
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        Solution solution = new CompareVersionNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int compareVersion(String version1, String version2) {
            // 分别计算两个版本的长度
            int v1Len = version1.length(), v2Len = version2.length();
            int v1Index = 0, v2Index = 0;
            final char dotChar = '.';
            while (v1Index < v1Len || v2Index < v2Len) {
                int v1 = 0;
                for (; v1Index < v1Len && version1.charAt(v1Index) != dotChar; ++v1Index) {
                    v1 = v1 * 10 + version1.charAt(v1Index) - '0';
                }
                v1Index++;
                int v2 = 0;
                for (; v2Index < v2Len && version2.charAt(v2Index) != dotChar; ++v2Index) {
                    v2 = v2 * 10 + version2.charAt(v2Index) - '0';
                }
                v2Index++;
                if (v1 != v2) {
                    return v1 > v2 ? 1 : -1;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}