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

        //reader object to read line
        String input = reader.readLine();

        //array called token, reades the file and makes new objects each " " (space line) it reads
        String[] tokens = input.split(" ");

        // new integer array called numbers, size og the token lenght
        numbers = new int[tokens.length];

        //parses each string into an int
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
    }

    //reference took from: http://www.mycstutorials.com/articles/sorting/quicksort
    //se comienza a definir metodo
    public static void quickSorting(int[] unsortedArrayInside, int lowInside, int highInside) {
        //lista vacia
        if (unsortedArrayInside == null || unsortedArrayInside.length == 0)
            return;

        //lista incoerente
        if (lowInside >= highInside)
            return;

        // define en cual va a ser el punto 'medio'
        int middleInside = lowInside + (highInside - lowInside) / 2;
        //asigna el pivote
        int pivote = unsortedArrayInside[middleInside];

        // hace la region izquierda y derecha
        int letterI = lowInside, letterJ = highInside;
        while (letterI <= letterJ) {

            //agrega elementos a la lista izquierda
            while (unsortedArrayInside[letterI] < pivote) {
                letterI++;
            }

            while (unsortedArrayInside[letterJ] > pivote) {
                letterJ--;
            }

            //agrega elementos a la lista derecha
            if (letterI <= letterJ) {
                int temp = unsortedArrayInside[letterI];
                unsortedArrayInside[letterI] = unsortedArrayInside[letterJ];
                unsortedArrayInside[letterJ] = temp;
                letterI++;
                letterJ--;
            }
        }

        // recursion para arreglar sub listas
        if (lowInside < letterJ)
            quickSorting(unsortedArrayInside, lowInside, letterJ);

        if (highInside > letterI)
            quickSorting(unsortedArrayInside, letterI, highInside);
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
/**
    //referemnce: http://www.sanfoundry.com/java-program-implement-radix-sort/
    public void radixSorting( int[] unsortedArray){
        int i, m = unsortedArray[0], exponent = 1, arrayLength = unsortedArray.length;
        for (i = 1; i < arrayLength; i++)
            if (unsortedArray[i] > m)
                m = unsortedArray[i];
        while (m / exponent > 0)
        {
            int[] bucket = new int[10];
            for (i = 0; i < arrayLength; i++)
                bucket[(unsortedArray[i] / exponent) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = arrayLength - 1; i >= 0; i--)
                unsortedArray[--bucket[(unsortedArray[i] / exponent) % 10]] = unsortedArray[i];
            for (i = 0; i < arrayLength; i++)
                unsortedArray[i] = unsortedArray[i];
            exponent *= 10;
        }
    }
    **/
}
