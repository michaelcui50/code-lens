class Solution {

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> sizeMap = createSizeMap(grid);

        // Track the maximum size of any island if we flip one 0
        int maxArea = sizeMap.getOrDefault(2, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighbors = new HashSet<>();
                    if (i > 0) neighbors.add(grid[i-1][j]);
                    if (j > 0) neighbors.add(grid[i][j-1]);
                    if (i+1 < n) neighbors.add(grid[i+1][j]);
                    if (j+1 < n) neighbors.add(grid[i][j+1]);

                    int area = 1;
                    for (int id : neighbors) {
                        area += areaMap.getOrDefault(id, 0);
                    }
                    maxArea = Math.max(maxArea, area);
                }

            }
        }
        return maxArea;

    }

    Map<Integer, Integer> createSizeMap(int[][] grid) {
        int n = grid.length;

        int id = 2;
        Map<Integer, Integer> sizeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, id);
                    sizeMap.put(id, size);
                    id++;
                }
            }
        }
        return sizeMap;
    }

    int dfs(int[][] grid, int x, int y, int id) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = id;
        return 1 + dfs(grid, x + 1, y, id) + dfs(grid, x, y + 1, id) + dfs(grid, x, y - 1, id) + dfs(grid, x - 1, y, id);
    }

}