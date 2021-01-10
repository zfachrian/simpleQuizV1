
public class LecturerFactoryProducer {
	public static AbstractFactory getFactory(String choice) {

		if (choice.equalsIgnoreCase("QUIZ")) {
			return new LecturerQuizFactory();

		} else if (choice.equalsIgnoreCase("ACCOUNT")) {
			return new LecturerAccountFactory();
		}

		return null;
	}
}
