import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyScores implements StudentQuizManagement {

	@Override
	public void QuizAction() {
		System.out.println("View My Scores");

		Scanner scan = new Scanner(System.in);

		File file = new File(Login.currentName + ".txt");
		Scanner input;
		try {
			input = new Scanner(file);
			int i = 0;
			while (input.hasNext()) {
				i++;
				String word = input.nextLine();
				System.out.println("Test ke-" + i + " : " + word);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
