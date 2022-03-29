package org.example.data.structures.array;

/**
 * 搜索二维矩阵 II
 * @author puppet
 * @since 2022/3/29 22:14
 */
public class LC240SearchA2DMatrixII {
    /**
     * @Tag 数组
     * @Solution 数据观察法
     *         根据题意，可以轻易发现：
     *         如果从矩阵的右上角元素 elem 开始，左边的数比 elem 小，下边的数比 elem 大，那我们可以：
     *         从矩阵的右上角开始搜索，如果 target > elem，则下移，小于，则左移，如果相等，则返回 true
     *         当移出矩阵外，则说明矩阵中没有要查找的元素，返回 false
     * @Tip 无
     * @TimeComplexity O(height + width)
     * @SpaceComplexity O(1)
     */
    public static boolean solve(int[][] matrix, int target) {
        // 先计算出矩阵的宽和高
        int width = matrix[0].length;
        int height = matrix.length;
        // 定位到矩阵右上角的元素（下标）—— 参考横纵坐标轴 x 和 y
        int x = width - 1;
        int y = 0;
        // 只要没有移动到矩阵外边，就一直循环查找
        while (x >= 0 && y < height) {
            // 如果刚好等于，则直接放回 true
            if (matrix[y][x] == target) return true;
            // 排除了刚好等于的情况，进一步判断其他情况
            if (matrix[y][x] < target) y++;
            else x--;
        }
        // 移动到了矩阵外，直接返回 false
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {
                18, 21, 23, 26, 30}};
        int target = 20;
        System.out.println(solve(matrix, target));
    }
}
