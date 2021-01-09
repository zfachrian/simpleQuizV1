import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DeleteQuiz implements ProfessorQuiz {

    @Override
    public void Quiz() {
        System.out.println("Delete Quiz");

        System.out.print("Enter Quiz Set Number: ");
        Scanner scan = new Scanner(System.in);
        int quizSetNum = Main.getInput();
        String questions = "";

        // create quiz
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
            // String lineToRemove = "siapa saya?";
            String currentLine;
            int n = 0;
            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    // continue;
                    n = 1;
                } else if (0 < n && n < 5) {
                    // System.out.println("Exception occurred:" + n);
                    // continue;
                    // this is the line after the line you want to remove
                    n++;
                } else {
                    System.out.println("Stop ");
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            file.delete();
            boolean successful = tempFile.renameTo(file);
            System.out.println(successful);

        } catch (IOException ioe) {
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }
}
