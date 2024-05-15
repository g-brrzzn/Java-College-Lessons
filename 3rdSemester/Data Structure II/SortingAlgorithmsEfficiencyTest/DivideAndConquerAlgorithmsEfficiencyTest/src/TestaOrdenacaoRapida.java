
public class TestaOrdenacaoRapida {

	public static void main(String[] args) {
		double guilherme = 7;
		double[] notas = {
				4,
				8.5,
				10,
				3,
				6.7,
				9.3,
				9,
				5,
				guilherme };

		quickSort(notas, 0, notas.length);

		for (int atual = 0; atual < notas.length; atual++) {
			double nota = notas[atual];
			System.out.println(nota + " " + nota);
		}
	}

	public static void quickSort(double[] notas, int de, int ate) {

		int elementos = ate - de;
		if (elementos > 1) {
			int posicaoDoPivo = particiona(notas, de, ate);
			quickSort(notas, de, posicaoDoPivo);
			quickSort(notas, posicaoDoPivo + 1, ate);
		}
	}

	private static int particiona(double[] notas, int inicial, int termino) {

		int menoresEncontrados = inicial;
		double pivo = notas[termino - 1];

		for (int analisando = inicial; analisando < termino - 1; analisando++) {
			double atual = notas[analisando];
			if (atual <= pivo) {
				troca(notas, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}
		troca(notas, termino - 1, menoresEncontrados);
		return menoresEncontrados;
	}

	private static void troca(double[] notas, int de, int para) {

		double nota1 = notas[de];
		double nota2 = notas[para];
		notas[para] = nota1;
		notas[de] = nota2;

	}

}
