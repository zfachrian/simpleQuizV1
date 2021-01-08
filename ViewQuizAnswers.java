import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ViewQuizAnswers implements StudentQuizManagement{

	@Override
	public void QuizAction() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the # of quiz set: ");
		int set = scan.nextInt();
		
		File file = new File("QuizAnswer" + set + ".txt");
	    Scanner input;
		try {
			input = new Scanner(file);
			 while (input.hasNext()) {
			      String word  = input.nextLine();
			      System.out.println("Question: " + word);
			      word  = input.nextLine();
			      System.out.println("Answer: " + word);
			    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
