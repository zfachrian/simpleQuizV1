import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class TakeQuiz implements StudentQuizManagement{

	@Override
	public void QuizAction() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter The Quiz Set Number: ");
		int quizSet = scan.nextInt();
		File file = new File("QuizSet" + quizSet + ".txt");
	    Scanner input;
	    HashMap <String, String> studentAnswer = new HashMap<String, String>();
	    
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				Scanner scanner = new Scanner(System.in);
				String question = input.nextLine();
				System.out.println(question);
				
				String choiceA  = input.nextLine();
				System.out.println("A) " + choiceA);
				String choiceB = input.nextLine();
				System.out.println("B) " + choiceB);
				String choiceC = input.nextLine();
				System.out.println("C) " + choiceC);
				String choiceD = input.nextLine();
				System.out.println("D) " + choiceD);
				
				System.out.print("Enter Your Answer: ");
				String ans = scanner.nextLine();
				if(ans.equalsIgnoreCase("A")) {
					ans = choiceA;
				}
				else if(ans.equalsIgnoreCase("B")) {
					ans = choiceB;
				}
				else if(ans.equalsIgnoreCase("C")) {
					ans = choiceC;
				}
				else if(ans.equalsIgnoreCase("D")) {
					ans = choiceD;
				}
				
				studentAnswer.put(question, ans);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		// Get Student Answer
		int totalQuestions = studentAnswer.size();
		File answerFile = new File("QuizAnswer" + quizSet + ".txt");
	    Scanner getAnswers;
		try {
			getAnswers = new Scanner(answerFile);
			while (getAnswers.hasNext()) {
				String answerQuestion = getAnswers.nextLine();
				String correctAnswer = getAnswers.nextLine();
				
				if(studentAnswer.get(answerQuestion).equalsIgnoreCase(correctAnswer)) {
					studentAnswer.remove(answerQuestion);
					//System.out.println("Compare answer");
				}
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		//System.out.println("studentAnswer.size() = " + studentAnswer.size() + " totalQuestions = " + totalQuestions);
		double result = totalQuestions - studentAnswer.size();
		System.out.printf("You got %.2f out of 100%n", (result/totalQuestions) * 100);
		
		try {
			File scores = new File(Login.currentName + ".txt");
			if (!scores.exists()) {
				scores.createNewFile();
			}

			FileWriter fw = new FileWriter(scores, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(Login.currentName + " " + Math.round((result/totalQuestions) * 100));
			pw.close();
			System.out.printf("Your Score is saved.%n");

		} catch (IOException ioe) {
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}
	}

}
