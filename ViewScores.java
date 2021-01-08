import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ViewScores implements ProfessorQuiz {

	@Override
	public void Quiz() {
		System.out.print("Please enter student name: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();

		File file = new File(name + ".txt");
		Scanner input;
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				String word = input.next();
				System.out.println(word);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
