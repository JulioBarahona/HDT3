/**
*Sorts, Esta clase define los metodos sort a utilizar 
*@version: 1.08.16
*@author: Rafael Leon, Pablo Lopez, Julio Barahona
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
	                if ((Integer)array[j] < (Integer)array[index])
	                    index = j;

	            int smallerNumber = (Integer)array[index]; 
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
			int temp = (Integer) datos[numerosOrd];
			for (index = numerosOrd; index > 0; index--){
				if (temp < (Integer)datos[index - 1]){
					datos[index]=datos[index-n];
				}else {
					break;
				}
			}
			int x = (Integer)datos[index];
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
		int pivot = (Integer) datos[low + (high - low)/2];
		while (i <= j) {
			while ((Integer)datos[i] < pivot) {
				i++;
			}
			
			while ((Integer)datos[j] > pivot) {
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
