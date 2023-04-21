package leetcode.editor.cn.algos.dfs;

/**
 * 题目：695 岛屿的最大面积
 * @author puppet
 * @since 2022-08-03 23:24:46
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans;
        int count;

        public int maxAreaOfIsland(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        if (count != 0) {
                            ans = Math.max(count, ans);
                            count = 0;
                        }
                        dfs(grid, i, j);
                    }
                }
            }
            // 上述的做法，最后一个岛屿是不会进行比较的，所以需要最后比较一次（只有一个岛屿时，是最后一个岛屿的特例）
            return Math.max(ans, count);
        }

        private void dfs(int[][] grid, int i, int j) {
            // 边界条件，如果超出矩阵边界或者遇到 0，则返回
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return;

            if (grid[i][j] == 1) {
                count++;
                grid[i][j] = 0;
            }
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}