
public class ProfessorQuizFactory extends AbstractFactory{

	@Override
	ProfessorQuiz manageQuiz(String quiz) {
		if(quiz == null){
	         return null;
	      }		
	      
	      if(quiz.equalsIgnoreCase("ADD")){
	         return new AddQuizSet();
	      }
	      else if(quiz.equalsIgnoreCase("MODIFY")){
	         return new ModifyQuiz();
	      }
	      else if(quiz.equalsIgnoreCase("VIEW")){
	         return new ViewScores();
	      }
	      
	      return null;
	}

	@Override
	ProfessorAccount manageAccount(String account) {

		return null;
	}

}
