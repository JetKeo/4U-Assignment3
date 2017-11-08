/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author jetkeo
 */
public class Assignment3 {

    public void swap(int[] array, int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }

    //problem 1
    public void selectionSort(int[] array) {

        //keep track of which position we are switching into
        for (int position = 0; position < array.length; position++) {
            //holds the number

            int lowest = position;
            //look through the rest looking for a smaller number
            for (int i = position + 1; i < array.length; i++) {
                //is the position it is in now lower than the orignial position
                if (array[i] < array[lowest] && array[i] < array[position]) {
                    //the position is the  lowest                 
                    lowest = i;
                }
            }
            //swap numbers
            swap(array, lowest, position);
        }
    }

    //problem 2
    public int smallestMissingNumber(int array[]) {
        //if array at position 0 does not = 0 return 0.
        if (array[0] != 0) {
            return 0;
        } else {
            //else keep finding the differnce between the two numbers
            //until the difference is not 1 then return the number
            for (int i = 0; i < array.length; i++) {
                int dif = array[i + 1] - array[i];
                if (dif != 1) {
                    return array[i] + 1;
                }

            }
        }
        //if you cant find it
        return -1;
    }

    //problem 3
    public int countOnes(int[] array) {
        //counter
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            //if the position = a 1 add to the counter
            if (array[i] == 1) {
                count++;
            }

        }
        //once done counting return the total amount
        return count;
    }

    public int[] countingSort(int[] array) {
        //creates array that counts the amount of same numbers
        int[] count = new int[101];
        //tracks position
        int pos = 0;

        int[] sort = new int[array.length];
        //goes through array and adds 1 to the position 
        //of the count that is respective to the value of the array
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        //goes through array and sorts the numbers according to how many there are
        for (int a = 0; a < count.length; a++) {
            for (int n = 0; n < count[a]; n++) {
                sort[pos] = a;
                //adds 1 to sorted position
                pos++;
            }

        }
        //return sorted array
        return sort;
    }

    //problem 5
    public void alphabeticalInsertionSort(String[] array) {
        // start going through the array
        for (int i = 0; i < array.length - 1; i++) {
            // store position
            int position = i;
            // check values beside each other 
            while (position >= 0 && array[position].compareTo(array[position + 1]) > 0) {
                // if out of place, swap it downwards
                // until correct position is reached 
                String temp = array[position];
                array[position] = array[position + 1];
                array[position + 1] = temp;
                position--;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Assignment3 test = new Assignment3();

        System.out.println("---------------------");
        System.out.println("Problem 1");
        System.out.println("---------------------");
        int[] problem1 = new int[10];
        for (int i = 0; i < problem1.length; i++) {
            //make random numbers
            problem1[i] = (int) (Math.random() * 101);
        }
        //before
        System.out.println("BEFORE:");
        for (int i = 0; i < problem1.length; i++) {
            System.out.println(problem1[i]);
        }
        //SORT HERE
        test.selectionSort(problem1);
        //after
        System.out.println("AFTER:");
        for (int i = 0; i < problem1.length; i++) {
            System.out.println(problem1[i]);
        }
        System.out.println("---------------------");
        System.out.println("Problem 2");
        System.out.println("---------------------");

        int smn[] = {0, 1, 2, 3, 7, 8, 9, 11, 12};
        //sort
        System.out.println("The smallest missing number is:");
        int problem2 = test.smallestMissingNumber(smn);
        System.out.println(problem2);

        System.out.println("---------------------");
        System.out.println("Problem 3");
        System.out.println("---------------------");
        int ones[] = {0, 1, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("There are this many ones in the array:");
        int problem3 = test.countOnes(ones);
        System.out.println(problem3);

        System.out.println("---------------------");
        System.out.println("Problem 4");
        System.out.println("---------------------");
        System.out.println("BEFORE");
        int[] problem4 = new int[101];
        for (int i = 0; i < problem4.length; i++) {
            //make random numbers
            problem4[i] = (int) (Math.random() * 101);
        }
        for (int i = 0; i < problem4.length; i++) {
            System.out.println(problem4[i]);
        }

        System.out.println("AFTER");
        //SORT HERE
        test.countingSort(problem4);
        int[] ans = test.countingSort(problem4);
        for (int i = 0; i < problem4.length; i++) {
            System.out.println(ans[i]);

            System.out.println("---------------------");
            System.out.println("Problem 5");
            System.out.println("---------------------");

            String[] words = new String[13];
            words[0] = "K";
            words[1] = "S";
            words[2] = "I";
            words[3] = "M";
            words[4] = "Y";
            words[5] = "E";
            words[6] = "O";
            words[7] = "G";
            words[8] = "U";
            words[9] = "A";
            words[10] = "Q";
            words[11] = "C";
            words[12] = "W";

            System.out.println("BEFORE");
            for (String word : words) {
                System.out.println(word);
            }

            test.alphabeticalInsertionSort(words);

            System.out.println("AFTER");
            for (String word : words) {
                System.out.println(word);
            }

        }
    }
}
