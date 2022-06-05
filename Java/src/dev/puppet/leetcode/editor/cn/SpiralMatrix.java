package dev.puppet.leetcode.editor.cn;

import org.omg.CORBA.RepositoryIdHelper;

import java.lang.reflect.WildcardType;
import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.List;

/**
 * 题目：54 螺旋矩阵
 * @author puppet
 * @since 2022-05-31 16:28:53
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * @Tag 数组、模拟
     * @Solution 按层模拟
     * @TimeComplexity O(MN) 长宽的积
     * @SpaceComplexity O(1)
     */
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            // 边界情况
            int rows = matrix.length, cols = matrix[0].length;
            // 存放遍历后的结果
            ArrayList<Integer> order = new ArrayList<>(rows * cols);
            int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
            while (left <= right && top <= bottom) {
                for (int col = left; col <= right; col++) {
                    order.add(matrix[top][col]);
                }
                for (int row = top + 1; row <= bottom; row++) {
                    order.add(matrix[row][right]);
                }
                for (int col = right - 1; col > left; col--) {
                    order.add(matrix[bottom][col]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return order;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}