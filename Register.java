import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Register {
	private String registerType;

	// Constructor
	public Register(String registerType) {
		this.registerType = registerType;
	}
	
	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	// Create the account method for professor or student
	public void createAccount() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.print("#Username: ");
		String username = scan.nextLine();
		System.out.print("#Password: ");
		String password1 = scan.nextLine();
		System.out.print("#Confirm Password: ");
		String password2 = scan.nextLine();

		// password creation check
		while (!password1.equals(password2)) {
			System.out.println("Passwords not matched. Try again!");
			System.out.print("#Username: ");
			username = scan.nextLine();
			System.out.print("#Password: ");
			password1 = scan.nextLine();
			System.out.print("#Confirm Password: ");
			password2 = scan.nextLine();
		}

		// create and store account information to AccountFile.txt
		try {
			File file = new File("AccountFile.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(username + " " + password1 + " " + getRegisterType());
			pw.close();
			System.out.printf("%s Account Successfully Created.%n", getRegisterType());

		} catch (IOException ioe) {
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}
	}

}
