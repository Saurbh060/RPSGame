package common;

public enum InputEnum {

	ROCK(1),

	PAPER(2),

	SCISSOR(3);

	private Integer inputNum;

	InputEnum(Integer inputNum) {
		this.inputNum = inputNum;
	}

	public int getInputNum() {
		return inputNum;
	}

	public void setInputNum(Integer inputNum) {
		this.inputNum = inputNum;
	}
}
