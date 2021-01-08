
public class ProfessorAccountFactory extends AbstractFactory{

	@Override
	ProfessorQuiz manageQuiz(String quiz) {
		
		return null;
	}

	@Override
	ProfessorAccount manageAccount(String account) {
		if(account == null){
	         return null;
	      }		
	      
	      if(account.equalsIgnoreCase("MODIFY")){
	         return new ModifyAccount();
	         
	      }
	      else if(account.equalsIgnoreCase("VIEW")){
	         return new ViewAllAccount();
	      }
	      
	      return null;
	}

}
