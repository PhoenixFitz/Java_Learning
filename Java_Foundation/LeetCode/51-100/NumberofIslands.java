package leetcode.klaus;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberofIslands {

    public int numIslands(char grid[][]){
        int m = grid.length;  //row
        if(m == 0)
            return 0;
        int count = 0;
        int n = grid[0].length;// column
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    forSearchIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void forSearchIsland(char grid[][], int i, int j){
        if(i < 0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        forSearchIsland(grid, i - 1, j);
        forSearchIsland(grid, i + 1, j);
        forSearchIsland(grid, i, j + 1);
        forSearchIsland(grid, i, j - 1);
    }
}
