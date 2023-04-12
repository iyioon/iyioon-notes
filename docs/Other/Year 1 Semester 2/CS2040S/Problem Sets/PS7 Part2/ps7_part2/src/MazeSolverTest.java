import java.util.LinkedList;
import java.util.Queue;

public class MazeSolverTest implements IMazeSolverWithPower {
    private static final int NORTH = 0, SOUTH = 1, EAST = 2, WEST = 3;
    private static int[][] DELTAS = new int[][] {
            { -1, 0 }, // North
            { 1, 0 }, // South
            { 0, 1 }, // East
            { 0, -1 } // West
    };

    private Maze maze;

    @Override
    public void initialize(Maze maze) {
        this.maze = maze;
        this.weights = new int[maze.getRows()][maze.getColumns()];
        this.visited = new boolean[maze.getRows()][maze.getColumns()];
        this.parentrow = new int[maze.getRows()][maze.getColumns()];
        this.parentcol = new int[maze.getRows()][maze.getColumns()];
        this.coordinates = new LinkedList<>(); // Store the coordinate of Rooms in frontier.
        for (int i = 0; i < maze.getRows(); ++i) {
            for (int j = 0; j < maze.getColumns(); ++j) {
                this.visited[i][j] = false;
                this.parentrow[i][j] = -1;
                this.parentcol[i][j] = -1;
                maze.getRoom(i, j).onPath = false;
            }
        }
    }

    boolean[][] visited;
    int[][] weights;
    int[][] parentrow; // Store the row coordinate of the parent
    int[][] parentcol; // Store the column coordinate of the parent
    Queue<int[]> coordinates;


    @Override
    public Integer pathSearch(int startRow, int startCol, int endRow, int endCol) throws Exception {
        if (!checkPreCon(startRow, startCol, endRow, endCol)){ // If the given inputs are invalid.
            // Run it for arbitary inputs as it may be used on num Reachable
            pathSearch(0,0,0,0);
            return null;
        }
        initialize(maze);
        coordinates.add(new int[]{startRow,startCol,0});
        int[] resultNode = null;

        while (!coordinates.isEmpty()){
            // Find the node with the smallest weight
            int[] min = coordinates.peek();
            for (int[] c: coordinates){
                if (c[2] < min[2]){
                    min = c;
                }
            }
            // If node is the target store it.
            if (min[0] == endRow && min[1] == endCol){
                resultNode = min;
                // Back track.
                int temprow = min[0];
                int tempcol = min[1];
                while (!(temprow == startRow && tempcol == startCol)) {
                    maze.getRoom(temprow,tempcol).onPath = true;
                    int newTemprow = parentrow[temprow][tempcol]; // Set to the next parent
                    tempcol = parentcol[temprow][tempcol];
                    temprow = newTemprow;
                }
                maze.getRoom(startRow,startCol).onPath = true;
            }

            // Remove the node with the smallest weight
            coordinates.remove(min);
            // Mark it as visited.
            visited[min[0]][min[1]] = true;

            // Add the outgoing nodes to the queue.
            for (int direction = 0; direction < 4; ++direction) {
                int nextrow = min[0] + DELTAS[direction][0];
                int nextcol = min[1] + DELTAS[direction][1];
                if (canGo(min[0], min[1], direction) && !visited[nextrow][nextcol]) { // can we go in that direction?
                    coordinates.add(new int[]{nextrow,nextcol,min[2]+1});
                    weights[nextrow][nextcol] = min[2]+1; // For Storing the weights
                    visited[nextrow][nextcol] = true;
                    parentrow[nextrow][nextcol] = min[0];
                    parentcol[nextrow][nextcol] = min[1];
                }
            }
        }
        return resultNode == null ? null : resultNode[2];
    }

    private boolean canGo(int row, int col, int dir) {
        // not needed since our maze has a surrounding block of wall
        // but Joe the Average Coder is a defensive coder!
        if (row + DELTAS[dir][0] < 0 || row + DELTAS[dir][0] >= maze.getRows()) return false;
        if (col + DELTAS[dir][1] < 0 || col + DELTAS[dir][1] >= maze.getColumns()) return false;

        switch (dir) {
            case NORTH:
                return !maze.getRoom(row, col).hasNorthWall();
            case SOUTH:
                return !maze.getRoom(row, col).hasSouthWall();
            case EAST:
                return !maze.getRoom(row, col).hasEastWall();
            case WEST:
                return !maze.getRoom(row, col).hasWestWall();
        }

        return false;
    }
    private boolean checkPreCon(int startRow, int startCol, int endRow, int endCol){
        if (startRow < 0 || startRow >= maze.getRows()) return false;
        if (startCol < 0 || startCol  >= maze.getColumns()) return false;

        if (endRow < 0 || endRow >= maze.getRows()) return false;
        if (endCol < 0 || endCol  >= maze.getColumns()) return false;
        return true;
    }

    @Override
    public Integer numReachable(int k) throws Exception {
        if (k == 0){
            return 1;
        }
        int count = 0;
        for (int row = 0; row < weights.length; row++) {
            for (int col = 0; col < weights[0].length; col++) {
                if (weights[row][col] == k){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public Integer pathSearch(int startRow, int startCol, int endRow,
                              int endCol, int superpowers) throws Exception {
        if (!checkPreCon(startRow, startCol, endRow, endCol)){ // If the given inputs are invalid.
            // Run it for arbitary inputs as it may be used on num Reachable
            pathSearch(0,0,0,0,superpowers);
            return null;
        }

        initialize(maze);
        coordinates.add(new int[]{startRow,startCol,0,superpowers});
        int[] resultNode = null;

        while (!coordinates.isEmpty()){
            // Find the node with the smallest weight
            int[] min = coordinates.peek();
            for (int[] c: coordinates){
                if (c[2] < min[2]){
                    min = c;
                }
            }
            // If node is the target store it.
            if (min[0] == endRow && min[1] == endCol){
                resultNode = min;
                // Back track.
                int temprow = min[0];
                int tempcol = min[1];
                while (!(temprow == startRow && tempcol == startCol)) {
                    maze.getRoom(temprow,tempcol).onPath = true;
                    int newTemprow = parentrow[temprow][tempcol]; // Set to the next parent
                    tempcol = parentcol[temprow][tempcol];
                    temprow = newTemprow;
                }
                maze.getRoom(startRow,startCol).onPath = true;
            }

            // Remove the node with the smallest weight
            coordinates.remove(min);
            // Mark it as visited.
            visited[min[0]][min[1]] = true;

            // Add the outgoing nodes to the queue.
            for (int direction = 0; direction < 4; ++direction) {
                int nextrow = min[0] + DELTAS[direction][0];
                int nextcol = min[1] + DELTAS[direction][1];
                if (canGo(min[0], min[1], direction) && !visited[nextrow][nextcol]) { // can we go in that direction?
                    coordinates.add(new int[]{nextrow,nextcol,min[2]+1,min[3]});
                    weights[nextrow][nextcol] = min[2]+1; // For Storing the weights
                    visited[nextrow][nextcol] = true;
                    parentrow[nextrow][nextcol] = min[0];
                    parentcol[nextrow][nextcol] = min[1];
                } else if(min[3] > 0) { // If it is a wall and have superpower left.
                    try{ // For ignoring non-existing room outside the edge wall.
                        if(!visited[nextrow][nextcol]){
                            coordinates.add(new int[]{nextrow,nextcol,min[2]+1,min[3]-1});
                            weights[nextrow][nextcol] = min[2]+1; // For Storing the weights
                            visited[nextrow][nextcol] = true;
                            parentrow[nextrow][nextcol] = min[0];
                            parentcol[nextrow][nextcol] = min[1];
                        }
                    }catch (Exception e){};
                }
            }
        }
        return resultNode == null ? null : resultNode[2];
    }

    public static void main(String[] args) {
        try {
            Maze maze = Maze.readMaze("maze-sample.txt");
            IMazeSolverWithPower solver = new MazeSolverWithPower();
            solver.initialize(maze);

            System.out.println(solver.pathSearch(-20, -200, 100, 3,10));
            MazePrinter.printMaze(maze);
            //ImprovedMazePrinter.printMaze(maze,0,0);

            for (int i = 0; i <= 9; ++i) {
                System.out.println("Steps " + i + " Rooms: " + solver.numReachable(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
