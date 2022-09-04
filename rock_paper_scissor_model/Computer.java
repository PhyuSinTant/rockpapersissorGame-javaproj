package rock_paper_scissor_model;

import java.util.Random;

public class Computer extends Player implements Actionable {

	int choice;

	public Computer() {
		setName("Computer");
		setScore(0);
	}

	public int getChoice() {
		return choice;
	}

	public int checkDifLevel(Difficulty dif) {
		if (dif == Difficulty.EASY)
			return 1;
		else
			return 3;
	}

	public int generateChoice() {
		Random r = new Random();
		choice = r.nextInt(3);
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	@Override
	public void increaseScore(int score) {
		setScore(score + 1);

	}

}
