
public abstract class BestFirstSearch {

    public Board bestFirstSearch(Board ini, int maxTime) {
        long startTime = System.currentTimeMillis();
        HeapPriorityQueue<Integer, Board> pQ = new HeapPriorityQueue<>();
        pQ.insert(calculatePriority(ini), ini);

        while (!pQ.isEmpty() && System.currentTimeMillis() - startTime < maxTime) {
            Board curr = pQ.removeMin().getValue();
            if (curr.isGoal()) return curr;

            for (Board child : curr.neighbors()) {
                if (! curr.inPath(child)) {
                    child.updatePathToStartState(curr);
                    int p = calculatePriority(child);
                    pQ.insert(p, child);
                }
            }
        }
        return null;
    }

    protected abstract int calculatePriority(Board b);
}
