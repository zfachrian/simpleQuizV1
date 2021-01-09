import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ModifyQuiz implements ProfessorQuiz {

	@Override
	public void Quiz() {
		System.out.println("Inside Professor modify quiz");
		new DeleteQuiz();

		// System.out.print("Enter Quiz Set Number: ");
		// Scanner scan = new Scanner(System.in);
		// int quizSetNum = Main.getInput();
		// String questions = "";

		// // create quiz
		// try {
		// File file = new File("QuizSet" + quizSetNum + ".txt");
		// if (!file.exists()) {
		// System.out.println("Quiz Set not found !!");
		// }

		// FileWriter fw = new FileWriter(file, true);
		// BufferedWriter bw = new BufferedWriter(fw);
		// PrintWriter pw = new PrintWriter(bw);

		// System.out.println("Enter the content you want to change:");
		// String Uinput = scan.nextLine();
		// System.out.println("You want to change it to:");
		// String Uinput2 = scan.nextLine();

		// } catch (IOException ioe) {
		// System.out.println("Exception occurred:");
		// ioe.printStackTrace();
		// }
	}
}
