
public class ProfessorFactoryProducer {
	public static AbstractFactory getFactory(String choice){
		   
	      if(choice.equalsIgnoreCase("QUIZ")){
	         return new ProfessorQuizFactory();
	         
	      }else if(choice.equalsIgnoreCase("ACCOUNT")){
	         return new ProfessorAccountFactory();
	      }
	      
	      return null;
	   }
}
