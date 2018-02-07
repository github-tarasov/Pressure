package example;

public class Pressure {

    private double brickWeight;

    public Pressure(double brickWeight) {
        this.brickWeight = brickWeight;
    }

    public double w(int row, int pos) {
        if (row < 0 || pos < 0 || pos > row) {
            throw new IllegalArgumentException("Wrong input params");
        }

        double[] prevRow = new double[1];
        prevRow[0] = 0d;
        double[] currentRow;

        for (int rowIndex = 1; rowIndex <= row; rowIndex++) {
            currentRow = new double[rowIndex + 1];
            for (int posIndex = 0; posIndex <= rowIndex / 2; posIndex++) {
                if (posIndex == 0) {
                    currentRow[posIndex] = (prevRow[0] + brickWeight) / 2;
                } else {
                    currentRow[posIndex] = (prevRow[posIndex - 1] + prevRow[posIndex]) / 2 + brickWeight;
                }
                // Symmetry
                currentRow[rowIndex - posIndex] = currentRow[posIndex];

                if (rowIndex == row && (posIndex == pos || posIndex == row - pos)) {
                    break;
                }
            }

            prevRow = currentRow;
        }

        return prevRow[pos];
    }
}
