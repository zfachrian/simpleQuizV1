
public class AccountHandler extends AbstractHandler {

	@Override
	LecturerQuiz manageQuiz(String quiz) {

		return null;
	}

	@Override
	LecturerAccount manageAccount(String account) {
		if (account == null) {
			return null;
		}

		if (account.equalsIgnoreCase("MODIFY")) {
			return new ModifyAccount();

		} else if (account.equalsIgnoreCase("VIEW")) {
			return new ViewAllAccount();
		}

		return null;
	}

}
