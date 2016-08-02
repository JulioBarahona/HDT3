/**
*MainHDT3, Clase Driver 
*@version: 1.08.16
*@author: Rafael Leon, Pablo Lopez, Julio Barahona
*/

import static java.lang.System.*;
import java.util.Scanner;
public class Main {
	/**
	 * @param args String arguments
	 */
	public static void main(String[] args) {		
		int options = 0;
		Scanner sc = new Scanner(System.in);
		RandomX<Integer> random = new RandomX<Integer>(10);
		Sorts<Integer> sorts = new Sorts<Integer>();
		while (options != 6) {
			out.println("1. Crear archivo");
			out.println("2. Selection sort");
			out.println("3. Insertion sort");
			out.println("4. Quick sort");
			out.println("5. Salir");
			try {
				options = sc.nextInt();
				switch (options) {
				case 1:
					int cant = 0;
					while (cant < 10 || cant > 3000) {
						try {
							out.println("Ingrese la cantidad de nÃºmeros aleatorios a generar:");
							cant = sc.nextInt();
						} catch (Exception e) {
							out.println("Ingrese un nÃºmero correcto...");
							sc.nextLine();
						}	
					}
					random.setCantRandom(cant);
					random.CrearArchivo("Random.txt");
					out.println("Datos: " + random.getCantRandom());
					break;
				case 2:
					Integer[] arr4 = random.LeerArchivo("Random.txt");
					Integer[] sorted4 = sorts.SelectionSort(arr4);
					for (int i = 0; i != sorted4.length; i++) {
						out.println(sorted4[i].toString());
					}
					break;
				case 3:
					Integer[] arr2 = random.LeerArchivo("Random.txt");
					Integer[] sorted2 = sorts.InsertionSort(arr2);
					for (int i = 0; i != sorted2.length; i++) {
						out.println(sorted2[i].toString());
					}
					break;
				case 4:
					Integer[] arr = random.LeerArchivo("Random.txt");
					Integer[] sorted = sorts.QuickSort(arr);
					for (int i = 0; i != sorted.length; i++) {
						out.println(sorted[i].toString());
					}
					break;
				case 5:
					sc.close();
					break;
				}
			} catch (Exception e) {
				sc.nextLine();
			}
		}
	}

}
