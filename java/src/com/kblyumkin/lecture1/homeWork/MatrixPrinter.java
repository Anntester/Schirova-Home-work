package com.kblyumkin.lecture1.homeWork;

import java.util.Arrays;

public class MatrixPrinter {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 5, 4, 1}
        };
    for (int row = 0; row < matrix.length; row++) {
        for (int column = 0; column < matrix[row].length; column++){

        System.out.print(matrix[row][column] + " ");
              
    }
        System.out.print("\n");
    }



    }
}
