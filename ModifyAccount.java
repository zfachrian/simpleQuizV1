import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ModifyAccount implements LecturerAccount {

	@Override
	public void Account() {
		System.out.println("Lecturer Modify Account");
		Main.currentAccountInfo();
	}

}
