
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {
    protected int[][] mTiles;
    protected int mSize;
    private ArrayList<Board> mPath;


    public Board(int[][] tiles) {
        mTiles = tiles;
        mSize = mTiles.length;
        mPath = new ArrayList<>();
        mPath.add(this);
    }


   
    public String toString() {
        String s = "";
        for (int i = 0; i < mSize; i++)
        {
            for (int j = 0; j < mSize; j++)
            {
                s += mTiles[i][j];
            }
            if (i != mSize - 1) s += "\n";
        }
        return s + "\n\n";
    }


    public int tileAt(int row, int col) {
        if (!inBounds(row, col)) throw new java.lang.IllegalArgumentException();
        return mTiles[row][col];
    }



    public int size() {
        return mSize;
    }


    public boolean isGoal() {
        for (int i = 0; i < mSize * mSize; i++) {
            if (mTiles[i / mSize][i % mSize] != (i + 1) % (mSize * mSize)) return false;
        }
        return true;
    }


   
    public boolean equals(Object y) {
        Board b = (Board) y;
        for (int i = 0; i < mSize; i++)  {
            for (int j = 0; j < mSize; j++) {
                if (mTiles[i][j] != b.tileAt(i, j)) return false;
            }
        }
        return true;
    }


    public Iterable<Board> neighbors() {
        List<Board> neighbors = new LinkedList<>();
        Point coords = findBlank();
        int row = coords.y;
        int col = coords.x;
        for (int i = 0; i < 4; i++) {
            int dx = (i - 1) % 2;
            int dy = (i - 2) % 2;
            if (inBounds(row + dy, col + dx)) {
                Board neighbour = copyOf();
                neighbour.swap(row, col, row + dy, col + dx);
                neighbors.add(neighbour);
            }
        }

        return neighbors;
    }

 
    protected Point findBlank() {
        for (int row = 0; row < mSize; row++)  {
            for (int col = 0; col < mSize; col++) {
                if (mTiles[row][col] == 0) return new Point(col, row);
            }
        }
        //Thrown if no 0 found
        throw new IllegalStateException();
    }


    protected Board copyOf() {
        int[][] copyArray = new int[mSize][mSize];
        for (int i = 0; i < mSize; i++) {
            for (int j = 0; j < mSize; j++) {
                copyArray[i][j] = mTiles[i][j];
            }
        }
        return new Board(copyArray);
    }


    protected boolean inBounds(int row, int col) {
        boolean inRow = row >= 0 && row < mSize;
        boolean inCol = col >= 0 && col < mSize;
        return inRow && inCol;
    }

    protected void swap(int row1, int col1, int row2, int col2) {
        int temp = mTiles[row1][col1];
        mTiles[row1][col1] = mTiles[row2][col2];
        mTiles[row2][col2] = temp;
    }


    public void updatePathToStartState(Board b) {
        mPath = new ArrayList<>(b.getPathToStart());
        mPath.add(this);
    }

    public ArrayList<Board> getPathToStart() {
        return mPath;
    }

    public boolean inPath(Board b) {
        return mPath.contains(b);
    }

    public int getPathLength() {
        return mPath.size();
    }

}