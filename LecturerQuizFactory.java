
public class LecturerQuizFactory extends AbstractFactory {

	@Override
	LecturerQuiz manageQuiz(String quiz) {
		if (quiz == null) {
			return null;
		}

		if (quiz.equalsIgnoreCase("ADD")) {
			return new AddQuizSet();
		} else if (quiz.equalsIgnoreCase("MODIFY")) {
			return new ModifyQuiz();
		} else if (quiz.equalsIgnoreCase("VIEW")) {
			return new ViewScores();
		} else if (quiz.equalsIgnoreCase("DELETE")) {
			return new DeleteQuiz();
		}

		return null;
	}

	@Override
	LecturerAccount manageAccount(String account) {

		return null;
	}

}
