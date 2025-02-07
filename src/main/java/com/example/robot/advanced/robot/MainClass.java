package com.example.robot.advanced.robot;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MainClass {

    public static void main(String[] args) {
        robot();

    }

    private static void anagrams() {
        String input1 = "pairs";
        String input2 = "paris";

        char[] arrayinput1 = input1.toCharArray();
        char[] arrayinput2 = input2.toCharArray();

        Arrays.sort(arrayinput1);
        Arrays.sort(arrayinput2);

        String input1Sorted = Arrays.toString(arrayinput1);
        String input2Sorted = Arrays.toString(arrayinput2);
        log.info("String 1 after sort : {}",input1Sorted);
        log.info("String 2 after sort : {}",input2Sorted);

        if(input1Sorted.equals(input2Sorted)){
            log.info("Two strings are anagrams");
        }else{
            log.info("two strings are not anagrams");
        }
    }

    private static void robot() {
        String[] matrix = {"...x..", "....xx", "..x..."};
        int countDots = 0;
        int currentRow = 0;
        int currentCol = 0;
        log.info("inside main method. moveForward() method is called for the first time");
        moveForward(matrix, countDots, currentRow, currentCol);
    }

    private static void moveForward(String[] matrix, int countDots, int currentRow, int currentCol) {
        log.info("moveForward() method is called....");
        if (matrix[currentRow].charAt(currentCol) == '.') {
            countDots++;
            currentCol = currentCol + 1;
            if (currentCol < matrix[currentRow].length()) {
                log.info("moving forward....");
                moveForward(matrix, countDots, currentRow, currentCol);
            } else {
                log.info("moving downward for index out of bound reason....");
                moveDownward(matrix, countDots, currentRow + 1, currentCol - 1);
            }
        }

        if (matrix[currentRow].charAt(currentCol) == 'x') {
            log.info("moving downward because an obstacle found....");
            moveDownward(matrix, countDots, currentRow + 1, currentCol - 1);
        }
    }

    private static void moveDownward(String[] matrix, int countDots, int currentRow, int currentCol) {
        log.info("moveDownward() method is called....");
        if (matrix[currentRow].charAt(currentCol) == '.') {
            countDots++;
            currentRow = currentRow + 1;
            if (currentRow < matrix.length) {
                log.info("moving downward...");
                moveDownward(matrix, countDots, currentRow , currentCol);
            } else {
                log.info("moving to the left for index out of bound reason");
                moveTowardsLeft(matrix, countDots, currentRow - 1, currentCol - 1);
            }
        }
        if (matrix[currentRow].charAt(currentCol) == 'x') {
            log.info("moving to the left because an obstacle found...");
            moveTowardsLeft(matrix, countDots, currentRow - 1, currentCol - 1);
        }
    }

    private static void moveTowardsLeft(String[] matrix, int countDots, int currentRow, int currentCol) {
        log.info("moveTowardsLeft() method is called....");
        if (matrix[currentRow].charAt(currentCol) == '.') {
            countDots++;
            currentCol = currentCol - 1;
            if (currentCol >= 0) {
                log.info("moving towards left...");
                moveTowardsLeft(matrix, countDots, currentRow, currentCol);
            } else {
                log.info("moving towards up for index out of bound reason");
                moveTowardsUp(matrix, countDots, currentRow - 1, currentCol+1);
            }
        }
        if (matrix[currentRow].charAt(currentCol+1) == 'x') {
            log.info("cannot move up anymore....");
            log.info("The total number of dots counted : " + countDots);
        }
    }

    private static void moveTowardsUp(String[] matrix, int countDots, int currentRow, int currentCol) {
        log.info("moveTowardsUp() method is called....");
        if (matrix[currentRow].charAt(currentCol) == '.' && currentCol!=0 && currentRow!=0) {
            countDots++;
            currentRow = currentRow-1;
            if(currentRow>=0){
                log.info("moving up....");
                moveTowardsUp(matrix,countDots,currentRow,currentCol);
            }else{
                log.info("cannot move up anymore....");
                log.info("The number of dots are : {}",countDots);
            }
        }
        log.info("arrived to the starting position, the number of dots : {}",countDots);
    }
}
