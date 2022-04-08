package org.example.dev.puppet.algorithm.ideas.backtracking;

/**
 * 八皇后。经典的回溯算法题目。
 * 为什么方法要用 static 呢？理论上应该是成员方法更为合适，但是为了方便用 main 方法进行测试，所用改成了静态方法
 * 详细解析见：https://time.geekbang.org/column/article/74287
 * @author puppet
 * @since 2022/3/8 22:23
 */
public class Demo01EightQueensLCCI {
    
    private static final int[] RESULT = new int[8];
    // private static int[] result = { 0, 3, 4, 5, 7, 2, 6, 1};
    
    public static void solveEightQueens(int row) {
        if (row >= 8) {
            printArray();
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                RESULT[row] = column;
                solveEightQueens(row + 1);
            }
        }
    }
    
    private static boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (RESULT[i] == column) {
                return false;
            }
            if (leftUp >= 0 && RESULT[i] == leftUp) {
                return false;
            }
            if (rightUp < 8 && RESULT[i] == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }
    
    private static void printArray() {
        for (int k : RESULT) {
            for (int j = 0; j < 8; j++) {
                if (k == j) {
                    System.out.print(k);
                } else {
                    System.out.print('*');
                }
            }
            System.out.println();
        }
    }
    
    
    public static void main(String[] args) {
        printArray();
    }
}
