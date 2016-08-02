/**
*Sorts, Esta clase define los metodos sort a utilizar 
*@version: 1.08.16
*@author: Rafael Leon, Pablo Lopez, Julio Barahona
* reference: Quicksort http://www.programcreek.com/2012/11/quicksort-array-in-java/
* reference: Selection Sort: http://stackoverflow.com/questions/8362640/java-selection-sort-algorithm
* reference: Insertion Sort: http://www.journaldev.com/585/insertion-sort-in-java
*/
public class Sorts<T> implements I_Sorts<T> {

	
	private T datos[];
	/**
	 * 
	 */
	public Sorts() {
		
	}

	@Override
	//Ayuda de Java Structures, Duane A.Bailey
	public T[] SelectionSort(T[] array) {
		 for (int i = 0; i < array.length - 1; i++)
	        {
	            int index = i;
	            for (int j = i + 1; j < array.length; j++)
	                if ((int)array[j] < (int)array[index])
	                    index = j;

	            int smallerNumber = (int)array[index]; 
	            array[index] = array[i];
	            array[i]  = (T) new Integer(smallerNumber);
	        }
	        return array;
	    }
		

	@Override
	public T[] InsertionSort(T[] array) {
		datos = array;
		int n = array.length;
		int numerosOrd = 1;
		int index;
		while(numerosOrd < n){
			int temp = (int) datos[numerosOrd];
			for (index = numerosOrd; index > 0; index--){
				if (temp < (int)datos[index - 1]){
					datos[index]=datos[index-n];
				}else {
					break;
				}
			}
			int x = (int)datos[index];
			x =temp;
			numerosOrd++;
		}
		return datos;
	}

	@Override
	public T[] QuickSort(T[] array) {
		datos = array;
		recursive(0, array.length - 1);
		return datos;
	}
	
	/**
	 * Método recursivo para ordenar arreglo
	 * @param low
	 * @param high
	 */
	private void recursive(int low, int high) {
		int i = low;
		int j = high;
		int pivot = (int) datos[low + (high - low)/2];
		while (i <= j) {
			while ((int)datos[i] < pivot) {
				i++;
			}
			
			while ((int)datos[j] > pivot) {
				j--;
			}
			
			if (i <= j){
				swap(i,j);
				i++;
				j--;
			}
		}
		if (low < j) {
			recursive(low, j);
		}
		if (i < high) {
			recursive(i, high);
		}
	}
	
	/**
	 * Intercambia de posicion dos valores
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j) {
		T temp = datos[i];
		datos[i] = datos[j];
		datos[j] = temp;
	}

	/**
	 * @return datos
	 */
	public T[] GetDatos() {
		return datos;
	}

	/**
	 * @param datos arreglo a ordenar
	 */
	public void SetDatos(T datos[]) {
		this.datos = datos;
	}
}
