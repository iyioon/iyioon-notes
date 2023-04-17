import java.util.*;
public class TSPGraph implements IApproximateTSP {

    List<List<Integer>> childList;
    @Override
    public void MST(TSPMap map) {
        int[] parent = new int[map.getCount()];
        childList = new ArrayList<>();
        childList.add(new ArrayList<>());
        boolean[] visited = new boolean[map.getCount()];

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingDouble((int[] p) -> map.pointDistance(p[0], p[1])));
        visited[0] = true;
        for (int i = 1; i < map.getCount(); i++) {
            queue.add(new int[]{0, i});
            childList.add(new ArrayList<>());
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (!visited[curr[1]]) {
                parent[curr[1]] = curr[0];
                map.setLink(curr[1], curr[0], true);
                visited[curr[1]] = true;
                for (int i = 0; i < map.getCount(); i++) {
                    if (!visited[i]) {
                        queue.add(new int[]{curr[1], i});
                    }
                }
            }
        }

        for (int i = 0; i < map.getCount(); i++) {
            if (parent[i] != -1) {
                childList.get(parent[i]).add(i);
            }
        }
    }

    @Override
    public void TSP(TSPMap map) {
        MST(map);
        boolean[] visited = new boolean[map.getCount()];
        List<Integer> dfs = new ArrayList<>();
        dfsSearch(childList, 0, visited, dfs);

        int[] path = new int[dfs.size()];
        visited = new boolean[map.getCount()];
        int index = 0;
        for (int city : dfs) {
            if (!visited[city]) {
                path[index++] = city;
                visited[city] = true;
            }
        }
        path[index] = dfs.get(0);

        for (int i = 0; i < index; i++) {
            map.setLink(path[i], path[i+1]);
        }
    }

    public void dfsSearch(List<List<Integer>> childList, int curr, boolean[] visited, List<Integer> dfs) {
        dfs.add(curr);
        visited[curr] = true;
        List<Integer> children = childList.get(curr);
        for (Integer c : children) {
            if (!visited[c]) {
                dfsSearch(childList, c, visited, dfs);
                dfs.add(curr);
            }
        }
    }

    @Override
    public boolean isValidTour(TSPMap map) {
        boolean[] visited = new boolean[map.getCount()];
        int curr = 0;
        int count = 0;
        while (!visited[curr]) {
            visited[curr] = true;
            curr = map.getLink(curr);
            count++;
        }
        if (curr == 0 && count == map.getCount()){
            return true;
        }
        return false;
    }

    @Override
    public double tourDistance(TSPMap map) {
        double dist = 0;
        boolean[] visited = new boolean[map.getCount()];
        int curr = 0;

        while (!visited[curr]) {
            visited[curr] = true;
            dist += map.pointDistance(curr, map.getLink(curr));
            curr = map.getLink(curr);
        }

        return isValidTour(map) ? dist : -1;
    }

    public static void main(String[] args) {
        TSPMap map = new TSPMap(args.length > 0 ? args[0] : "fiftypoints.txt");
        TSPGraph graph = new TSPGraph();

        graph.MST(map);
        graph.TSP(map);
        // System.out.println(graph.isValidTour(map));
        // System.out.println(graph.tourDistance(map));
    }
}
