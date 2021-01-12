
public class LecturerHandlerProducer {
	public static AbstractHandler getHandler(String choice) {

		if (choice.equalsIgnoreCase("QUIZ")) {
			return new LecturerQuizHandler();

		} else if (choice.equalsIgnoreCase("ACCOUNT")) {
			return new LecturerAccountHandler();
		}

		return null;
	}
}
