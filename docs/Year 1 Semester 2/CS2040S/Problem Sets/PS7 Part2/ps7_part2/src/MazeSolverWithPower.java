import java.util.LinkedList;
import java.util.Queue;

public class MazeSolverWithPower implements IMazeSolverWithPower {
	private static final int NORTH = 0, SOUTH = 1, EAST = 2, WEST = 3;
	private Maze maze;
	private static int[][] DELTAS = new int[][] {
			{ -1, 0 }, // North
			{ 1, 0 }, // South
			{ 0, 1 }, // East
			{ 0, -1 } // West
	};

	public MazeSolverWithPower() {
		// TODO: Initialize variables.
	}

	@Override
	public void initialize(Maze maze) {
		this.maze = maze;
	}

	@Override
	public Integer pathSearch(int startRow, int startCol, int endRow, int endCol) throws Exception {
		return pathSearch(startRow,startCol,endRow,endCol,0);
	}

	@Override
	public Integer numReachable(int k) throws Exception {
		int count = 0;
		for (int row = 0; row < maze.getRows(); row++) {
			for (int col = 0; col < maze.getColumns(); col++) {
				if (getmin(row,col)[0] == k) {
					count++;
				}
			}
		}
		return k == 0 ? 1 : count;
	}

	private int[][][][] parent;
	private int[][][][] weight;
	@Override
	public Integer pathSearch(int startRow, int startCol, int endRow,
							  int endCol, int superpowers) throws Exception {
		//System.out.println(startRow+","+startCol+"->"+endRow+","+endCol+" p:"+superpowers);
		checkPreCon(startRow,startCol,endRow,endCol,superpowers);
		boolean found = false;
		boolean[][][] visited = new boolean[maze.getRows()][maze.getColumns()][superpowers+1]; 	// Visited in a level.
		parent = new int[maze.getRows()][maze.getColumns()][superpowers+1][3]; // Parent of a node in a level. [r,c,p]
		weight = new int[maze.getRows()][maze.getColumns()][superpowers+1][1]; // Weight of a node in a level.
		for (int row = 0; row < maze.getRows(); row++) {
			for (int col = 0; col < maze.getColumns(); col++) {
				for (int s = 0; s <= superpowers; s++){
					weight[row][col][s][0] = Integer.MAX_VALUE;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>(); // In format: {r,c,w,s}
		queue.add(new int[]{startRow,startCol,0,superpowers});
		weight[startRow][startCol][superpowers][0] = 0;

		while(!queue.isEmpty()) {
			int[] room = queue.poll(); // Remove first.
			//System.out.println(room[0]+","+room[1]+" "+room[2]+ " "+room[3]);
			visited[room[0]][room[1]][room[3]] = true;
			// Check target.
			if (room[0] == endRow && room[1] == endCol){
				found = true;
			}

			// Add the adjacent nodes to the queue.
			for (int direction = 0; direction < 4; ++direction) {
				if (canGo(room[0], room[1], direction,room[3]) != -1) {
					int nextrow = room[0] + DELTAS[direction][0];
					int nextcol = room[1] + DELTAS[direction][1];
					int level = canGo(room[0], room[1], direction,room[3]);
					if (!visited[nextrow][nextcol][level]) {
						visited[nextrow][nextcol][level] = true;
						queue.add(new int[]{nextrow,nextcol,room[2]+1,level});
						parent[nextrow][nextcol][level][0] = room[0];
						parent[nextrow][nextcol][level][1] = room[1];
						parent[nextrow][nextcol][level][2] = room[3];
						weight[nextrow][nextcol][level][0] = room[2]+1;
					}
				}
			}
		}
		if (found) {
			return getmin(endRow,endCol)[0];
		}
		return null;
	}


	private int[] getmin(int r, int c) {
		int min = Integer.MAX_VALUE;
		int p = 0;
		for (int i = 0;i < weight[0][0].length ;i++) {
			if(weight[r][c][i][0] < min) {
				min = weight[r][c][i][0];
				p = i;
			}
		}
		return new int[]{min,p};
	}

	private int canGo(int row, int col, int dir, int superpowers) {
		if (row + DELTAS[dir][0] < 0 || row + DELTAS[dir][0] >= maze.getRows()) return -1;
		if (col + DELTAS[dir][1] < 0 || col + DELTAS[dir][1] >= maze.getColumns()) return -1;

		switch (dir) {
			case NORTH:
				return !maze.getRoom(row, col).hasNorthWall() ? superpowers : superpowers-1;
			case SOUTH:
				return !maze.getRoom(row, col).hasSouthWall() ? superpowers : superpowers-1;
			case EAST:
				return !maze.getRoom(row, col).hasEastWall() ? superpowers : superpowers-1;
			case WEST:
				return !maze.getRoom(row, col).hasWestWall() ? superpowers : superpowers-1;
		}
		return -1;
	}

	private void checkPreCon(int startRow, int startCol, int endRow, int endCol,int superpowers){
		if (
				startRow < 0 || startRow >= maze.getRows()
						|| startCol < 0 || startCol  >= maze.getColumns()
						|| endRow < 0 || endRow >= maze.getRows()
						|| endCol < 0 || endCol  >= maze.getColumns()
						|| superpowers < 0){
			throw new IllegalArgumentException();
		}
	}

	public static void main(String[] args) {
		try {
			Maze maze = Maze.readMaze("maze-sample.txt");
			IMazeSolverWithPower solver = new MazeSolverWithPower();
			solver.initialize(maze);

			System.out.println(solver.pathSearch(0, 0, 0, 3, 2));
			//MazePrinter.printMaze(maze);

			for (int i = 0; i <= 9; ++i) {
				System.out.println("Steps " + i + " Rooms: " + solver.numReachable(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
