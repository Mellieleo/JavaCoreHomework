package Homework_2;

import java.util.Scanner;

public class Exceptions {

    static String enterData () {
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    static void myArray (String[][] array) throws MyArrayDataException, MyArraySizeException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException ("Incorrect length!");
        }
        System.out.println("Please enter data:");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = enterData();
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("index [" + i + "],[" + j + "]");
                }
            }
        }

        System.out.println("The sum of all entered numbers is: " + sum);
    }



    public static void main(String[] args) {
        String[][] arr = new String[4][4];
        try {
            myArray(arr);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("You've entered incorrect data!");

        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("The length of your array must be 4 x 4!");
        }
    }
}
