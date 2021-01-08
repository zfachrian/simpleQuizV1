import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddQuizSet implements ProfessorQuiz {

	@Override
	public void Quiz() {
		
		String continueAdd = "";
		while(!continueAdd.equalsIgnoreCase("n")) {
			
			System.out.print("Enter Quiz Set Number: ");
			Scanner scan = new Scanner(System.in);
			int quizSetNum = Main.getInput();
			String questions = "";
			
			// create quiz
			try {
				File file = new File("QuizSet" + quizSetNum + ".txt");
				if (!file.exists()) {
					file.createNewFile();
				}
	
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				System.out.print("Question: ");
				questions = scan.nextLine();
				pw.println(questions);
				System.out.print("Choice A: ");
				String choiceA = scan.nextLine();
				pw.println(choiceA);
				System.out.print("Choice B: ");
				String choiceB = scan.nextLine();
				pw.println(choiceB);
				System.out.print("Choice C: ");
				String choiceC = scan.nextLine();
				pw.println(choiceC);
				System.out.print("Choice D: ");
				String choiceD = scan.nextLine();
				pw.println(choiceD);
				pw.close();
				//System.out.printf("%s Account Successfully Created.%n", getRegisterType());
			}
			catch (IOException ioe) {
				System.out.println("Exception occurred:");
				ioe.printStackTrace();
			}
			
			try {
				File answerFile = new File("QuizAnswer" + quizSetNum + ".txt");
				if (!answerFile.exists()) {
					answerFile.createNewFile();
				}
				
				FileWriter ansFW = new FileWriter(answerFile, true);
				BufferedWriter ansBW = new BufferedWriter(ansFW);
				PrintWriter ansPW = new PrintWriter(ansBW);
				
				ansPW.println(questions);
				System.out.print("Answer: ");
				String answers = scan.nextLine();
				ansPW.println(answers);
				ansPW.close();
				//System.out.printf("Quiz Set %d has been created.%n", quizSetNum);
				
			} 
			catch (IOException ioe) {
				System.out.println("Exception occurred:");
				ioe.printStackTrace();
			}
			
			System.out.println("Continue (y/n)");
			continueAdd = scan.nextLine();
			
		}

	}
}
