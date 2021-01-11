import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
// import org.apache.commons.io.FileUtils;

public class ModifyAccount implements LecturerAccount {

	@Override
	public void Account() {
		System.out.println("Lecturer Modify Account");
		System.out.println("Current Account Data : ");
		Main.currentAccountInfo();

		// copy account data to temp
		try {
			File fileAcc = new File("AccountFile.txt");
			if (!fileAcc.exists()) {
				System.out.println("Account DB not found!");
			}

			File tempAccFile = new File("myTempAccFile.txt");

			BufferedReader reader = new BufferedReader(new FileReader(fileAcc));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempAccFile));

			// create account
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
			String lineToRemove = Login.currentName + " " + Login.currentPass + " " + Login.currentType;
			// System.out.println("line to remove : " + lineToRemove);
			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				// trim newline when comparing with lineToRemove
				String trimmedLine = currentLine.trim();
				if (trimmedLine.equals(lineToRemove)) {
					writer.write(username + " " + password1 + " " + Login.currentType
							+ System.getProperty("line.separator"));
				} else {
					writer.write(currentLine + System.getProperty("line.separator"));
				}
			}
			writer.close();
			reader.close();
		} catch (IOException ioe) {
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}

		// migrate data from temp to account
		try {
			File file = new File("AccountFile.txt");
			if (!file.exists()) {
				System.out.println("Account DB not found!");
			}

			File tempFile = new File("myTempAccFile.txt");

			BufferedReader reader = new BufferedReader(new FileReader(tempFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close();
			reader.close();
			tempFile.delete();
			System.out.println("Relogin needed to update your current data !");
		} catch (IOException ioe) {
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}
	}
}