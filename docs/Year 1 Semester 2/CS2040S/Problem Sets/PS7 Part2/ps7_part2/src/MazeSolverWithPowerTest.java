import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MazeSolverWithPowerTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/** Power Tests **/
	@Test
	public void testDenseMazeWithPower() {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
		
		try {
			mazeSolver.initialize(Maze.readMaze("maze-dense.txt"));
			int [] comp = new int[16];

			for (int sr=0;sr<=3;++sr) {
				for (int sc=0;sc<=3;++sc) {
					for (int power=0;power<=4;++power) {
						for (int i=0;i<16;++i) comp[i] = 0;

						for (int er=0;er<=3;++er) {
							for (int ec=0;ec<=3;++ec) {
								int ans;
								ans = (int)(Math.abs(sr-er) + Math.abs(sc-ec));
								if (ans <= power) {
									assertEquals(ans, (int)mazeSolver.pathSearch(sr, sc, er, ec, power));
									comp[ans]++;
								} else {
									assertNull(mazeSolver.pathSearch(sr, sc, er, ec, power));
								}
							}
						}

						for (int i=0;i<16;++i) {
							assertEquals(comp[i], (int)mazeSolver.numReachable(i));
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true); // no exception should be thrown
		}
	}

	@Test
	public void testSpiralWithPower() {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
		
		try {
			mazeSolver.initialize(Maze.readMaze("maze-spiral.txt"));
			int[]pre;
			
			assertEquals(16, (int)mazeSolver.pathSearch(2,2,0,4,0));
			assertEquals(24, (int)mazeSolver.pathSearch(4,0, 2,2,0));
			assertEquals(24, (int)mazeSolver.pathSearch(2,2,4,0,0));
			assertEquals(16, (int)mazeSolver.pathSearch(0,4,2,2,0));

			assertEquals(6, (int)mazeSolver.pathSearch(2,2,0,4,1));
			assertEquals(10, (int)mazeSolver.pathSearch(4,0, 2,2,1));
			assertEquals(10, (int)mazeSolver.pathSearch(2,2,4,0,1));
			assertEquals(6, (int)mazeSolver.pathSearch(0,4,2,2,1));
			
			pre = new int[]{1,2,3,4,4,4,4,2,1,0,0,0,0,0,0,0,0,0,0,0};
			for (int i=0;i<20;++i) {
				assertEquals(pre[i], (int)mazeSolver.numReachable(i));
			}

			assertEquals(4, (int)mazeSolver.pathSearch(2,2,0,4,2));
			assertEquals(4, (int)mazeSolver.pathSearch(4,0, 2,2,2));
			assertEquals(4, (int)mazeSolver.pathSearch(2,2,4,0,2));
			assertEquals(4, (int)mazeSolver.pathSearch(0,4,2,2,2));
			
			pre = new int[]{1,2,3,4,5,4,3,2,1,0,0,0,0,0,0,0,0,0,0,0};
			for (int i=0;i<20;++i) {
				assertEquals(pre[i], (int)mazeSolver.numReachable(i));
			}

			
			assertEquals(4, (int)mazeSolver.pathSearch(2,2,0,4,3));
			assertEquals(4, (int)mazeSolver.pathSearch(4,0, 2,2,3));
			assertEquals(4, (int)mazeSolver.pathSearch(2,2,4,0,3));
			assertEquals(4, (int)mazeSolver.pathSearch(0,4,2,2,3));

			pre = new int[]{1,2,3,4,5,4,3,2,1,0,0,0,0,0,0,0,0,0,0,0};
			for (int i=0;i<20;++i) {
				assertEquals(pre[i], (int)mazeSolver.numReachable(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true); // no exception should be thrown
		}
	}

	@Test
	public void testMymazeWithPower() {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
		
		try {
			mazeSolver.initialize(Maze.readMaze("mymaze.txt"));
			int[]pre;
			
			assertNull(mazeSolver.pathSearch(0,0,2,1,0));

			assertEquals(13, (int)mazeSolver.pathSearch(0,0,4,1,0));

			assertEquals(3, (int)mazeSolver.pathSearch(0,0,2,1,1));
			assertEquals(6, (int)mazeSolver.pathSearch(0,0,3,1,1));
			assertEquals(7, (int)mazeSolver.pathSearch(0,0,4,1,1));
			assertEquals(14, (int)mazeSolver.pathSearch(0,0,4,2,1));
			assertNull(mazeSolver.pathSearch(0,0,4,3,1));

			pre = new int[]{1,2,3,3,1,1,2,2,2,2,1,0,1,2,1,0,0,0,0,0};
			for (int i=0;i<20;++i) {
				assertEquals(pre[i], (int)mazeSolver.numReachable(i));
			}

			assertEquals(3, (int)mazeSolver.pathSearch(0,0,2,1,2));
			assertEquals(4, (int)mazeSolver.pathSearch(0,0,3,1,2));
			assertEquals(5, (int)mazeSolver.pathSearch(0,0,4,1,2));
			assertEquals(8, (int)mazeSolver.pathSearch(0,0,4,2,2));
			
			pre = new int[]{1,2,3,4,4,2,2,3,2,2,2,1,0,0,1,1,0,0,0,0};
			for (int i=0;i<20;++i) {
				assertEquals(pre[i], (int)mazeSolver.numReachable(i));
			}

			assertEquals(6, (int)mazeSolver.pathSearch(0,0,4,2,3));
			assertEquals(9, (int)mazeSolver.pathSearch(0,0,4,3,3));
			assertEquals(8, (int)mazeSolver.pathSearch(0,0,3,3,3));
			pre = new int[]{1,2,3,4,4,4,3,3,3,2,2,1,0,0,0,0,0,0,0,0};
			for (int i=0;i<20;++i) {
				assertEquals(pre[i], (int)mazeSolver.numReachable(i));
			}
			
			assertEquals(5, (int)mazeSolver.pathSearch(0,0,4,1,4));
			assertEquals(6, (int)mazeSolver.pathSearch(0,0,4,2,4));
			assertEquals(7, (int)mazeSolver.pathSearch(0,0,4,3,4));
			assertEquals(6, (int)mazeSolver.pathSearch(0,0,3,3,4));
			
			pre = new int[]{1,2,3,4,4,4,4,4,3,2,1,0,0,0,0,0,0,0,0,0};
			for (int i=0;i<20;++i) {
				assertEquals(pre[i], (int)mazeSolver.numReachable(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true); // no exception should be thrown
		}
	}

	
	/** Original Tests **/
	@Test
	public void testPathWithoutInitialize() throws Exception {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
	    exception.expect(Exception.class);
		mazeSolver.pathSearch(0, 0, 0, 0);
	}

	@Test
	public void testInvalidPathSearchCoordinate() throws Exception {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
		mazeSolver.initialize(Maze.readMaze("maze-empty.txt"));
	    exception.expect(Exception.class);
		mazeSolver.pathSearch(0, 0, 3, 4);
	}
	
	@Test
	public void testNumReachableWithoutPathSearch() throws Exception {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
		mazeSolver.initialize(Maze.readMaze("maze-empty.txt"));
		exception.expect(Exception.class);
		mazeSolver.numReachable(1);
	}

	@Test
	public void testEmptyAndDenseMaze() {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
		
		try {
			mazeSolver.initialize(Maze.readMaze("maze-empty.txt"));
			int [] comp = new int[16];
			
			for (int sr=0;sr<=3;++sr) {
				for (int sc=0;sc<=3;++sc) {

					for (int i=0;i<16;++i) comp[i] = 0;

					for (int er=0;er<=3;++er) {
						for (int ec=0;ec<=3;++ec) {
							// on an empty graph, we calculate Manhattan distance
							int ans = (int)(Math.abs(sr-er) + Math.abs(sc-ec));
							assertEquals(ans, (int)mazeSolver.pathSearch(sr, sc, er, ec));
							
							comp[ans]++;
						}
					}
					
					for (int i=0;i<16;++i) {
						assertEquals(comp[i], (int)mazeSolver.numReachable(i));
					}
				}
			}
			
			mazeSolver.initialize(Maze.readMaze("maze-dense.txt"));
			for (int sr=0;sr<=3;++sr) {
				for (int sc=0;sc<=3;++sc) {
					for (int er=0;er<=3;++er) {
						for (int ec=0;ec<=3;++ec) {
							if (sr == er && sc == ec) {
								assertEquals(0, (int)mazeSolver.pathSearch(sr, sc, er, ec));
							} else {
								assertNull(mazeSolver.pathSearch(sr, sc, er, ec));
							}
						}
					}

					for (int i=0;i<16;++i) {
						if (i == 0) {
							assertEquals(1, (int)mazeSolver.numReachable(i));
						} else {
							assertEquals(0, (int)mazeSolver.numReachable(i));
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true); // no exception should be thrown
		}
	}

	@Test
	public void testHorizontalSnake() {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
		try {
			mazeSolver.initialize(Maze.readMaze("maze-hsnake.txt"));
			
			assertEquals(12, (int)mazeSolver.pathSearch(0, 0, 3, 3));
			assertEquals(11, (int)mazeSolver.pathSearch(0, 1, 3, 3));
			assertEquals(5, (int)mazeSolver.pathSearch(1, 0, 3, 3));
			assertEquals(7, (int)mazeSolver.pathSearch(1, 0, 0, 0));
			assertEquals(15, (int)mazeSolver.pathSearch(3, 0, 0, 0));
			assertEquals(8, (int)mazeSolver.pathSearch(2, 0, 0, 0));
			
			int pre[] = new int[]{1,2,2,2,2,2,2,2,1,0,0,0,0,0,0,0,0,0,0,0};
			for (int i=0;i<20;++i) {
				assertEquals(pre[i], (int)mazeSolver.numReachable(i));
			}
		} catch(Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

	@Test
	public void testVerticalSnake() {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
		try {
			mazeSolver.initialize(Maze.readMaze("maze-vsnake.txt"));
			
			assertEquals(12, (int)mazeSolver.pathSearch(0, 0, 3, 3));
			assertEquals(5, (int)mazeSolver.pathSearch(0, 1, 3, 3));
			assertEquals(11, (int)mazeSolver.pathSearch(1, 0, 3, 3));
			assertEquals(1, (int)mazeSolver.pathSearch(1, 0, 0, 0));
			assertEquals(3, (int)mazeSolver.pathSearch(3, 0, 0, 0));
			assertEquals(8, (int)mazeSolver.pathSearch(0, 2, 0, 0));
			
			int pre[] = new int[]{1,2,2,2,2,2,2,2,1,0,0,0,0,0,0,0,0,0,0,0};
			for (int i=0;i<20;++i) {
				assertEquals(pre[i], (int)mazeSolver.numReachable(i));
			}
		} catch(Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

	@Test
	public void testSpiral() {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
		try {
			mazeSolver.initialize(Maze.readMaze("maze-spiral.txt"));
			
			assertEquals(16, (int)mazeSolver.pathSearch(2,2,0,4));
			assertEquals(24, (int)mazeSolver.pathSearch(4,0, 2, 2));
			assertEquals(24, (int)mazeSolver.pathSearch(2,2,4,0));
			assertEquals(16, (int)mazeSolver.pathSearch(0,4,2,2));
			
			int pre[] = new int[]{1,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,0,0,0};
			for (int i=0;i<20;++i) {
				assertEquals(pre[i], (int)mazeSolver.numReachable(i));
			}
		} catch(Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

	@Test
	public void testVHDenseMaze() {
		IMazeSolverWithPower mazeSolver = new MazeSolverWithPower();
		
		try {
			mazeSolver.initialize(Maze.readMaze("maze-vdense.txt"));
			int [] comp = new int[16];
			
			for (int sr=0;sr<=3;++sr) {
				for (int sc=0;sc<=3;++sc) {

					for (int i=0;i<16;++i) comp[i] = 0;

					for (int er=0;er<=3;++er) {
						for (int ec=0;ec<=3;++ec) {
							int ans;
							if (sc == ec) {
								ans = (int)(Math.abs(sr-er) + Math.abs(sc-ec));
								assertEquals(ans, (int)mazeSolver.pathSearch(sr, sc, er, ec));
								comp[ans]++;
							} else {
								assertNull(mazeSolver.pathSearch(sr, sc, er, ec));
							}
						}
					}

					for (int i=0;i<16;++i) {
						assertEquals(comp[i], (int)mazeSolver.numReachable(i));
					}
				}
			}

			mazeSolver.initialize(Maze.readMaze("maze-hdense.txt"));
			for (int sr=0;sr<=3;++sr) {
				for (int sc=0;sc<=3;++sc) {

					for (int i=0;i<16;++i) comp[i] = 0;

					for (int er=0;er<=3;++er) {
						for (int ec=0;ec<=3;++ec) {
							int ans;
							if (sr == er) {
								ans = (int)(Math.abs(sr-er) + Math.abs(sc-ec));
								assertEquals(ans, (int)mazeSolver.pathSearch(sr, sc, er, ec));
								comp[ans]++;
							} else {
								assertNull(mazeSolver.pathSearch(sr, sc, er, ec));
							}
						}
					}

					for (int i=0;i<16;++i) {
						assertEquals(comp[i], (int)mazeSolver.numReachable(i));
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

}
