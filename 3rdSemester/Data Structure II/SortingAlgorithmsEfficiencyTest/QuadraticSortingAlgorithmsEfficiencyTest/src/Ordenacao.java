public class Ordenacao {
	public static void bubbleSort(int[] numeros, int quantidadeElementos) {
		
		for (int i=0; i<quantidadeElementos-1; i++) {
			boolean trocou = false;
			for (int j=0; j<quantidadeElementos-1-i; j++) {
				if (numeros[j] > numeros[j+1]) {
					trocar(numeros, j, j+1);
					trocou = true;
				}
			}
			if (!trocou) {
				break;
			}
		}
	}
	
	
	public static void insertionSort(int[] numeros, int quantidadeElementos){
		
		for (int posAtual=1; posAtual<quantidadeElementos; posAtual++) {
			int posAnalise = posAtual;
			while (posAnalise > 0 && numeros[posAnalise] < numeros[posAnalise-1]) {
				trocar(numeros, posAnalise, posAnalise - 1);
				posAnalise--;
			}
			
		}
	}

	public static void selectionSort(int[] numeros, int quantidadeElementos) {
		
		for (int posAtual=0; posAtual<quantidadeElementos-1; posAtual++) {
			int posMenor = buscaMenorSalario(numeros, posAtual, quantidadeElementos -1);
			trocar(numeros, posAtual, posMenor);
		}
		
	}


	private static void trocar(int[] numeros, int posAtual, int posMenor) {
		int primeiro = numeros[posMenor];
		int segundo = numeros[posAtual];
		numeros[posMenor] = segundo;
		numeros[posAtual] = primeiro;
	}

	
	public static int buscaMenorSalario(int[] numeros, int posicaoInicio, int posicaoTermino) {
		
		int posicaoMenorSalario = posicaoInicio;
		
		for (int posAtual=posicaoInicio; posAtual<=posicaoTermino; posAtual++) {
			if (numeros[posAtual] < numeros[posicaoMenorSalario]) {
				posicaoMenorSalario = posAtual;
			}
		}
		return posicaoMenorSalario;
	}
	
	
	
	

}
