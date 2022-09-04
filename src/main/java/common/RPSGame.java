package common;

import java.util.Random;
import java.util.Scanner;

public class RPSGame {

	public  InputEnum generateComputerChoice(Random random) throws InterruptedException {
		InputEnum computerChoice = null;
		//Choosing a random number using the inbuilt function
		int wordNumber = random.nextInt(3) + 1;
		computerChoice = InputEnum.values()[wordNumber-1];

		printer("\nThe Computer already made it's choice");
		return computerChoice;
	}

	public  void showMenu() throws InterruptedException {
		printer("Options to choose Integer Input from :\n1.Rock\n2.Paper\n3.Scissors");
	}

	public  InputEnum getUserChoice(Scanner scanner) throws InterruptedException {

		InputEnum inputVal = null;
		try {
			printer("\nPlease make yours : ");
			String userWordChoice = scanner.nextLine();
			Integer userInput = Integer.valueOf(userWordChoice);
			inputVal = InputEnum.values()[userInput-1];
		} catch (Exception e) {
			printer("Please try with valid inputs: ");
			throw e;
		}
		//Returning the user choice
		return inputVal;

	}

	public  String chooseWinner(InputEnum computerChoice, InputEnum userChoice) {

		String winner = RPSCommonConstants.TIE;
		String customMessage = RPSCommonConstants.TIE_MSG;

		//Winner Logic for the game start
		if (computerChoice == InputEnum.ROCK  && userChoice == InputEnum.SCISSOR) {
			winner = RPSCommonConstants.COMPUTER;
			customMessage =  RPSCommonConstants.ROCK_MSG;
		} else if (userChoice == InputEnum.ROCK  && computerChoice == InputEnum.SCISSOR) {
			winner = RPSCommonConstants.USER;
			customMessage =  RPSCommonConstants.ROCK_MSG;
		}

		if (computerChoice == InputEnum.SCISSOR  && userChoice == InputEnum.PAPER) {
			winner = RPSCommonConstants.COMPUTER;
			customMessage = RPSCommonConstants.SCISSOR_MSG;
		} else if (computerChoice == InputEnum.PAPER && userChoice == InputEnum.SCISSOR) {
			winner = RPSCommonConstants.USER;
			customMessage = RPSCommonConstants.SCISSOR_MSG;
		}

		if (computerChoice == InputEnum.PAPER && userChoice == InputEnum.ROCK) {
			winner = RPSCommonConstants.COMPUTER;
			customMessage = RPSCommonConstants.PAPER_MSG;
		} else if (userChoice == InputEnum.PAPER && computerChoice == InputEnum.ROCK) {
			winner = RPSCommonConstants.USER;
			customMessage = RPSCommonConstants.PAPER_MSG;
		}

		//Winner Logic for the game ends
		String finalMessage = winner + " won ( " + customMessage + " )";

		return finalMessage;
	}

	public  void printer(String s) throws InterruptedException {
		System.out.println(s);
		Thread.sleep(1000);
	}

	public  void play() throws InterruptedException {

		String play = "";
		while (!play.equals("0"))
		{
			Random random = new Random();
			Scanner scanner = new Scanner(System.in);
			InputEnum userChoice = null;
			String winner;

			showMenu();
			InputEnum computerChoice = generateComputerChoice(random);

			boolean success = false;
			int attempt = 5;

			while (!success && attempt>0)
			{
				try{
					userChoice = getUserChoice(scanner);
					success = true;
				} catch(Exception e) {
					printer(String.format("Attempts remaining: %s ", --attempt));
				}
			}

			if(attempt == 0)
			{
				printer("Sorry, you are out of Attempts");
				break;
			}

			winner = chooseWinner(computerChoice, userChoice);

			printer("You choose : " + userChoice + "\nComputer choose : " + computerChoice);
			printer(winner);

			printer("\nplease any key to continue, 0 to exit");
			play = scanner.nextLine();
		}

	}
}
