import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ModifyQuiz implements LecturerQuiz {

	@Override
	public void Quiz() {
		System.out.println("modify quiz");

		System.out.print("Enter Quiz Set Number: ");
		Scanner scan = new Scanner(System.in);
		int quizSetNum = Main.getInput();
		String questions = "";

		// delete quiz
		try {
			File file = new File("QuizSet" + quizSetNum + ".txt");
			if (!file.exists()) {
				System.out.println("Quiz Set not found !!");
			}

			File tempFile = new File("myTempFile.txt");

			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			Scanner scanner = new Scanner(System.in);
			System.out.println("question deleted");
			String lineToRemove = scanner.nextLine();
			String currentLine;
			int n = 0;
			while ((currentLine = reader.readLine()) != null) {
				// trim newline when comparing with lineToRemove
				String trimmedLine = currentLine.trim();
				if (trimmedLine.equals(lineToRemove)) {
					// continue;
					n = 1;
				} else if (0 < n && n < 5) {
					// this is the line after the line you want to remove
					n++;
				} else {
					writer.write(currentLine + System.getProperty("line.separator"));
				}
			}
			// quest
			writer.close();
			reader.close();
			file.delete();
			boolean successful = tempFile.renameTo(file);
			System.out.println(successful);

			// delete answer
			File answerFile = new File("QuizAnswer" + quizSetNum + ".txt");
			if (!answerFile.exists()) {
				System.out.println("Quiz Set not found !!");
			}

			File tempAnswerFile = new File("myTempAnswerFile.txt");

			BufferedReader readerAns = new BufferedReader(new FileReader(answerFile));
			BufferedWriter writerAns = new BufferedWriter(new FileWriter(tempAnswerFile));

			String currentLineAns;
			int line = 0; // line indicator
			while ((currentLineAns = readerAns.readLine()) != null) {
				// trim newline when comparing with lineToRemove
				String trimmedLine = currentLineAns.trim();
				if (trimmedLine.equals(lineToRemove)) {
					// this is the line you want to remove
					line = 1;
				} else if (line == 1) {
					// this is the line after the line you want to remove
					line = 0;
				} else {
					writerAns.write(currentLineAns + System.getProperty("line.separator"));
				}
			}
			// ans
			writerAns.close();
			readerAns.close();
			answerFile.delete();
			tempAnswerFile.renameTo(answerFile);
			System.out.println("Question deleted");

		} catch (IOException ioe) {
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}

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
			// System.out.printf("%s Account Successfully Created.%n", getRegisterType());
		} catch (IOException ioe) {
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
			// System.out.printf("Quiz Set %d has been created.%n", quizSetNum);

		} catch (IOException ioe) {
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}
	}
}