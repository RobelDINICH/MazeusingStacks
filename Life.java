/*
File or Class name: Main
Program author(s): Robel Tadele
Course number and title: COSC2203, Data Structures Section 1
Assignment number and name: Amazing Life (Assignment 1A)
Due date: Aug 31 2020
Brief description of the purpose of the program: Simulation of Conways Game of Life program

//Rules

If a cell is occupied but has no more than one occupied neighbor,then it is empty in the next generation.
If a cell is occupied and has four or more occupied neighbors,then it is empty in the next generation.
An occupied cell with either two or three occupied neighbors remains occupied in the next generation
An empty cell is occupied in the next generation if it has exactly three occupied neighbors
All changes in occupancy take place at the same time, so a cell that will become empty may influence another cell to become occupied.

 */

package com.Robel;

import java.util.Scanner;

public class Life {

    public static void main(String[] args) throws Exception {

        //Declaration of Data Types
        String reproduction;
        int row,column;
        int numberOfGenerations;

        //Setting up scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Enter reproduction mode : ");
        reproduction = input.next();

        System.out.print("Enter number of Generations to be simulated : ");
        numberOfGenerations = input.nextInt();

        //Prompts user for Grid Size
        System.out.print("Enter rows and columns separated by a space: ");
        row = input.nextInt();
        column = input.nextInt();


        //Declaration and Initialization of Arrays
        int[][] temp = new int[row + 2][column + 2];
        int[][]initialGen = new int[row + 2][column + 2];
        int[][] currentGen = new int[row + 2][column + 2];
        int[][] nextGen = new int[row + 2][column + 2];


        //Scans in first Generation from Console
        for (int i = 1; i <= row; i++) {
            String firstRow = input.next();
            for (int j = 1; j <= column; j++) {
                if (firstRow.charAt(j - 1) == '1') {
                    initialGen[i][j] = 1;
                } else {
                    initialGen[i][j] = 0;
                }

                currentGen[i][j] = initialGen[i][i];
                temp[i][j] = initialGen[i][j];
            }
        }


           //Iterates to each cell looking for Neighbours

        for(int z = 0; z <= numberOfGenerations; z++){
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    int neighborCount = 0;

                    if(currentGen[i-1][j-1] == 1)
                        neighborCount++;
                    if (currentGen[i-1][j] == 1)
                        neighborCount++;

                    if(currentGen[i-1][j+1] ==  1)
                        neighborCount++;

                    if(currentGen[i][j-1] == 1)
                        neighborCount++;

                    if(currentGen[i][j+1] == 1)
                        neighborCount++;

                    if(currentGen[i+1][j-1] == 1)
                        neighborCount++;

                    if (currentGen[i+1][j] == 1)
                        neighborCount++;

                    if(currentGen[i+1][j+1] == 1)
                        neighborCount++;

                    if(initialGen[i][j] == 0 && neighborCount == 3){
                        currentGen[i][j] = 1;

                    }else if (initialGen[i][j] == 1){
                        if(neighborCount == 2 || neighborCount == 3){
                            currentGen[i][j] = 1;
                        }
                    }


                    currentGen[i][j] = initialGen[i][j];
                    initialGen[i][j] = nextGen[i][j];
                    nextGen[i][j] = temp[i][j];



                }//End of for loop A
            }//End of For loop B
        }

        //Console Output Conditions
        if(reproduction.equals("v") || reproduction.equals("V")){

            System.out.println("\nInitial Generation");
            //Prints out Current Gen
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    System.out.print(initialGen[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("\nCurrent Generation");
            //Prints out Current Gen
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    System.out.print(currentGen[i][j] + " ");
                }
                System.out.println();
            }

            //Prints out Next Gen
            System.out.println("\nNext Generation");
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    System.out.print(nextGen[i][j] + " ");
                }
                System.out.println();
            }
        }else{

            System.out.println("Silent Mode. Program Terminated");
        }
    }
}