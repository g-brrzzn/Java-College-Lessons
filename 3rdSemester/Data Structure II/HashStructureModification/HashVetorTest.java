import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashVetorTest {
	
	private HashVetor tabelaHash;

	@BeforeEach
	void inicializar() {
		tabelaHash = new HashVetor(10);
	}
	
	@Test
	void testCriarTabelaTamanhoZeroNegativo() {
		assertThrows(IllegalArgumentException.class, ()-> new HashVetor(0));
		assertThrows(IllegalArgumentException.class, ()-> new HashVetor(-10));
	}
	
	@Test
	void testAdicionarClienteSemColisao() {
		
		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");
		
		assertEquals(0, tabelaHash.inserir(c1));
		assertEquals(5, tabelaHash.inserir(c2));
		
		assertEquals(22, tabelaHash.buscarClientePorCodigo(22).getCodigo());
		assertEquals(7, tabelaHash.buscarClientePorCodigo(7).getCodigo());
		
	}
	
	@Test
	void testAdicionarClienteComColisao() {
		
		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");		
		Cliente c3 = new Cliente(3645, "Andre", "Rua 10, 230");
		Cliente c4 = new Cliente(511, "Rose", "Rua Das Flores, 2000");
		Cliente c5 = new Cliente(123, "Paulo", "Rua Monte Sinai, 253");
		
		
		assertEquals(0, tabelaHash.inserir(c1));
		assertEquals(5, tabelaHash.inserir(c2));
		assertEquals(0, tabelaHash.inserir(c3));
		assertEquals(1, tabelaHash.inserir(c4));
		assertEquals(0, tabelaHash.inserir(c5));
	
		
		assertEquals(22, tabelaHash.buscarClientePorCodigo(22).getCodigo());
		assertEquals(7, tabelaHash.buscarClientePorCodigo(7).getCodigo());
		assertEquals(3645, tabelaHash.buscarClientePorCodigo(3645).getCodigo());
		assertEquals(511, tabelaHash.buscarClientePorCodigo(511).getCodigo());
		assertEquals(123, tabelaHash.buscarClientePorCodigo(123).getCodigo());
	}

	@Test
	void testContem() {
		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");
		Cliente c3 = new Cliente(3645, "Andre", "Rua 10, 230");

		tabelaHash.inserir(c1);
		tabelaHash.inserir(c2);

		assertTrue(tabelaHash.contem(c1));
		assertTrue(tabelaHash.contem(c2));
		assertFalse(tabelaHash.contem(c3));
	}

	@Test
	void testTamanhoMedio() {
		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");

		tabelaHash.inserir(c1);

		double tamanho1 = tabelaHash.tamanhoMedioPesquisa();

		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");
		Cliente c3 = new Cliente(3645, "Andre", "Rua 10, 230");
		Cliente c4 = new Cliente(511, "Rose", "Rua Das Flores, 2000");
		Cliente c5 = new Cliente(123, "Paulo", "Rua Monte Sinai, 253");
		Cliente c6 = new Cliente(71, "Maria", "Rua 15 de Novembro, 200");
		Cliente c7 = new Cliente(3325, "Andre", "Rua 10, 230");
		Cliente c8 = new Cliente(1311, "Rose", "Rua Das Flores, 2000");
		Cliente c9 = new Cliente(153, "Paulo", "Rua Monte Sinai, 253");

		tabelaHash.inserir(c2);
		tabelaHash.inserir(c3);
		tabelaHash.inserir(c4);
		tabelaHash.inserir(c5);
		tabelaHash.inserir(c6);
		tabelaHash.inserir(c7);
		tabelaHash.inserir(c8);
		tabelaHash.inserir(c9);

		double tamanho2 = tabelaHash.tamanhoMedioPesquisa();

		System.out.println(tamanho1 + " vs " +  tamanho2);
		assertTrue(tamanho2 > tamanho1);
	}

	@Test
	void testExcluir() {
		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");
		Cliente c3 = new Cliente(3645, "Andre", "Rua 10, 230");
		Cliente c4 = new Cliente(511, "Rose", "Rua Das Flores, 2000");
		Cliente c5 = new Cliente(123, "Paulo", "Rua Monte Sinai, 253");
		Cliente c6 = new Cliente(71, "Maria", "Rua 15 de Novembro, 200");
		Cliente c7 = new Cliente(3325, "Andre", "Rua 10, 230");
		Cliente c8 = new Cliente(96354632, "Rose", "Rua Das Flores, 2000");
		Cliente c9 = new Cliente(153, "Paulo", "Rua Monte Sinai, 253");


		tabelaHash.inserir(c1);
		tabelaHash.inserir(c2);
		tabelaHash.inserir(c3);
		tabelaHash.inserir(c4);
		tabelaHash.inserir(c5);
		tabelaHash.inserir(c6);
		tabelaHash.inserir(c7);
		tabelaHash.inserir(c8);
		tabelaHash.inserir(c9);

		assertTrue(tabelaHash.excluir(22)); // c1
		assertTrue(tabelaHash.excluir(7));  // c2
		assertTrue(tabelaHash.excluir(71)); // c6

		System.out.println(tabelaHash.calcularHash(22));
		System.out.println(tabelaHash.calcularHash(3645));
		System.out.println(tabelaHash.calcularHash(43141322));
		System.out.println(tabelaHash.calcularHash(96354632));


		assertTrue(tabelaHash.contem(c3)); //
		assertTrue(tabelaHash.contem(c4));
		assertTrue(tabelaHash.contem(c5));
		assertTrue(tabelaHash.contem(c7));
		assertTrue(tabelaHash.contem(c8)); //
		assertTrue(tabelaHash.contem(c9));



		assertFalse(tabelaHash.contem(c1));
		assertFalse(tabelaHash.contem(c2));
		assertFalse(tabelaHash.contem(c6));
	}
	
	
	
	
	
	
	
	
	
	

}
