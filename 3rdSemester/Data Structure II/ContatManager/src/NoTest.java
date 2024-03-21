import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoTest {

	@Test
	void deveRetornarEhNoFolhaSoFilhoDireito() {
		Contato c3 = new Contato(456, "cccc", 123127);
		No noUm = new No(c3, null, null);
		No noDois = new No(c3, noUm, null);
		
		assertFalse(noDois.ehFolha());
		assertTrue(noUm.ehFolha());
	}
	
	@Test
	void deveRetornarEhNoFolhaSoFilhoEsquerdo() {
		Contato c2 = new Contato(144, "bbb", 1233337);
		Contato c3 = new Contato(456, "cccc", 123127);
		No noUm = new No(c2, null, null);
		No noDois = new No(c3, null, noUm);
		
		assertFalse(noDois.ehFolha());
		assertTrue(noUm.ehFolha());
	}
	

	@Test
	void deveRetornarEhNoFolhaDoisFilhos() {
		Contato c1 = new Contato(123, "aa", 1234267);
		Contato c2 = new Contato(144, "bbb", 1233337);
		Contato c3 = new Contato(456, "cccc", 123127);
		No noUm = new No(c1, null, null);
		No noDois = new No(c2, null, null);
		No noTres = new No(c3, noUm, noDois);
		
		assertFalse(noTres.ehFolha());
		assertTrue(noUm.ehFolha());
		assertTrue(noDois.ehFolha());
	}
	
	@Test
	void deveRetornarEhNoFolha() {
		Contato c1 = new Contato(123, "aa", 1234267);
		No noUm = new No(c1, null, null);
		assertTrue(noUm.ehFolha());
	}

}
