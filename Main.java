import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.printf("Weclome to Quiz Applcation! Please select the following option:%n");

		Scanner scan = new Scanner(System.in);

		int RegOrLogin = 0;
		int ProfOrStudent = 0;

		while (RegOrLogin != 3) {
			System.out.printf("1. [ Register an account ]%n2. [ Login to account ]%n3. [ Exit ]%n");
			RegOrLogin = getInput();

			// if user choose to register account
			if (RegOrLogin == 1) {
				while (ProfOrStudent != 1 && ProfOrStudent != 2 && ProfOrStudent != 3) {
					System.out.println("1. [ Register as Professor ]\n" + "2. [ Reigster as Student ]\n" + "3. [ Exit ]");
					ProfOrStudent = getInput();
				}

				// Registered as Professor
				if (ProfOrStudent == 1) {
					System.out.print("Passcode: ");
					String passcode = scan.nextLine();

					if (passcode.equalsIgnoreCase("CS665")) {
						Register register = new Register("Professor");
						register.createAccount();
					} else {
						ProfOrStudent = 0;
						System.out.println("Your passcode is wrong.");
					}
				}

				// Registered as Student
				else if (ProfOrStudent == 2) {
					// createAccount("Student");
					Register register = new Register("Student");
					register.createAccount();
				}
				else if(ProfOrStudent == 3){
					System.out.println("Back to Home Page.");
					ProfOrStudent = 3;
				}

			}
			// if user chooses to log in
			if (RegOrLogin == 2) {
				Login login = new Login();
				String accountType = login.getUserType();

				if (accountType.equals("")) {
					System.out.println("User not found.");
				}
				// processing functions
				else {
					Singleton x = Singleton.getInstance(); 
					System.out.println(x.s);
					
					System.out.println("This is a " + accountType + " accout.");

					if (accountType.equalsIgnoreCase("PROFESSOR")) {
						// System.out.println("Etner professor process here");
						
						int option = 9;
						// Quiz management
						while(option != 0) {
							userMenu();
							option = getInput();
							
							if(option == 1) {
								
								//while(option != 0) {
									System.out.println("1. [ Add Quiz Set ]\n2. [ Modify Quiz Answer ]\n3. [ View Student Scores ]\n4. [ Exit ]");
									option = getInput();
								
									// Add Quiz Set
									if(option == 1) {
										AbstractFactory professorfactory = ProfessorFactoryProducer.getFactory("Quiz");
										ProfessorQuiz professorQuiz = professorfactory.manageQuiz("Add");
										professorQuiz.Quiz();
									}
									// Modify Quiz Answer
									else if(option == 2) {
										System.out.println("Function currently under construction");
									}
									// View Student Scores
									else if (option == 3){
										AbstractFactory professorfactory = ProfessorFactoryProducer.getFactory("Quiz");
										ProfessorQuiz professorQuiz = professorfactory.manageQuiz("VIEW");
										professorQuiz.Quiz();
									}
									// Exit
									else if (option == 4) {
										System.out.println("Back to user page");
										option = 0;
									}
									else {
										System.out.println("Invalid Input.");
									}
								//}
								
							}
							// Account management
							else if(option == 2) {
								System.out.println("1. [ My Account Info ]\n2. [ View All Accounts ]\n3. [ Exit ]");
								option = getInput();
								
								if(option == 1) {
									currentAccountInfo();
								}
								else if (option == 2) {
									AbstractFactory professorfactory = ProfessorFactoryProducer.getFactory("Account");
									ProfessorAccount professorAccount = professorfactory.manageAccount("View");
									professorAccount.Account();
								}
								else if(option == 3) {
									System.out.println("Back to user page");
									option = 0;
								}
								else {
									System.out.println("Invalid Input.");
								}
							}
						}
						/*AbstractFactory professorfactory = ProfessorFactoryProducer.getFactory("Quiz");
						ProfessorQuiz professorQuiz = professorfactory.manageQuiz("Add");
						professorQuiz.Quiz();*/
						
						
						
					} 
					// If Student Logged in
					else if (accountType.equalsIgnoreCase("STUDENT")) {
						//System.out.println(x.s);
						
						int option = 9;
						int studentOption = 9;
						// Quiz management
						while(option != 0) {
							userMenu();
							option = getInput();
							
							// Quiz management
							if(option == 1) {
								System.out.println("1. [ Take Quiz ]\n2. [ View Answers ]\n3. [ My Highest Score ]");
								QuizActionMaker quizActionMaker = new QuizActionMaker();
								studentOption = getInput();
								
								if(studentOption == 1) {
									quizActionMaker.StudentTakeQuiz();
								}
								else if(studentOption == 2) {
									quizActionMaker.StudentViewAnswer();
								}
								else if(studentOption == 3) {
									quizActionMaker.StudentViewScores();
								}
								else {
									option = 0;
								}
							}
							// Account management
							else if(option == 2) {
								System.out.println("1. [ My Account ]");
								studentOption = getInput();
								
								if(studentOption == 1) {
									currentAccountInfo();
								}
								else {
									System.out.println("Invalid Input");
								}
							}
						}
					}
				}
			}
		}

	}

	// return user input
	public static int getInput() {
		int input = 0;
		Scanner scan = new Scanner(System.in);

		try {
			input = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input.");
		}

		return input;
	}

	public static void userMenu() {
		System.out.println("1. [ Quiz Management ]\n2. [ Account Management ]\n0. [ Log off ]");
	}
	
	public static void currentAccountInfo() {
		System.out.println("Account Type: " + Login.currentType + ", " + "Username: " + Login.currentName + ", " + "Password: " + Login.currentPass);
	}

}
