import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BoardCover2 {
    public static void main(final String[] args) throws NumberFormatException, IOException {
        final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            final char[][] table = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
            final int w = Integer.parseInt(st.nextToken());
            final int h = Integer.parseInt(st.nextToken());
            for (int i = 0; i < table.length; i++) {
                st = new StringTokenizer(bf.readLine());
                final char[] temp = st.nextToken().toCharArray();
                for (int j = 0; j < table[i].length; j++) {
                    table[i][j] = temp[j];
                    Pair<i,j>
                }

            }
        }
    }

    public static void charArrayPrinter(final char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }
}

class Block {
    /**
     * RotateMode 0:0 1:90 2:180 3:240 clockwise
     */

    private static int NUM_ROTATE_MODE = 4;
    private final int blockBoardSize;

    ArrayList<ArrayList<Pair<Integer, Integer>>> rotates = new ArrayList<>();

    Block(final int height, final int width, final char[][] block) {
        char[][] blockToRotate = block;
        int offsetX = -1;
        int offsetY = -1;
        blockBoardSize = Math.max(width, height);
        for (int i = 0; i < NUM_ROTATE_MODE; i++) {
            rotates.add(new ArrayList<>());
            for (int j = 0; j < blockBoardSize; j++) {
                for (int k = 0; k < blockBoardSize; k++) {
                    if (blockToRotate[j][k] == '#') {
                        if (offsetX == -1) {
                            offsetX = k;
                            offsetY = j;
                        }
                        rotates.get(i).add(new Pair<>(j - offsetY, k - offsetX));
                    }
                }
            }
            blockToRotate = rotateBlock(blockToRotate, blockBoardSize);
            offsetX = -1;
            offsetY = -1;
        }
    }

    private char[][] rotateBlock(final char[][] block, final int blockSize) {
        final char[][] rotatedBlock = new char[blockSize][blockSize];
        for (int i = 0; i < blockSize; i++) {
            for (int j = 0; j < blockSize; j++) {
                rotatedBlock[i][j] = block[blockSize - j - 1][i];
            }
        }
        return rotatedBlock;
    }
}

class Pair<L, R> {
    final L left;
    final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    static <L, R> Pair<L, R> of(L left, R right) {
        return new Pair<L, R>(left, right);
    }
}