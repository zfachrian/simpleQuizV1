import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
	public static String currentName, currentPass, currentType;
	
	public String getUserType() throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Username: ");
		String loginUsername = scan.nextLine();
		System.out.print("Password: ");
		String loginPassword = scan.nextLine();
		
		String userType = searchUser(loginUsername, loginPassword);
		
		return userType;
	}
	
	// search and report user type 
	public String searchUser(String username, String password) throws FileNotFoundException {
		File file = new File("AccountFile.txt");
		Scanner userFile = new Scanner(file); 
		
		while(userFile.hasNext()) {
			String name = userFile.next();
			String pass = userFile.next();
			String type = userFile.next();
			if(name.equals(username) && password.equals(pass)) {
				currentName = name;
				currentPass = pass;
				currentType = type;
				//System.out.println(currentName + currentPass + currentType);
				return type;
			}
		}
		
		
		return "";
	}
}
