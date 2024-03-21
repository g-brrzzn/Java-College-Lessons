public class ArvoreBinariaBuilder {
	
	private ArvoreBinariaBuscaNome arvore;
	private ArvoreBinariaBuscaCodigo arvoreCodigo;
		
	public ArvoreBinariaBuscaNome montaArvoreVazia() {
		this.arvore = new ArvoreBinariaBuscaNome();
		this.arvoreCodigo = new ArvoreBinariaBuscaCodigo();
		return arvore;
	}

	public ArvoreBinariaBuscaNome montaArvoreSoRaiz() {
		Contato contato = new Contato(123, "Gabriel", 1234567);
		No noCinco = new No(contato, null, null);
		arvore = new ArvoreBinariaBuscaNome();
		arvoreCodigo = new ArvoreBinariaBuscaCodigo();
		arvore.setRaiz(noCinco, arvoreCodigo);
		return arvore;
	}

	public ArvoreBinariaBuscaNome montaArvoreRaizFilhoDireito() {
		Contato c1 = new Contato(123, "Gabriel", 1234567);
		Contato c2 = new Contato(456, "Artur", 1231127);
		No noSete = new No(c1, null, null);
		No noCinco = new No(c2, noSete, null);
		arvore = new ArvoreBinariaBuscaNome();
		arvoreCodigo = new ArvoreBinariaBuscaCodigo();
		arvore.setRaiz(noCinco, arvoreCodigo);
		return arvore;
	}

	public ArvoreBinariaBuscaNome montaArvoreRaizFilhoEsquerdo() {
		Contato c1 = new Contato(123, "Gabriel", 1234567);
		Contato c2 = new Contato(456, "Artur", 1231127);
		No noTres = new No(c2, null, null);
		No noCinco = new No(c1, null, noTres);
		arvore = new ArvoreBinariaBuscaNome();
		arvoreCodigo = new ArvoreBinariaBuscaCodigo();
		arvore.setRaiz(noCinco, arvoreCodigo);
		return arvore;
	}

	public ArvoreBinariaBuscaNome montaArvoreRaizFilhoDireitoEsquerdo() {
		Contato c1 = new Contato(123, "Ana", 1234567);
		Contato c2 = new Contato(456, "Artur", 1231127);
		Contato c3 = new Contato(789, "Astolpho", 1231127);
		No noSete = new No(c3, null, null);
		No noTres = new No(c1, null, null);
		No noCinco = new No(c2, noSete, noTres);
		arvore = new ArvoreBinariaBuscaNome();
		arvoreCodigo = new ArvoreBinariaBuscaCodigo();
		arvore.setRaiz(noCinco, arvoreCodigo);
		return arvore;
	}
	public ArvoreBinariaBuscaNome montaArvoreRaizUmFilhoDireitoDoisEsquerdo() {
		Contato c1 = new Contato(123, "Ana", 1234567);
		Contato c2 = new Contato(456, "Artur", 1231127);
		Contato c3 = new Contato(432, "Gabriel", 12311327);
		Contato c4 = new Contato(789, "Astolpho", 12315427);
		No noSete = new No(c4, null, null);
		No noUm = new No(c1, null, null);
		No noTres = new No(c2, null, noUm);
		No noCinco = new No(c3, noSete, noTres);
		arvore = new ArvoreBinariaBuscaNome();
		arvoreCodigo = new ArvoreBinariaBuscaCodigo();
		arvore.setRaiz(noCinco, arvoreCodigo);
		return arvore;
	}
	public ArvoreBinariaBuscaNome montaArvoreCheiaDoisNiveis() {
		Contato c1 = new Contato(123, "aa", 1234267);
		Contato c2 = new Contato(144, "bbb", 1233337);
		Contato c3 = new Contato(456, "cccc", 123127);
		Contato c4 = new Contato(432, "dddd", 188827);
		Contato c5 = new Contato(789, "eeeee", 1212427);
		Contato c6 = new Contato(989, "ffffff", 154377);
		Contato c7 = new Contato(999, "ggggggg", 1535437);
		No noUm = new No(c1, null, null);
		No noQuatro = new No(c3, null, null);
		No noTres = new No(c2, noQuatro, noUm);
		No noOito = new No(c7, null, null);
		No noSeis = new No(c5, null, null);
		No noSete = new No(c6, noOito, noSeis);
		No noCinco = new No(c4, noSete, noTres);
		arvore = new ArvoreBinariaBuscaNome();
		arvoreCodigo = new ArvoreBinariaBuscaCodigo();
		arvore.setRaiz(noCinco, arvoreCodigo);
		arvoreCodigo.setRaiz(noCinco);
		return arvore;
	}
	
	public ArvoreBinariaBuscaNome montaArvoreEspecialParaExclusao() {

		Contato c1 = new Contato(123, "aa", 1234267);
		Contato c2 = new Contato(144, "bbb", 1233337);
		Contato c3 = new Contato(456, "cccc", 123127);
		Contato c4 = new Contato(432, "dddd", 188827);
		Contato c5 = new Contato(789, "eeeee", 1212427);
		Contato c6 = new Contato(989, "ffffff", 154377);
		Contato c7 = new Contato(999, "ggggggg", 1535437);
		Contato c8 = new Contato(1000, "hhhhhhhh", 15323137);
		Contato c9 = new Contato(1100, "iiiiiiiii", 66663137);
		Contato c10 = new Contato(1200, "jjjjjjjjjj", 66876157);
		Contato c11 = new Contato(1300, "kkkkkkkkkkkk", 668893637);
		Contato c12 = new Contato(1400, "llllllllllllllll", 9798326);
		
		arvore = new ArvoreBinariaBuscaNome();
		arvoreCodigo = new ArvoreBinariaBuscaCodigo();
		arvore.adicionaNo(c8, arvoreCodigo);
		arvore.adicionaNo(c9, arvoreCodigo);
		arvore.adicionaNo(c11, arvoreCodigo);
		arvore.adicionaNo(c12, arvoreCodigo);
		arvore.adicionaNo(c10, arvoreCodigo);
		arvore.adicionaNo(c2, arvoreCodigo);
		arvore.adicionaNo(c6, arvoreCodigo);
		arvore.adicionaNo(c7, arvoreCodigo);
		arvore.adicionaNo(c5, arvoreCodigo);
		arvore.adicionaNo(c3, arvoreCodigo);
		arvore.adicionaNo(c4, arvoreCodigo);
		arvore.adicionaNo(c1, arvoreCodigo);
		return arvore;
		
		
	}

}
