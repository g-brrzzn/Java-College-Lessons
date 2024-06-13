package ifsp.ed2.search;

import ifsp.ed2.model.Customer;

public class No {

	private Customer customer;
	
	private No direito;
	private No esquerdo;

	public No(Customer customer, No direito, No esquerdo) {
		this.customer = customer;
		this.direito = direito;
		this.esquerdo = esquerdo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public boolean ehFolha() {
		return (direito == null && esquerdo == null);
	}
}
