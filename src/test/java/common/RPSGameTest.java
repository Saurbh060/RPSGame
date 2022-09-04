package common;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPSGameTest {

	@Test
	void chooseWinnerInRockPaper()
	{
		RPSGame obj = new RPSGame();

		String actualWinner = obj.chooseWinner(InputEnum.ROCK, InputEnum.PAPER);
		String expectedResponse = RPSCommonConstants.USER + " won ( " + RPSCommonConstants.PAPER_MSG + " )";

		assertEquals(expectedResponse, actualWinner);
	}

	@Test
	void chooseWinnerInPaperRock()
	{
		RPSGame obj = new RPSGame();

		String actualWinner = obj.chooseWinner(InputEnum.PAPER, InputEnum.ROCK);
		String expectedResponse = RPSCommonConstants.COMPUTER + " won ( " + RPSCommonConstants.PAPER_MSG + " )";

		assertEquals(expectedResponse, actualWinner);
	}

	@Test
	void chooseWinnerInScissorRock()
	{
		RPSGame obj = new RPSGame();

		String actualWinner = obj.chooseWinner(InputEnum.SCISSOR, InputEnum.ROCK);
		String expectedResponse = RPSCommonConstants.USER + " won ( " + RPSCommonConstants.ROCK_MSG + " )";

		assertEquals(expectedResponse, actualWinner);
	}

	@Test
	void chooseWinnerInRockScissor()
	{
		RPSGame obj = new RPSGame();

		String actualWinner = obj.chooseWinner(InputEnum.ROCK, InputEnum.SCISSOR);
		String expectedResponse = RPSCommonConstants.COMPUTER + " won ( " + RPSCommonConstants.ROCK_MSG + " )";

		assertEquals(expectedResponse, actualWinner);
	}

	@Test
	void chooseWinnerInPaperScissor()
	{
		RPSGame obj = new RPSGame();

		String actualWinner = obj.chooseWinner(InputEnum.PAPER, InputEnum.SCISSOR);
		String expectedResponse = RPSCommonConstants.USER + " won ( " + RPSCommonConstants.SCISSOR_MSG + " )";

		assertEquals(expectedResponse, actualWinner);
	}
	@Test
	void chooseWinnerInScissorPaper()
	{
		RPSGame obj = new RPSGame();

		String actualWinner = obj.chooseWinner(InputEnum.SCISSOR, InputEnum.PAPER);
		String expectedResponse = RPSCommonConstants.COMPUTER + " won ( " + RPSCommonConstants.SCISSOR_MSG + " )";

		assertEquals(expectedResponse, actualWinner);
	}
}