package leetcode.editor.cn.algos.dfs;

/**
 * 题目：200 岛屿数量
 * @author puppet
 * @since 2022-07-31 00:59:24
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int ans = 0;
            int rows = grid.length;
            int cols = grid[0].length;
            // 遍历每个点
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        ans++;
                        dfs(grid, i, j);
                    }
                }
            }
            return ans;
        }

        private void dfs(char[][] grid, int i, int j) {
            // 如果超出矩阵边界，或者遇到 0，则直接返回
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
            // 将遍历到的点置为 0，避免重复遍历
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
            dfs(grid, i + 1, j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}