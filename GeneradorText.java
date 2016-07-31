import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Ejercicio en clase semana 3 AET.
 *
 * @author Julio Barahona M
 * @author Rafael Leon
 * @author Pablo Lopez
 *
 * @version 07.27.2016
 */

public class GeneradorText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        // genera un nuevo arhcivo con su nombre

        //genera nueva identidad random para ser usada
        Random newRandomNumber = new Random();

        //max es 3000 min es 10
        int arrayLength = newRandomNumber.nextInt(3000) + 10;
        System.out.println("arrayLength = " + arrayLength);
        
        Path outputPath = Paths.get("numerosRandom.txt");

        //close not addded , termination when try action finishes
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, Charset.defaultCharset())) {
            //ciclo para agregar al documento la lista de numeros
            for (int i = 1; i <= arrayLength; i++) {
                // generates number
                int numberInsideArray = newRandomNumber.nextInt(500000) + 1;
                
                //debug 
                System.out.println("Number added " + numberInsideArray);
                
                //adds number to the file
                writer.write(Integer.toString(numberInsideArray) + " ");
            }
        }
        
        BufferedReader reader = Files.newBufferedReader(outputPath, Charset.defaultCharset());
        
        String input = reader.readLine();
        String[] tokens = input.split(" ");
        
        int[] numbers = new int[tokens.length];
        
        for (int i=0;i<tokens.length;i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }

    }
	
}
