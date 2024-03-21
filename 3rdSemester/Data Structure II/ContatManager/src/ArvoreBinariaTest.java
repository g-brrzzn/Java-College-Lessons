import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArvoreBinariaTest {

	private ArvoreBinariaBuscaNome arvore = new ArvoreBinariaBuscaNome();
	private ArvoreBinariaBuscaCodigo arvoreCodigo = new ArvoreBinariaBuscaCodigo();
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();

	@BeforeEach
	void inicializarArvore() {
		arvore = new ArvoreBinariaBuscaNome();
		arvoreCodigo = new ArvoreBinariaBuscaCodigo();
	}

	@Test
	void deveRetornarEhVaziaSemRaiz() {
		assertTrue(arvore.ehVazia());
		assertTrue(arvoreCodigo.ehVazia());
	}

	@Test
	void deveRetornarNaoEhVaziaComRaiz() {
		Contato c = new Contato(123, "Gabriel", 39210731);
		No noUm = new No(c, null, null);
		arvore.setRaiz(noUm, arvoreCodigo);

		assertFalse(arvore.ehVazia());
		assertFalse(arvoreCodigo.ehVazia());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.pegaQuantidadeNos());
		assertEquals(0, arvoreCodigo.pegaQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreSoRaiz() {
		Contato contato = new Contato(123, "Gabriel", 1234567);
		No noCinco = new No(contato, null, null);
		arvore.setRaiz(noCinco, arvoreCodigo);

		assertEquals(1, arvore.pegaQuantidadeNos());
		assertEquals(1, arvoreCodigo.pegaQuantidadeNos());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.pegaAlturaDaArvore());
		assertEquals(0, arvoreCodigo.pegaAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.pegaAlturaDaArvore());
		assertEquals(0, arvoreCodigo.pegaAlturaDaArvore());
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		No noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarNullSePegarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		Contato c = new Contato(123, "gabriel", 38423);
		assertNull(arvore.pegarNoArvorePorValor(c));
	}

	@Test
	void deveRetornarNullSePegarNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		Contato c = new Contato(653, "gabriell", 344423);
		assertNull(arvore.pegarNoArvorePorValor(c));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertNull(arvore.pegarNoArvorePorValor(c));
	}

	@Test
	void adicionarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();

		Contato c = new Contato(123, "gabriel", 38423);
		No no = new No(c, null, null);
		arvore.setRaiz(no, arvoreCodigo);

		assertEquals(0, arvore.pegaAlturaDaArvore());
		assertEquals(c, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(c));
	}

	@Test
	void adicionarNoArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		Contato c = new Contato(123, "gabriel", 38423);
		arvore.adicionaNo(c, arvoreCodigo);

		assertEquals(1, arvore.pegaAlturaDaArvore());
		assertTrue(arvore.contem(c));
		assertTrue(arvoreCodigo.contem(c));
	}

	@Test
	void adicionarNoArvoreComElementosSoFilhoDireito() {

		arvore = builder.montaArvoreRaizFilhoDireito();
		Contato c = new Contato(123, "gabriel", 38423);

		arvore.adicionaNo(c, arvoreCodigo);

		assertEquals(2, arvore.pegaAlturaDaArvore());
		assertTrue(arvore.contem(c));
	}
	
	@Test
	void removerNoArvoreSoRaizValorExiste() {
		arvore = builder.montaArvoreSoRaiz();

		arvore.removeNoPorValor(arvore.getRaiz().getValor(), arvoreCodigo);
		assertNull(arvore.getRaiz());
	}

	@Test
	void removerNoArvoreComElementosDoisFilhosDireitoEsquerdo() {

		arvore = builder.montaArvoreCheiaDoisNiveis();
		Contato c3 = new Contato(456, "cccc", 123127);

		arvore.removeNoPorValor(c3, arvoreCodigo);
		assertFalse(arvore.contem(c3));
	}
	
	@Test
	void removerNoArvoreEspecialParaExclusao() {
		
	
		arvore = builder.montaArvoreEspecialParaExclusao();
		Contato c5 = new Contato(789, "eeeee", 1212427);

		assertTrue(arvore.contem(c5));
		arvore.removeNoPorValor(c5, arvoreCodigo);

		assertFalse(arvore.contem(c5));
		arvore.imprimir2DArvore();
	}
	@Test
	void adicionaMesmoCodigo() {


		arvore = builder.montaArvoreEspecialParaExclusao();
		Contato c1 = new Contato(123, "aa", 1234267);

		assertTrue(arvore.contem(c1));
		arvore.adicionaNo(c1, arvoreCodigo);

		assertTrue(arvore.contem(c1));
	}

	@Test
	void pegaNoPorNomeTeste() {
		arvore = builder.montaArvoreEspecialParaExclusao();
		arvore.pegaNoPorNome("Gabriel");
		arvore.pegaNoPorNome("Artur");
		arvore.pegaNoPorNome("Ana");
		arvore.pegaNoPorNome("Geraldo");
		arvore.pegaNoPorNome("aa");
		arvore.pegaNoPorNome("bbb");
		arvore.pegaNoPorNome("cccc");
		arvore.pegaNoPorNome("ddddd");
	}

	@Test
	void removeNoPorNomeTeste() {
		arvore = builder.montaArvoreEspecialParaExclusao();
		arvore.removeNoPorNome("Gabriel", arvoreCodigo);
		arvore.removeNoPorNome("Artur", arvoreCodigo);
		arvore.removeNoPorNome("Ana", arvoreCodigo);
		arvore.removeNoPorNome("Geraldo", arvoreCodigo);
		arvore.removeNoPorNome("aa", arvoreCodigo);
		arvore.removeNoPorNome("bbb", arvoreCodigo);
		arvore.removeNoPorNome("cccc", arvoreCodigo);
		arvore.removeNoPorNome("ddddd", arvoreCodigo);

		assertFalse(arvore.pegaNoPorNome("aa"));
		assertFalse(arvore.pegaNoPorNome("bbb"));
		assertFalse(arvore.pegaNoPorNome("cccc"));
		assertFalse(arvore.pegaNoPorNome("ddddd"));

		Contato c1 = new Contato(123, "aa", 1234267);
		assertFalse(arvore.contem(c1));
	}

	@Test
	void imprimirArvoreAlfabeticaTeste() {
		arvore = builder.montaArvoreEspecialParaExclusao();
		System.out.println("\n\tImprimindo em Ordem Alfabética:");
		arvore.imprimirAlfabetica();
	}

}
