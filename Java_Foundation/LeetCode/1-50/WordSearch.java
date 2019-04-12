package stage.one.klaus;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch {

    /**
     * 这道题是典型的深度优先遍历DFS的应用，原二维数组就像是一个迷宫，可以上下左右四个方向行走，我们以二维数组中每一个数都作为起点和给定字符串做匹配，
     * 我们还需要一个和原数组等大小的visited数组，是bool型的，用来记录当前位置是否已经被访问过，因为题目要求一个cell只能被访问一次。
     * 如果二维数组board的当前字符和目标字符串word对应的字符相等，则对其上下左右四个邻字符分别调用DFS的递归函数，只要有一个返回true，
     * 那么就表示可以找到对应的字符串，否则就不能找到，还可以不用visited数组，直接对board数组进行修改，将其遍历过的位置改为井号，
     * 记得递归调用完后需要恢复之前的状态
     */
    public boolean exist(char[][] board, String word) {
        int y = board.length;  //二维数组的 行
        int x = board[0].length;  //二位数组的 列
        for(int i = 0; i < y; i++)
            for(int j = 0; j < x; j++){
                if(search(board, word, i, j, 0))
                    return true;
            }
        return false;


    }

    public boolean search(char[][] nums, String word, int y, int x, int index){
        if(index == word.length())
            return true;
        if(y < 0 || x < 0 || y == nums.length || x == nums[0].length || nums[y][x] != word.charAt(index))
            return false;
        char c = nums[y][x];
        nums[y][x] = '#';
        boolean res = search(nums, word, y - 1, x, index + 1) ||
                      search(nums, word, y + 1, x, index + 1) ||
                      search(nums, word, y, x - 1, index + 1) ||
                      search(nums, word, y, x + 1, index + 1);
        nums[y][x] = c;
        return res;
    }
}
