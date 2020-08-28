
public class HeuristicSearch extends BestFirstSearch {
    @Override
    protected int calculatePriority(Board b) {
        int misplaced = 0;
        int size = b.size();
        for (int i = 0; i < size * size; i++) {
                if (b.tileAt(i / size, i % size) != (i + 1) % (size * size)) misplaced++;
        }
        return misplaced;
    }
}