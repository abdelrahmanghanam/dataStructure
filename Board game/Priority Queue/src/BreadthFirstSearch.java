public class BreadthFirstSearch extends BestFirstSearch {
    @Override
    protected int calculatePriority(Board b) {
        return b.getPathLength();
    }
}
