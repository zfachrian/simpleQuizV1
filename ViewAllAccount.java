import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ViewAllAccount implements ProfessorAccount{

	@Override
	public void Account() {
		//System.out.println("View All Accounts");
		ViewAllUsers();
	}
	
	// search and report user type
	public void ViewAllUsers() {
		File file = new File("AccountFile.txt");
		Scanner userFile = null;
		
		try {
			userFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(userFile.hasNext()) {
			String name = userFile.next();
			String pass = userFile.next();
			String type = userFile.next();
			
			System.out.printf("UserType: %s%nUsername: %s%nPassword: %s%n%n", type, name, pass);
		}

	}
	
}
