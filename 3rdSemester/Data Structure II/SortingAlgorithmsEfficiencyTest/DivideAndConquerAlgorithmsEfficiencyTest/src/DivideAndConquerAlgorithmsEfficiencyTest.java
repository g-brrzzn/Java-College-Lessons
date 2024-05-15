import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.DoubleStream;

class DivideAndConquerAlgorithmsEfficiencyTest {

    double[] listaAleatoria = DoubleStream.generate(() -> new Random().nextDouble() * 2000000).limit(20000).toArray();
    private static final int[] quantidades = {100, 1000, 20000};

    @Test
    public void quickSortEfficiencyTest() {
        System.out.println("\tQuickSortTest");
        for (int i=0; i<=2; i++) {
            long startTime = System.currentTimeMillis();
            TestaOrdenacaoRapida.quickSort(listaAleatoria, 0, quantidades[i]);
            long endTime = System.currentTimeMillis();
            System.out.println(quantidades[i] + " elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");
        }
    }

    @Test
    public void mergeSortEfficiencyTest() {
        System.out.println("\tMergeSortTest");
        for (int i=0; i<=2; i++) {
            long startTime = System.currentTimeMillis();
            TestaIntercalaUmArray.mergeSort(listaAleatoria, 0, quantidades[i]);
            long endTime = System.currentTimeMillis();
            System.out.println(quantidades[i] + " elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");
        }
    }
}