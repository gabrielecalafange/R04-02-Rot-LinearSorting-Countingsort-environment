package sorting.linearSorting;

import java.util.Arrays;

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

		if (array.length > 1) {
			Integer[] aux =  new Integer[maiorValor(array) + 1];
		
			for (int i = 0; i < array.length; i++) {
				aux[array[i]- 1] += 1;
			}

			for (int i = 1; i < aux.length; i ++) {
				aux[i] += aux[i-1];
			}

			Integer[] output = new Integer[array.length];

			for (int i = aux.length - 1; i >= 0; i--) {
				output[aux[array[i] - 1] - 1] = array[i];
				aux[array[i] - 1] -= 1;
			}
			array = output;
		}

	}

	private static int maiorValor(Integer[] array) {
		
		int k = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(k) >= 0) {
				k = array[i];
			}
		}
		return k;
	}

}
