import java.util.*;

public class MazeSolver implements IMazeSolver {
	private static final int NORTH = 0, SOUTH = 1, EAST = 2, WEST = 3;
	private static int[][] DELTAS = new int[][] {
		{ -1, 0 }, // North
		{ 1, 0 }, // South
		{ 0, 1 }, // East
		{ 0, -1 } // West
	};

	private Maze maze;

	public MazeSolver() {
		// TODO: Initialize variables.
	}

	@Override
	public void initialize(Maze maze) {
		this.maze = maze;
		this.visited = new boolean[maze.getRows()][maze.getColumns()];
		this.parentrow = new int[maze.getRows()][maze.getColumns()];
		this.parentcol = new int[maze.getRows()][maze.getColumns()];
		this.frontier =  new LinkedList<>();
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
	int[][] parentrow; // Store the row coordinate of the parent
	int[][] parentcol; // Store the column coordinate of the parent
	Queue<Room> frontier;
	Queue<int[]> coordinates;
	int startRow;
	int startCol;

	@Override
	public Integer pathSearch(int startRow, int startCol, int endRow, int endCol) throws Exception {

		this.startRow = startRow;
		this.startCol = startCol;
		initialize(maze);
		coordinates.add(new int[]{startRow,startCol});

		while (!coordinates.isEmpty()){
			Queue<int[]> nextC = new LinkedList<>();
			for(int[] c : coordinates){
				visited[c[0]][c[1]] = true;
				if (c[0] == endRow && c[1] == endCol){
					// Back track.
					int temprow = c[0];
					int tempcol = c[1];
					int path = 0;
					while (!(temprow == startRow && tempcol == startCol)) {
						maze.getRoom(temprow,tempcol).onPath = true;
						int newTemprow = parentrow[temprow][tempcol]; // Set to the next parent
						tempcol = parentcol[temprow][tempcol];
						temprow = newTemprow;
						path++;
					}
					maze.getRoom(startRow,startCol).onPath = true;
					return path;
				}
				for (int direction = 0; direction < 4; ++direction) {
					int nextrow = c[0] + DELTAS[direction][0];
					int nextcol = c[1] + DELTAS[direction][1];
					if (canGo(c[0], c[1], direction) && !visited[nextrow][nextcol]) { // can we go in that direction?
						nextC.add(new int[]{nextrow,nextcol});
						visited[nextrow][nextcol] = true;
						parentrow[nextrow][nextcol] = c[0];
						parentcol[nextrow][nextcol] = c[1];
					}
				}
			}
			coordinates = new LinkedList<>(nextC);
		}
		return null;
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

	@Override
	public Integer numReachable(int k) throws Exception {
		if (k == 0) return 1;
		initialize(maze);
		coordinates.add(new int[]{startRow,startCol});
		int depth = 1;
		int reachable = 0;
		while (!coordinates.isEmpty()){
			Queue<int[]> nextC = new LinkedList<>();
			reachable = 0;
			for(int[] c : coordinates){
				visited[c[0]][c[1]] = true;
				for (int direction = 0; direction < 4; ++direction) {
					int nextrow = c[0] + DELTAS[direction][0];
					int nextcol = c[1] + DELTAS[direction][1];
					if (canGo(c[0], c[1], direction) && !visited[nextrow][nextcol]) { // can we go in that direction?
						nextC.add(new int[]{nextrow,nextcol});
						reachable++;
						visited[nextrow][nextcol] = true;
					}
				}
			}
			coordinates = new LinkedList<>(nextC);
			if (depth == k){
				break;
			}
			depth++;
		}
		return reachable;
	}

	public static void main(String[] args) {
		// Do remember to remove any references to ImprovedMazePrinter before submitting
		// your code!
		try {
			Maze maze = Maze.readMaze("maze-empty.txt");
			IMazeSolver solver = new MazeSolver();
			solver.initialize(maze);

			int r = 0, c= 0;
			int er = 3, ec = 3;
			System.out.println(solver.pathSearch(r, c, er,ec ));
			MazePrinter.printMaze(maze);
			//ImprovedMazePrinter.printMaze(maze,r,c);
			for (int i = 0; i <= 9; ++i) {
				System.out.println("Steps " + i + " Rooms: " + solver.numReachable(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
