
public class QuizActionMaker {
	private StudentQuizManagement takeQuiz;
	private StudentQuizManagement viewAnswer;
	private StudentQuizManagement myScores;
	
	public QuizActionMaker() {
		takeQuiz = new TakeQuiz();
		viewAnswer = new ViewQuizAnswers();
		myScores = new MyScores();
	}
	
	public void StudentTakeQuiz() {
		takeQuiz.QuizAction();
	}
	
	public void StudentViewAnswer() {
		viewAnswer.QuizAction();
	}
	
	public void StudentViewScores() {
		myScores.QuizAction();
	}
}
