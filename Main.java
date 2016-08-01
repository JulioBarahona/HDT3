import java.util.Arrays;

/** Ejercicio en clase semana 3 AET.
*
* @author Julio Barahona M
* @author Rafael Leon
* @author Pablo Lopez
*
* @version 07.31.2016
* */

public class Main{


    public static void main(String args[]) throws Exception{


        TextGenerator newTextGenerator = new TextGenerator();
        newTextGenerator.fileGenerator();

        /**
         * Gnome
         */
        // starts the measure of time vs lenght of the gnome algorithm
        //makes a copy of the numbers array, and its lenght
        int[] sort1Data = Arrays.copyOf(newTextGenerator.numbers, newTextGenerator.numbers.length);
        //prints unsorted array
        System.out.println(Arrays.toString(sort1Data));
        // starts timer called sort1Start
        long sort1Start = System.currentTimeMillis();
        //calls function gnomeSorting, in the object newTextGeneratos, parameter sort1Data
        newTextGenerator.gnomeSorting(sort1Data);
        //takes time after sorting is done, called sort1Stop
        long sort1Stop = System.currentTimeMillis();
        //makes difference  in time
        long sort1TotalTime = sort1Stop - sort1Start;
        //prints sorted data
        System.out.println(Arrays.toString(sort1Data));
        //prints details
        System.out.println("Lenght of the array: " + sort1Data.length);
        System.out.println("Gnome Sort took: " + sort1TotalTime + " ms");

        /**
         * Quick
         */
        // starts the measure of time vs lenght of the gnome algorithm
        //makes a copy of the numbers array, and its lenght

        int[] sort2Data = Arrays.copyOf(newTextGenerator.numbers, newTextGenerator.numbers.length);
        //prints unsorted array
        System.out.println(Arrays.toString(sort2Data));
        // starts timer called sort2Start

        int lowOutside = 0;
        int highOutside = sort2Data.length - 1;
        long sort2Start = System.currentTimeMillis();
        //calls function gnomeSorting, in the object newTextGeneratos, parameter sort2Data

        ////based on http://www.programcreek.com/2012/11/quicksort-array-in-java/
        newTextGenerator.quickSorting(sort2Data, lowOutside, highOutside);

        //takes time after sorting is done, called sort2Stop
        long sort2Stop = System.currentTimeMillis();
        //makes difference  in time
        long sort2TotalTime = sort2Stop - sort2Start;
        //prints sorted data
        System.out.println(Arrays.toString(sort2Data));
        //prints details
        System.out.println("Lenght of the array: " + sort2Data.length);
        System.out.println("Quick Sort took: " + sort2TotalTime + " ms");

        /**
         * Radix
         */
        /**
        // starts the measure of time vs lenght of the gnome algorithm
        //makes a copy of the numbers array, and its lenght
        int[] sort3Data = Arrays.copyOf(newTextGenerator.numbers, newTextGenerator.numbers.length);
        //prints unsorted array
        System.out.println(Arrays.toString(sort3Data));
        // starts timer called sort3Start
        long sort3Start = System.currentTimeMillis();
        //calls function gnomeSorting, in the object newTextGeneratos, parameter sort3Data
        newTextGenerator.radixSorting(sort3Data);
        //takes time after sorting is done, called sort3Stop
        long sort3Stop = System.currentTimeMillis();
        //makes difference  in time
        long sort3TotalTime = sort3Stop - sort3Start;
        //prints sorted data
        System.out.println(Arrays.toString(sort3Data));
        //prints details
        System.out.println("Lenght of the array: " + sort3Data.length);
        System.out.println("Radix Sort took: " + sort3TotalTime + " ms");
        */
    }
}
