
public class TestaIntercalaUmArray {

	public static void main(String[] args) {

		double[] notas = {
				4,
				8.5,
				10,
				3,
				6.7,
				7,
				9,
				5,
				9.3};

		mergeSort(notas, 0, notas.length);
		
		for (double nota : notas) {
			System.out.println(nota + " " + nota);
		}

	}

	static void mergeSort(double[] notas, int inicial, int termino) {
		
		int quantidade = termino - inicial;
		if (quantidade > 1) {
			int meio = (inicial + termino) / 2;
			mergeSort(notas, inicial, meio);
			mergeSort(notas, meio, termino);
			intercalar(notas, inicial, meio, termino);
		}
	
	}

	private static void intercalar(double[] notas, int inicial, int miolo, int termino) {
		double resultado[] = new double[termino - inicial];

		int atual = 0;
		int atual1 = inicial;
		int atual2 = miolo;

		while (atual1 < miolo && 
				atual2 < termino) {

			double nota1 = notas[atual1];
			double nota2 = notas[atual2];
			
			if (nota1 < nota2) {
				resultado[atual] = nota1;
				atual1++;
			} else {
				resultado[atual] = nota2;
				atual2++;
			}
			atual++;
		}
		
		while (atual1 < miolo) {
			resultado[atual] = notas[atual1];
			atual1++;
			atual++;
		}
		
		while (atual2 < termino) {
			resultado[atual] = notas[atual2];
			atual2++;
			atual++;
		}
		
		for (int contador=0; contador < atual; contador++) {
			notas[inicial+contador] = resultado[contador];
		}
	}

}







