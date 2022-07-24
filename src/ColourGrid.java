import java.util.Random;

public class ColourGrid {
    public static void main(String[] args) {
        int rows = 15;
        int columns = 10;
        int numOfColours = 4;

        Grid[][] grids = createGrid(rows, columns, numOfColours);
        selectLargestConnectingBlock(grids,rows,columns);

    }

    private static void selectLargestConnectingBlock(Grid[][] grids, int rows, int columns) {
        int[][] counts = new int[rows][columns];
        int maxX = 0;
        int maxY = 0;
        int maxCount = 0;

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {

                }
            }
        }
    }

    private static boolean isInside(int i, int j,int rows, int columns) {
        return (-1 < i && -1 < j && i < rows && j < columns);
    }

    private static Grid[][] createGrid(int rows, int columns, int numOfColours) {
        Random random = new Random();
        Grid[][] grids = new Grid[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grids[i][j] = new Grid();
                grids[i][j].setColour(random.nextInt(numOfColours - 1) + 1);
                grids[i][j].setX(i);
                grids[i][j].setY(j);
            }
        }
        return grids;
    }
}
