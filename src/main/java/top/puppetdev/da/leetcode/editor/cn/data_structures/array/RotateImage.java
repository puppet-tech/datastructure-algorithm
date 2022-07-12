package top.puppetdev.da.leetcode.editor.cn.data_structures.array;

/**
 * 题目：48 旋转图像
 * @author puppet
 * @since 2022-05-29 01:02:52
 */
public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * @Tag 数组、数学
     * @Solution 原地旋转
     *         1. 先推导出公式：第 i 行第 j 列个元素 -> 第 j 行倒数第 i 列个元素，即 matrix[i][j] -> matrix[j][n-i-1] 下标从 0 开始
     *         2. 画一个 4*4 矩阵，观察规律，发现某个元素旋转四次之后，就会回到原来的位置
     *         3. 由此根据第一步推导出来的公式，将四次旋转的位置分别用 i、j 表示
     *         4. 借用 temp 变量先将 matrix[i][j] 存起来，逆向思维，将元素位置均放置好
     *         5. 最终解决问题
     *         注意事项：边长为奇数、偶数的情况差异，核心突破点在于分块
     * @TimeComplexity O(N ^ 2) N 为矩阵边长
     * @SpaceComplexity O(1)
     */
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}