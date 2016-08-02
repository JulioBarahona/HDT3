 
/**
*I_Sorts, Esta interfaz define los metodos de ordenamiento
*@version: 1.08.16
*@author: Rafael Leon, Pablo Lopez, Julio Barahona
* Reference: http://www.programcreek.com/2012/11/quicksort-array-in-java/
*/

public interface I_Sorts<T> {
	
	//pre: Recibe una lista ordenada o no ordenada 
	//post: Retorna una lista ordenada
	public Object[] SelectionSort(T array[]);
	
	//pre: Recibe una lista ordenada o no ordenada 
	//post: Retorna una lista ordenada
	public T[] InsertionSort(T array[]);
	
	//pre: Recibe una lista ordenada o no ordenada 
	//post: Retorna una lista ordenada
	public T[] QuickSort(T array[]);
	
}

