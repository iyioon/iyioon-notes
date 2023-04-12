import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Function;

public class MazeSolver implements IMazeSolver {
	private static final int TRUE_WALL = Integer.MAX_VALUE;
	private static final int EMPTY_SPACE = 0;
	private static final List<Function<Room, Integer>> WALL_FUNCTIONS = Arrays.asList(
			Room::getNorthWall,
			Room::getEastWall,
			Room::getWestWall,
			Room::getSouthWall
	);

	private static final int[][] DELTAS = new int[][] {
			{ -1, 0 }, // North
			{ 0, 1 }, // East
			{ 0, -1 }, // West
			{ 1, 0 } // South
	};

	private Maze maze;

	public MazeSolver() {
		// TODO: Initialize variables.
	}

	@Override
	public void initialize(Maze maze) {
		this.maze = maze;
	}

	private void checkPreCon(int startRow, int startCol, int endRow, int endCol){
		if (
				startRow < 0 || startRow >= maze.getRows()
						|| startCol < 0 || startCol  >= maze.getColumns()
						|| endRow < 0 || endRow >= maze.getRows()
						|| endCol < 0 || endCol  >= maze.getColumns()
		){
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Integer pathSearch(int startRow, int startCol, int endRow, int endCol) throws Exception {
		checkPreCon(startRow,startCol,endRow,endCol); // Check Argument.

		boolean visited[][] = new boolean[maze.getRows()][maze.getColumns()]; // Store visited nodes
		int weight[][] = new int[maze.getRows()][maze.getColumns()]; // Store the weights of the nodes

		// Queue hold the coordinate of the nodes as well as the weights. eg {1,2,3}.
		// Node at (1,2) has weight 3.
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[2]));
		queue.add(new int[]{startRow,startCol,0});
		weight[startRow][startCol] = 0;
		// Initialize weight to max before starting.
		for (int row = 0; row < maze.getRows(); row++) {
			for (int col = 0; col < maze.getColumns(); col++) {
				weight[row][col] = Integer.MAX_VALUE;
			}
		}

		// Dijkstra's algorithm
		while(!queue.isEmpty()) {
			int[] room = queue.poll(); // Take out the node with min weight.
			visited[room[0]][room[1]] = true; // Set it as visited.

			// If the room is found.
			if (room[0] == endRow && room[1] == endCol) {
				return room[2];
			}

			// Add all outgoing nodes to the queue.
			for (int direction = 0; direction < WALL_FUNCTIONS.size(); direction++) {
				Function<Room, Integer> wallFunction = WALL_FUNCTIONS.get(direction);
				int v = wallFunction.apply(maze.getRoom(room[0],room[1])); // Cost of traveling to direction.
				if (v == 0) v = 1; // Set cost to 1 for empty room.
				if (v != Integer.MAX_VALUE) { // If it is not a wall.
					int r = room[0] + DELTAS[direction][0]; // Get coordinate of the next room.
					int c = room[1] + DELTAS[direction][1];
					if (!visited[r][c]) { // If the room is not visited.
						queue.add(new int[]{r,c,v+room[2]}); // Add to queue with updated weight.
					}
				}
			}
		}
		return null;
	}

	@Override
	public Integer bonusSearch(int startRow, int startCol, int endRow, int endCol) throws Exception {
		// TODO: Find minimum fear level given new rules.
		return null;
	}

	@Override
	public Integer bonusSearch(int startRow, int startCol, int endRow, int endCol, int sRow, int sCol) throws Exception {
		// TODO: Find minimum fear level given new rules and special room.
		return null;
	}

	public static void main(String[] args) {
		try {
			Maze maze = Maze.readMaze("haunted-maze-sample.txt");
			IMazeSolver solver = new MazeSolver();
			solver.initialize(maze);
			//System.out.println(solver.pathSearch(0, 0, 1, 4));
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test(){
		try {
			Maze maze = Maze.readMaze("haunted-maze-sample.txt");
			IMazeSolver solver = new MazeSolver();
			solver.initialize(maze);
			for (int sr = 0; sr < maze.getRows();sr++){
				for (int sc = 0; sc < maze.getColumns();sc++){
					for (int er = 0; er < maze.getRows();er++){
						for (int ec = 0; ec < maze.getColumns();ec++){
							if (sr != er && sc != ec){
								System.out.print("("+sr+","+sc+") -> "+ "("+er+","+ec+"): ");
								System.out.println(solver.pathSearch(sr, sc, er, ec));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
