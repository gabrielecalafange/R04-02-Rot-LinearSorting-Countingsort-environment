package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length > 1 && leftIndex < rightIndex && rightIndex < array.length) {

			int max = CountingSort.valorMax(array, leftIndex, rightIndex);
			int min = CountingSort.valorMin(array, leftIndex, rightIndex);
			int tamanho = max - min + 1;

			int[] aux = new int[tamanho];

			for (int i = leftIndex; i <= rightIndex; i++) {

				int elemento = array[i];
				aux[elemento - min] ++;
			}

			for (int i = 1; i < aux.length; i++) {
				aux[i] = aux[i] + aux[i - 1];
			}

			int[] helper = new int[array.length];

			for (int i = 0; i < array.length; i++) {
				helper[i] = array[i];
			}

			for (int i = rightIndex; i >= leftIndex; i--) {
				aux[helper[i] - min]--;
				array[aux[helper[i] - min] + leftIndex] = helper[i];
			}
		}
	}
}
