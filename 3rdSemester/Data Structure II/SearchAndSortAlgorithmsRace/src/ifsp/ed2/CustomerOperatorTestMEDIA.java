package ifsp.ed2;

import ifsp.ed2.model.Customer;
import ifsp.ed2.order.Ordenador;
import ifsp.ed2.search.TabelaHash;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerOperatorTestMEDIA {

	private Date inicio;
	private Date termino;

	@Test
	void testFindById() {

		iniciarTarefa("testFindById()");

		List<Customer> customers = CustomerOperator.loadCustomersFromCSV("customerDb200.csv");
		assertEquals(200000, customers.size());

		// =================================================
		/*
		ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
		for (Customer customer : customers) {
			arvore.adicionaNo(customer);
		}

		assertTrue(arvore.contem(451));
		*/

		TabelaHash hashTable = new TabelaHash(200000);
		for (Customer customer : customers) {
			hashTable.inserir(customer.getId(), customer);
		}
		assertTrue(hashTable.contemChave(451));


		// =================================================

		terminarTarefa("testFindById()");
		System.out.println("Duracao (ms): " + calcularDuracaoEmSegundosTarefa());

	}

	@Test
	void testOrderById() {

	int qnt = 20;
	double media = 0;
		for(int i=1; i<=qnt; i++) {

			iniciarTarefa("testOrderById()");
			List<Customer> customers = CustomerOperator.loadCustomersFromCSV("customerDb200.csv");
			assertEquals(200000, customers.size()); // testa quantidade de elementos carregados
			assertEquals(77163, customers.get(0).getId()); // verifica o primeiro elemento antes de ordenar
			assertEquals(126598, customers.get(199999).getId()); // verifica o ultimo elemento antes de ordenar

			// =================================================

			Customer[] arrayCustomers = customers.toArray(new Customer[customers.size()]);

			Ordenador.mergeSort(arrayCustomers);
			//Ordenador.quickSort(arrayCustomers, 0, 200000);
			//Ordenador.radixSort(arrayCustomers);

			//Arrays.sort(arrayCustomers);
			//Ordenador.heapSort(arrayCustomers);

			//Ordenador.insertionSort(arrayCustomers, 200000);
			//Ordenador.bubbleSort(arrayCustomers, 200000);

			// =================================================

			assertEquals(200000, arrayCustomers.length); // testa quantidade de elementos no vetor ordenado
			assertEquals(0, arrayCustomers[0].getId()); // verifica o primeiro elemento depois de ordenar
			assertEquals(199999, arrayCustomers[199999].getId()); // verifica o ultimo elemento depois de ordenar

			terminarTarefa("testOrderById()");
			double resultado = calcularDuracaoEmSegundosTarefa();
			media += resultado;
			System.out.println("Duracao (ms): " + resultado);
		}
		System.out.println("Duracao da MEDIA Merge Sort (ms): " + media/qnt);


		// ********************************************************************************************************************************
		media = 0;
		for(int i=1; i<=qnt; i++) {

			iniciarTarefa("testOrderById()");
			List<Customer> customers = CustomerOperator.loadCustomersFromCSV("customerDb200.csv");
			assertEquals(200000, customers.size()); // testa quantidade de elementos carregados
			assertEquals(77163, customers.get(0).getId()); // verifica o primeiro elemento antes de ordenar
			assertEquals(126598, customers.get(199999).getId()); // verifica o ultimo elemento antes de ordenar

			// =================================================

			Customer[] arrayCustomers = customers.toArray(new Customer[customers.size()]);

			Ordenador.quickSort(arrayCustomers, 0, 200000);
			//Ordenador.radixSort(arrayCustomers);

			//Arrays.sort(arrayCustomers);
			//Ordenador.heapSort(arrayCustomers);

			//Ordenador.insertionSort(arrayCustomers, 200000);
			//Ordenador.bubbleSort(arrayCustomers, 200000);

			// =================================================

			assertEquals(200000, arrayCustomers.length); // testa quantidade de elementos no vetor ordenado
			assertEquals(0, arrayCustomers[0].getId()); // verifica o primeiro elemento depois de ordenar
			assertEquals(199999, arrayCustomers[199999].getId()); // verifica o ultimo elemento depois de ordenar

			terminarTarefa("testOrderById()");
			double resultado = calcularDuracaoEmSegundosTarefa();
			media += resultado;
			System.out.println("Duracao (ms): " + resultado);
		}
		System.out.println("Duracao da MEDIA Quick Sort (ms): " + media/qnt);

		// ********************************************************************************************************************************
		media = 0;
		for(int i=1; i<=qnt; i++) {

			iniciarTarefa("testOrderById()");
			List<Customer> customers = CustomerOperator.loadCustomersFromCSV("customerDb200.csv");
			assertEquals(200000, customers.size()); // testa quantidade de elementos carregados
			assertEquals(77163, customers.get(0).getId()); // verifica o primeiro elemento antes de ordenar
			assertEquals(126598, customers.get(199999).getId()); // verifica o ultimo elemento antes de ordenar

			// =================================================

			Customer[] arrayCustomers = customers.toArray(new Customer[customers.size()]);

			Ordenador.radixSort(arrayCustomers);

			//Ordenador.heapSort(arrayCustomers);


			// =================================================

			assertEquals(200000, arrayCustomers.length); // testa quantidade de elementos no vetor ordenado
			assertEquals(0, arrayCustomers[0].getId()); // verifica o primeiro elemento depois de ordenar
			assertEquals(199999, arrayCustomers[199999].getId()); // verifica o ultimo elemento depois de ordenar

			terminarTarefa("testOrderById()");
			double resultado = calcularDuracaoEmSegundosTarefa();
			media += resultado;
			System.out.println("Duracao (ms): " + resultado);
		}
		System.out.println("Duracao da MEDIA Radix Sort (ms): " + media/qnt);


		// ********************************************************************************************************************************
		media = 0;
		for(int i=1; i<=qnt; i++) {

			iniciarTarefa("testOrderById()");
			List<Customer> customers = CustomerOperator.loadCustomersFromCSV("customerDb200.csv");
			assertEquals(200000, customers.size()); // testa quantidade de elementos carregados
			assertEquals(77163, customers.get(0).getId()); // verifica o primeiro elemento antes de ordenar
			assertEquals(126598, customers.get(199999).getId()); // verifica o ultimo elemento antes de ordenar

			// =================================================

			Customer[] arrayCustomers = customers.toArray(new Customer[customers.size()]);


			Ordenador.heapSort(arrayCustomers);


			// =================================================

			assertEquals(200000, arrayCustomers.length); // testa quantidade de elementos no vetor ordenado
			assertEquals(0, arrayCustomers[0].getId()); // verifica o primeiro elemento depois de ordenar
			assertEquals(199999, arrayCustomers[199999].getId()); // verifica o ultimo elemento depois de ordenar

			terminarTarefa("testOrderById()");
			double resultado = calcularDuracaoEmSegundosTarefa();
			media += resultado;
			System.out.println("Duracao (ms): " + resultado);
		}
		System.out.println("Duracao da MEDIA Heap Sort (ms): " + media/qnt);
	}

	private void iniciarTarefa(String nomeTarefa) {
		inicio = new Date();
	}

	private void terminarTarefa(String nomeTarefa) {
		termino = new Date();
	}

	private long calcularDuracaoEmSegundosTarefa() {
		if (inicio == null || termino == null) {
			System.out.println("A tarefa não foi iniciada ou terminada.");
			return 0;
		}
		long duracaoEmMilissegundos = termino.getTime() - inicio.getTime();
		return duracaoEmMilissegundos;
	}
}
