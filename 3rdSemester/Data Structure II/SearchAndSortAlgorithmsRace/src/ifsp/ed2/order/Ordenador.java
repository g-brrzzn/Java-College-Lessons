package ifsp.ed2.order;

import ifsp.ed2.model.Customer;

public class Ordenador {

	private static int getMax(Customer[] customers) {
		int max = customers[0].getId();
		for (int i = 1; i < customers.length; i++) {
			if (customers[i].getId() > max) {
				max = customers[i].getId();
			}
		}
		return max;
	}

	private static void countingSort(Customer[] customers, int exp) {
		int n = customers.length;
		Customer[] output = new Customer[n];
		int[] count = new int[10];

		for (int i = 0; i < 10; i++) {
			count[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			int indice = (customers[i].getId() / exp) % 10;
			count[indice]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			int indice = (customers[i].getId() / exp) % 10;
			output[count[indice] - 1] = customers[i];
			count[indice]--;
		}

		for (int i = 0; i < n; i++) {
			customers[i] = output[i];
		}
	}

	public static void radixSort(Customer[] customers) {
		int max = getMax(customers);

		for (int exp = 1; max / exp > 0; exp *= 10) {
			countingSort(customers, exp);
		}
	}

	public static void mergeSort(Customer[] array) {
		if (array.length < 2) {
			return;
		}
		int meio = array.length / 2;
		Customer[] esquerda = new Customer[meio];
		Customer[] direita = new Customer[array.length - meio];

		System.arraycopy(array, 0, esquerda, 0, meio);
		System.arraycopy(array, meio, direita, 0, array.length - meio);

		mergeSort(esquerda);
		mergeSort(direita);
		merge(array, esquerda, direita);
	}

	private static void merge(Customer[] array, Customer[] esquerda, Customer[] direita) {
		int i = 0, j = 0, k = 0;
		while (i < esquerda.length && j < direita.length) {
			if (esquerda[i].getId() <= direita[j].getId()) {
				array[k++] = esquerda[i++];
			} else {
				array[k++] = direita[j++];
			}
		}
		while (i < esquerda.length) {
			array[k++] = esquerda[i++];
		}
		while (j < direita.length) {
			array[k++] = direita[j++];
		}
	}

	public static void heapSort(Customer[] array) {
		int n = array.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(array, n, i);
		}

		for (int i = n - 1; i > 0; i--) {
			Customer temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			heapify(array, i, 0);
		}
	}

	private static void heapify(Customer[] array, int n, int i) {
		int maior = i;
		int esquerda = 2 * i + 1;
		int direita = 2 * i + 2;

		if (esquerda < n && array[esquerda].getId() > array[maior].getId()) {
			maior = esquerda;
		}

		if (direita < n && array[direita].getId() > array[maior].getId()) {
			maior = direita;
		}

		if (maior != i) {
			Customer troca = array[i];
			array[i] = array[maior];
			array[maior] = troca;

			heapify(array, n, maior);
		}
	}

	public static void bubbleSort(Customer[] customers, int quantidadeElementos) {
		for (int i = 0; i < quantidadeElementos - 1; i++) {
			for (int j = 0; j < quantidadeElementos - 1 - i; j++) {
				if (customers[j].getId() > customers[j + 1].getId()) {
					trocar(customers, j, j + 1);
				}
			}
		}
	}

	public static void insertionSort(Customer[] pessoas, int quantidadeElementos) {
		for (int posicaoAtual = 1; posicaoAtual < quantidadeElementos; posicaoAtual++) {
			int posAnalise = posicaoAtual;
			while (posAnalise > 0 && pessoas[posAnalise].getId() < pessoas[posAnalise - 1].getId()) {
				trocar(pessoas, posAnalise, posAnalise - 1);
				posAnalise--;
			}
		}
	}

	public static void quickSort(Customer[] pessoas, int de, int ate) {
		int elementos = ate - de;
		if (elementos > 1) {
			int posicaoDoPivo = particiona(pessoas, de, ate);
			quickSort(pessoas, de, posicaoDoPivo);
			quickSort(pessoas, posicaoDoPivo + 1, ate);
		}
	}

	private static int particiona(Customer[] pessoas, int inicial, int termino) {
		int menoresEncontrados = inicial;
		Customer pivo = pessoas[termino - 1];

		for (int analisando = inicial; analisando < termino - 1; analisando++) {
			Customer atual = pessoas[analisando];
			if (atual.getId() <= pivo.getId()) {
				trocar(pessoas, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}
		trocar(pessoas, termino - 1, menoresEncontrados);
		return menoresEncontrados;
	}

	private static void trocar(Customer[] customers, int posicaoPrimeiro, int posicaoSegundo) {
		Customer primeiro = customers[posicaoPrimeiro];
		Customer segundo = customers[posicaoSegundo];
		customers[posicaoPrimeiro] = segundo;
		customers[posicaoSegundo] = primeiro;
	}
}
