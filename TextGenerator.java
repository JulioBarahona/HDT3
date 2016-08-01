import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

/**
 * Ejercicio en clase semana 3 AET.
 *
 * @author Julio Barahona M
 * @author Rafael Leon
 * @author Pablo Lopez
 * @version 07.27.2016
 */

public class TextGenerator {
    //new array with unsorted numbers that will be tested
    int[] numbers;

    //generates file and makes the int array ready to be used
    public void fileGenerator() throws Exception {

        //makes new random
        Random newRandomNumber = new Random();

        //the randonm determines arrays size [max number (3000) or min number (10)]
        int arrayLength = newRandomNumber.nextInt(3000) + 10;
        System.out.println("arrayLength = " + arrayLength);

        //files name
        Path outputPath = Paths.get("numerosRandom.txt");

        //close not addded , termination when try action finishes
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, Charset.defaultCharset())) {
            //cicle adds numbers to the document
            for (int i = 1; i <= arrayLength; i++) {
                // generates integer between 500000 and 1
                int numberInsideArray = newRandomNumber.nextInt(500000) + 1;

                //debug, also shows what number was added
                System.out.println("Number added " + numberInsideArray);

                //adds number to the file and a space character to later be used as a token
                writer.write(Integer.toString(numberInsideArray) + " ");
            }
        }






        //makes new reader object
        BufferedReader reader = Files.newBufferedReader(outputPath, Charset.defaultCharset());
    }

    //reference took from: http://www.mycstutorials.com/articles/sorting/quicksort
    public void quickSorting(int[] unsortedArray) {

        /**
         * used for quick sort algorithm
         */
        int lowDigit = 0;
        int highDigit = unsortedArray.length - 1;

        //reference:http://www.programcreek.com/2012/11/quicksort-array-in-java/
        if (unsortedArray == null || unsortedArray.length == 0)
            return;

        if (lowDigit >= highDigit)
            return;

        // pick the pivot
        int middle = lowDigit + (highDigit - lowDigit) / 2;
        int pivot = unsortedArray[middle];

        // make left < pivot and right > pivot
        int i = lowDigit, j = highDigit;
        while (i <= j) {
            while (unsortedArray[i] < pivot) {
                i++;
            }

            while (unsortedArray[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = unsortedArray[i];
                unsortedArray[i] = unsortedArray[j];
                unsortedArray[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (lowDigit < j)
            quickSorting(unsortedArray);

        if (highDigit > i)
            quickSorting(unsortedArray);
    }

    // reference: https://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Gnome_sort
    public void gnomeSorting(int[] unsortedArray) {
        for (int index = 1; index < unsortedArray.length; ) {
            if (unsortedArray[index - 1] <= unsortedArray[index]) {
                ++index;
            } else {
                int tempVal = unsortedArray[index];
                unsortedArray[index] = unsortedArray[index - 1];
                unsortedArray[index - 1] = tempVal;
                --index;
                if (index == 0) {
                    index = 1;
                }
            }
        }
    }

    //referemnce:
    public void radixSorting() {

    }

    public void gnomeSorting(){

    }

}
