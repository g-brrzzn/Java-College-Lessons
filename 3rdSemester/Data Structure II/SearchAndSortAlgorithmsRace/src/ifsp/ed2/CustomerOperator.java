package ifsp.ed2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import ifsp.ed2.model.Customer;

public class CustomerOperator {

	public static List<Customer> loadCustomersFromCSV(String filename) {

		List<Customer> customers = new LinkedList<>();

		boolean header = true;

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!header) {
					String[] data = line.split(";");
					int id = Integer.parseInt(data[0]);
					String firstName = data[1];
					String lastName = data[2];
					String email = data[3];
					String country = data[4];
					String companyName = data[5];
					String occupation = data[6];
					Customer customer = new Customer(id, firstName, lastName, email, country, companyName, occupation);
					customers.add(customer);
				} else {
					header = false;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return customers;
	}



}