package rock_paper_scissor_model;

import java.util.Scanner;

public class Person extends Player implements Actionable {

	Difficulty difficulty = null;
	int choice;
	Scanner sc = new Scanner(System.in);

	public Person() {
		setScore(0);
	}
	
	 public Person(String name) {
	 super(name);
	
	 }

	public int getChoice() {
		return choice;
	}

	@Override
	public void increaseScore(int score) {

		// score=score+1;
		 setScore(score + 1);
		// super.setScore(getScore()+1);
							
							
	}

	//Get Player's Difficulty Level Choice
	public Difficulty acceptDifLevel(char dif) {

		if (dif == 'e') {
			difficulty = Difficulty.EASY;
		} else if (dif == 'm') {
			difficulty = Difficulty.MIDDLE;
		} else {
			System.out.println("Invalid keyword");
		}
		return difficulty;

	}

	//Check player's input is (r,p,s)? or not
	public boolean checkInput(char choice) {

		if (choice == 'r') {
			this.choice = Constant.ROCK;
			return true;

		} else if (choice == 'p') {
			this.choice = Constant.PAPER;
			return true;

		} else if (choice == 's') {
			this.choice = Constant.SCISSOR;
			return true;

		} else {
			System.out.println("Invalid keyword for rpse");
			return false;
		}
	}

	@Override
	public String toString() {
		return "Person [difficulty=" + difficulty + ", choice=" + choice + "]";
	}

}
