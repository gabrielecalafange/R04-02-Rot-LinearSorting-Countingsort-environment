package sorting.linearSorting;


import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length > 0 && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			
			int tamanho = valorMax(array, leftIndex, rightIndex);
			int m = valorMin(array, leftIndex, rightIndex);

			if (m == 0) {
				tamanho++;
			}

			int[] aux = new int[tamanho];

			for (int i = leftIndex; i <= rightIndex; i++) {

				int elemento = array[i];
				int posicao = elemento - m;

				aux[posicao] += 1;
			}

			for (int i = 1; i < aux.length; i++) {
				aux[i] = aux[i] + aux[i - 1];
			}

			int[] helper = new int[array.length];

			for (int i = 0; i < array.length; i++) {
				helper[i] = array[i];
			}

			for (int i = rightIndex; i >= leftIndex; i--) {
				aux[helper[i] - m]--;
				array[aux[helper[i] - m] + leftIndex] = helper[i];
			}
		}
	}

	public static int valorMax(Integer[] array, int leftIndex, int rightIndex) {

		int k = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (k < array[i]) {
				k = array[i];
			}
		}

		return k;
	}

	public static int valorMin(Integer[] array, int leftIndex, int rightIndex) {

		int k = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (k > array[i]) {
				k = array[i];
			}
		}

		return k;
	}

}