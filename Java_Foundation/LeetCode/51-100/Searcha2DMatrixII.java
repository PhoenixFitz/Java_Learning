package stage.two.klaus;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */
public class Searcha2DMatrixII {

    /**
     * 观察题目中给的那个例子，我们可以发现有两个位置的数字很有特点，左下角和右上角的数。左下角的18，往上所有的数变小，往右所有数增加，
     * 那么我们就可以和目标数相比较，如果目标数大，就往右搜，如果目标数小，就往上搜。这样就可以判断目标数是否存在。当然我们也可以把起始数放在右上角，
     * 往左和下搜，停止条件设置正确就行。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1])
            return false;
        int i = matrix.length - 1;  //从左下角开始,i表示行，j表示列
        int j = 0;
        while(true){
            if(matrix[i][j] > target)
                i--;
            else if(matrix[i][j] < target)
                j++;
            else
                return true;
            if(i < 0 || j >= matrix[0].length)
                break;
        }
        return false;

    }
}
