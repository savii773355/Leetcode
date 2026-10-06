public class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        int maxBal = (m + n) / 2;
        boolean[][][] visited = new boolean[m][n][maxBal + 1];
        
        return dfs(0, 0, 0, grid, visited, m, n);
    }
    
    private boolean dfs(int r, int c, int bal, char[][] grid, boolean[][][] visited, int m, int n) {
        if (grid[r][c] == '(') {
            bal++;
        } else {
            bal--;
        }
        if (bal < 0 || bal >= visited[0][0].length) {
            return false;
        }
        if (r == m - 1 && c == n - 1) {
            return bal == 0;
        }
        if (visited[r][c][bal]) {
            return false;
        }
        visited[r][c][bal] = true;  
        if (r + 1 < m && dfs(r + 1, c, bal, grid, visited, m, n)) {
            return true;
        }
        if (c + 1 < n && dfs(r, c + 1, bal, grid, visited, m, n)) {
            return true;
        }   
        return false;
    }
}
