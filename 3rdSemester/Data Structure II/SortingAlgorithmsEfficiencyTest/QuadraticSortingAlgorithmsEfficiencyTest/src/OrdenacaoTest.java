import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class OrdenacaoTest {

    int[]  listaAleatoria = IntStream.generate(() -> new Random().nextInt(1000000)).limit(1000000).toArray();



    @Test
    public void bubbleSortTest() {
        long startTime = System.currentTimeMillis();
        Ordenacao.bubbleSort(listaAleatoria, 100);
        long endTime = System.currentTimeMillis();

        System.out.println("\tBubbleSortTest");
        System.out.println("100 elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        Ordenacao.bubbleSort(listaAleatoria, 1000);
        endTime = System.currentTimeMillis();
        System.out.println("1K elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        Ordenacao.bubbleSort(listaAleatoria, 20000);
        endTime = System.currentTimeMillis();
        System.out.println("20K elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");
    }


    @Test
    public void insertionSortTest() {
        long startTime = System.currentTimeMillis();
        Ordenacao.insertionSort(listaAleatoria, 100);
        long endTime = System.currentTimeMillis();

        System.out.println("\tInsertionSortTest");
        System.out.println("100 elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        Ordenacao.insertionSort(listaAleatoria, 1000);
        endTime = System.currentTimeMillis();
        System.out.println("1K elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        Ordenacao.insertionSort(listaAleatoria, 20000);
        endTime = System.currentTimeMillis();
        System.out.println("20K elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");
    }

    @Test
    public void selectionSortTest() {
        long startTime = System.currentTimeMillis();
        Ordenacao.selectionSort(listaAleatoria, 100);
        long endTime = System.currentTimeMillis();

        System.out.println("\tSelectionSortTest");
        System.out.println("100 elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        Ordenacao.selectionSort(listaAleatoria, 1000);
        endTime = System.currentTimeMillis();
        System.out.println("1K elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");

        startTime = System.currentTimeMillis();
        Ordenacao.selectionSort(listaAleatoria, 20000);
        endTime = System.currentTimeMillis();
        System.out.println("20K elementos - Tempo de execução: " + (endTime - startTime) + " milisegundos");
    }



}