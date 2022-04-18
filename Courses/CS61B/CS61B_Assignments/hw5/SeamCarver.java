import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class SeamCarver {

    private Picture picture;
    private int width;
    private int height;
    private double[][] energy;
    private double[][] minCost;

    public SeamCarver(Picture picture) {
        this.picture = new Picture(picture);
        this.width = picture.width();
        this.height = picture.height();
        energy = new double[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                energy[i][j] = energy(i, j);
            }
        }
        setMinCost();

    }

    // current picture
    public Picture picture() {
        return new Picture(this.picture);
    }

    // width of current picture
    public int width() {
        return width;
    }

    // height of current picture
    public int height() {
        return height;
    }

    private double calcEnergy(Color c1, Color c2) {
        int red = c1.getRed() - c2.getRed();
        int blue = c1.getBlue() - c2.getBlue();
        int green = c1.getGreen() - c2.getGreen();
        return (double) red * red + blue * blue + green * green;
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {

        if (x >= width || y >= height || x < 0 || y < 0) {
            throw new IndexOutOfBoundsException("Please enter a valid x or y");
        }

        int leftX = x - 1 < 0 ? width - 1 : x - 1;
        int rightX = x + 1 >= width ? 0 : x + 1;
        double energyX = calcEnergy(picture.get(leftX, y), picture.get(rightX, y));

        int upY = y - 1 < 0 ? height - 1 : y - 1;
        int downY = y + 1 >= height ? 0 : y + 1;
        double energyY = calcEnergy(picture.get(x, upY), picture.get(x, downY));
        return energyX + energyY;
    }

    private double getMinUpper(double x, double y, double z) {
        double min1 = Math.min(x, y);
        return Math.min(min1, z);
    }

    private void setMinCost() {
        minCost = new double[width][height];
        double minLeft, minMiddle, minRight;
        for (int i = 0; i < width; i++) {
            minCost[i][0] = energy[i][0];
        }
        if (width == 1) {
            return;
        }
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    minMiddle = minCost[j][i - 1];
                    minRight = minCost[j + 1][i - 1];
                    if (minMiddle <= minRight) {
                        minCost[j][i] = energy[j][i] + minMiddle;
                    } else {
                        minCost[j][i] = energy[j][i] + minRight;
                    }
                } else if (j == width - 1) {
                    minLeft = minCost[j - 1][i - 1];
                    minMiddle = minCost[j][i - 1];
                    if (minMiddle <= minLeft) {
                        minCost[j][i] = energy[j][i] + minMiddle;
                    } else {
                        minCost[j][i] = energy[j][i] + minLeft;
                    }
                } else {
                    minLeft = minCost[j - 1][i - 1];
                    minMiddle = minCost[j][i - 1];
                    minRight = minCost[j + 1][i - 1];
                    minCost[j][i] = energy[j][i] + getMinUpper(minLeft, minMiddle, minRight);
                }
            }
        }
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        Picture pictureReverse = new Picture(height, width);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color pixel = picture.get(col, row);
                pictureReverse.set(row, col, pixel);
            }
        }
        SeamCarver sc = new SeamCarver(pictureReverse);
        int[] horizontalSeam = sc.findVerticalSeam();
        return horizontalSeam;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        int[] verticalSeam = new int[height];
        int minIndex = 0;
        double minCostBottom = Double.MAX_VALUE;
        for (int i = 0; i < width; i++) {
            if (minCost[i][height - 1] < minCostBottom) {
                minCostBottom = minCost[i][height - 1];
                minIndex = i;
            }
        }
        int row = height - 1;
        verticalSeam[row] = minIndex;
        while (row >= 0) {
            row -= 1;
            if (row < 0) {
                break;
            }
            // int minLeftIndex, minMiddleIndex, minRightIndex;
            int minLeftIndex = minIndex - 1 < 0 ? 0 : minIndex - 1;
            int minMiddleIndex = minIndex;
            int minRightIndex = minIndex + 1 >= width ? width - 1 : minIndex + 1;
            if (minCost[minLeftIndex][row] <= minCost[minMiddleIndex][row]
                    && minCost[minLeftIndex][row] <= minCost[minRightIndex][row]) {
                verticalSeam[row] = minLeftIndex;
                minIndex = minLeftIndex;
            } else if (minCost[minMiddleIndex][row] <= minCost[minLeftIndex][row]
                    && minCost[minMiddleIndex][row] <= minCost[minRightIndex][row]) {
                verticalSeam[row] = minMiddleIndex;
                minIndex = minMiddleIndex;
            } else if (minCost[minRightIndex][row] <= minCost[minLeftIndex][row]
                    && minCost[minRightIndex][row] <= minCost[minMiddleIndex][row]) {
                verticalSeam[row] = minRightIndex;
                minIndex = minRightIndex;
            }
        }
        return verticalSeam;
    }
            /*
            minLeftIndex = minIndex - 1;
            minMiddleIndex = minIndex;
            minRightIndex = minIndex + 1;
            if (minLeftIndex < 0) {
                if (minCost[minMiddleIndex][row] < minCost[minRightIndex][row]) {
                    verticalSeam[row] = minMiddleIndex;
                    minIndex = minMiddleIndex;
                } else {
                    verticalSeam[row] = minRightIndex;
                    minIndex = minRightIndex;
                }
                continue;
            } else if (minRightIndex == width) {
                if (minCost[minMiddleIndex][row] < minCost[minLeftIndex][row]) {
                    verticalSeam[row] = minMiddleIndex;
                    minIndex = minMiddleIndex;
                } else {
                    verticalSeam[row] = minLeftIndex;
                    minIndex = minLeftIndex;
                }
                continue;
            } else {
                if (minCost[minLeftIndex][row] <= minCost[minMiddleIndex][row]
                        && minCost[minLeftIndex][row] <= minCost[minRightIndex][row]) {
                    verticalSeam[row] = minLeftIndex;
                    minIndex = minLeftIndex;
                } else if (minCost[minMiddleIndex][row] <= minCost[minLeftIndex][row]
                        && minCost[minMiddleIndex][row] <= minCost[minRightIndex][row]) {
                    verticalSeam[row] = minMiddleIndex;
                    minIndex = minMiddleIndex;
                } else if (minCost[minRightIndex][row] <= minCost[minLeftIndex][row]
                        && minCost[minRightIndex][row] <= minCost[minMiddleIndex][row]) {
                    verticalSeam[row] = minRightIndex;
                    minIndex = minRightIndex;
                }
            }
        }
             */

    // remove horizontal seam from picture
    public void removeHorizontalSeam(int[] seam) {
        if (checkSeam(seam)) {
            this.picture = new Picture(SeamRemover.removeHorizontalSeam(this.picture, seam));
            height--;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // remove vertical seam from picture
    public void removeVerticalSeam(int[] seam) {
        if (checkSeam(seam)) {
            this.picture = new Picture(SeamRemover.removeVerticalSeam(this.picture, seam));
            width--;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkSeam(int[] seam) {
        for (int i = 0; i < seam.length - 1; i++) {
            if (Math.abs(seam[i] - seam[i + 1]) > 1) {
                return false;
            }
        }

        return true;
    }
}
