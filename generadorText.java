import java.awt.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Ejercicio en clase semana 3 AET.
 *
 * @author Julio Barahona M
 * @author Rafael Leon
 * @author Pablo Lopez
 * 
 * @version 07.27.2016
 */

public class generadorText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO code application logic here
        String nombreArchivo = "secuenciaNumeros.txt";
	try {
		PrintWriter textFile = new PrintWriter("numerosRandom.txt", "UTF-8");
                    textFile.println("test");
                    textFile.close();
                    System.out.println("test");
		}
	catch (FileNotFoundException e){
		e.printStackTrace();
		}
	}

	
	
    }
