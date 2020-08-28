
public class Test {
    public static void main(String[] args) {
        test(new Board(new int[][]{{1,2,3},{4,0,5},{7,8,6}}),2000);
        test(new Board(new int[][]{{0,1,2},{4,5,3},{7,8,6}}),2000);
        test(new Board(new int[][]{{0,8,6},{2,7,5},{1,3,4}}),2000);
    }

    private static void test(Board b, int maxTime) {
        BestFirstSearch hs = new HeuristicSearch();
        System.out.println("Heuristic Search: ");
        printResult(hs.bestFirstSearch(b, maxTime));

        long s =System.currentTimeMillis();
        BestFirstSearch bfs = new BreadthFirstSearch();
        System.out.println("Breath First Search: ");
        printResult(bfs.bestFirstSearch(b,maxTime));
        System.out.println(System.currentTimeMillis()-s);
    }

    private static void printResult(Board bestFirstSearch) {
        if(bestFirstSearch == null)
        	System.out.println("The algorithm was unable to find the solution in the given time.");
        else 
        	System.out.println(bestFirstSearch.getPathToStart());
    }
}

