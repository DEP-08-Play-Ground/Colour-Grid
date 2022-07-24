import java.util.HashMap;
import java.util.Random;

public class ColourGrid {
    public static void main(String[] args) {
        int rows = 15;
        int columns = 10;
        int numOfColours = 4;

        Block[][] blocks = createGrid(rows, columns, numOfColours);
        System.out.println("======== Created Block ========\n");
        printSelectedBlock(blocks, rows, columns);
        HashMap<String, Integer> countMap = selectLargestConnectingBlock(blocks, rows, columns);
        Block[][] selectedBlock = createGrid(rows, columns,0);
        markRange(countMap.get("XPosition"), countMap.get("YPosition"), countMap.get("maxCount"), countMap.get("maxColour"), selectedBlock, blocks, rows, columns);
        System.out.println("\n======== Largest Connecting Block ========\n");
        printSelectedBlock(selectedBlock, rows, columns);
    }

    //print the selected blocks in the grid
    private static void printSelectedBlock(Block[][] selectedBlock, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (selectedBlock[i][j].getColour() == 0) {
                    System.out.print("*\t");
                } else {
                    System.out.print(selectedBlock[i][j].getColour() + "\t");
                }
            }
            System.out.println("");
        }
    }

    //mark each and every block which are adjacent to the max-count-block with the max-colour
    private static void markRange(Integer xPosition, Integer yPosition, Integer maxCount, Integer maxColour, Block[][] selectedBlock, Block[][] givenBlock, int rows, int columns) {

        selectedBlock[xPosition][yPosition].setColour(maxColour);

        if (checkInside(xPosition + 1, yPosition, rows, columns) && selectedBlock[xPosition + 1][yPosition].getColour() == 0 &&
                givenBlock[xPosition][yPosition].getColour() == givenBlock[xPosition + 1][yPosition].getColour()) {
            markRange(xPosition + 1, yPosition, maxCount, maxColour, selectedBlock, givenBlock, rows, columns);
        }

        if (checkInside(xPosition, yPosition - 1, rows, columns) && selectedBlock[xPosition][yPosition - 1].getColour() == 0 &&
                givenBlock[xPosition][yPosition].getColour() == givenBlock[xPosition][yPosition - 1].getColour()) {
            markRange(xPosition, yPosition - 1, maxCount, maxColour, selectedBlock, givenBlock, rows, columns);
        }

        if (checkInside(xPosition - 1, yPosition, rows, columns) && selectedBlock[xPosition - 1][yPosition].getColour() == 0 &&
                givenBlock[xPosition][yPosition].getColour() == givenBlock[xPosition - 1][yPosition].getColour()) {
            markRange(xPosition - 1, yPosition, maxCount, maxColour, selectedBlock, givenBlock, rows, columns);
        }

        if (checkInside(xPosition, yPosition + 1, rows, columns) && selectedBlock[xPosition][yPosition + 1].getColour() == 0 &&
                givenBlock[xPosition][yPosition].getColour() == givenBlock[xPosition][yPosition + 1].getColour()) {
            markRange(xPosition, yPosition + 1, maxCount, maxColour, selectedBlock, givenBlock, rows, columns);
        }

    }

    private static HashMap<String, Integer> selectLargestConnectingBlock(Block[][] blocks, int rows, int columns) {
        int maxX = 0;
        int maxY = 0;
        int maxCount = 0;
        int maxColour = 0;
        int[][] counts = new int[rows][columns];

        //check the right,left, up and down of a particular block for adjacent blocks
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {

                if (checkInside(i, j + 1, rows, columns) && blocks[i][j].getColour() == blocks[i][j + 1].getColour()) {
                    counts[i][j] += counts[i + 1][j] + 1;
                }

                if (checkInside(i, j - 1, rows, columns) && blocks[i][j].getColour() == blocks[i][j - 1].getColour()) {
                    counts[i][j] += counts[i + 1][j] + 1;
                }

                if (checkInside(i + 1, j, rows, columns) && blocks[i][j].getColour() == blocks[i + 1][j].getColour()) {
                    counts[i][j] += counts[i + 1][j] + 1;
                }

                if (checkInside(i - 1, j, rows, columns) && blocks[i][j].getColour() == blocks[i - 1][j].getColour()) {
                    counts[i][j] += counts[i - 1][j] + 1;
                }

                if (counts[i][j] >= maxCount) {
                    maxCount = counts[i][j];
                    maxX = i;
                    maxY = j;
                    maxColour = blocks[i][j].getColour();
                }

            }
        }
        //fetch the data of the block with maximum adjacent blocks to a hashmap
        HashMap<String, Integer> countMap = new HashMap<>();
        countMap.put("XPosition", maxX);
        countMap.put("YPosition", maxY);
        countMap.put("maxCount", maxCount);
        countMap.put("maxColour", maxColour);

        return countMap;

    }


    //see whether the particular index is inside the grid we created
    private static boolean checkInside(int i, int j, int rows, int columns) {
        return (i < rows && j < columns && -1 < i && -1 < j);
    }

    //create the 2D grids array with random colours
    private static Block[][] createGrid(int rows, int columns, int numOfColours) {
        Random random = new Random();
        Block[][] blocks = new Block[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                blocks[i][j] = new Block();
                if (numOfColours==0){
                    blocks[i][j].setColour(0);
                }else {
                    blocks[i][j].setColour(random.nextInt(numOfColours - 1) + 1);
                }
                blocks[i][j].setX(i);
                blocks[i][j].setY(j);
            }
        }
        return blocks;
    }

}
