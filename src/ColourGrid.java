import java.util.HashMap;
import java.util.Random;


public class ColourGrid {
    public static void main(String[] args) {
        int rows = 15;
        int columns = 10;
        int numOfColours = 4;

        Grid[][] grids = createGrid(rows, columns, numOfColours);
        HashMap<String, Integer> countMap = selectLargestConnectingBlock(grids, rows, columns);
        markRange(countMap.get("XPosition"),countMap.get("YPosition"),countMap.get("maxCount"),rows,columns);


    }

    private static void markRange(Integer xPosition, Integer yPosition, Integer maxCount, int rows, int columns) {

    }

    private static HashMap<String, Integer> selectLargestConnectingBlock(Grid[][] grids, int rows, int columns) {
        int maxX = 0;
        int maxY = 0;
        int maxCount = 0;
        int[][] counts = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (checkInside(i, j + 1, rows, columns) && grids[i][j].getColour() == grids[i][j + 1].getColour()) {
                    counts[i][j] += counts[i + 1][j] + 1;
                }

                if (checkInside(i, j - 1, rows, columns) && grids[i][j].getColour() == grids[i][j - 1].getColour()) {
                    counts[i][j] += counts[i + 1][j] + 1;
                }

                if (checkInside(i + 1, j, rows, columns) && grids[i][j].getColour() == grids[i + 1][j].getColour()) {
                    counts[i][j] += counts[i + 1][j] + 1;
                }

                if (checkInside(i - 1, j, rows, columns) && grids[i][j].getColour() == grids[i - 1][j].getColour()) {
                    counts[i][j] += counts[i - 1][j] + 1;
                }

                if (counts[i][j] >= maxCount) {
                    maxCount = counts[i][j];
                    maxX = i;
                    maxY = j;
                }

            }
        }

        HashMap<String, Integer> countMap = new HashMap<>();
        countMap.put("XPosition", maxX);
        countMap.put("YPosition", maxY);
        countMap.put("maxCount", maxCount);

        return countMap;

    }


    private static boolean checkInside(int i, int j, int rows, int columns) {
        return (i < rows && j < columns && -1 < i && -1 < j);
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
