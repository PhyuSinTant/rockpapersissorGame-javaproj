package rock_paper_scissor_application;

import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rock_paper_scissor_model.Computer;
import rock_paper_scissor_model.Constant;
import rock_paper_scissor_model.Difficulty;
import rock_paper_scissor_model.Person;

public class GameLogic {

	Scanner sc = new Scanner(System.in);
	Person p = new Person();
	Computer c = new Computer();

	public void partation() {
		System.out.println("------------------------------------");
	}

	public void init() throws IOException {
		partation();
		System.out.println("Welcome from Rock Paper Scissor Game");
		partation();
		getPlayerName();
		int loop_count = checkDifLevel();
		List<Integer> c_choices = getComputerChoice(loop_count);
		for (int i = 0; i < Constant.GAME_COUNT; i++) {
			checkInput();
			System.out.println("Computer choose:" + Constant.RPS_MAP.get(c_choices.get(i)));
			c.setChoice(c_choices.get(i));
			checkWinner();
			partation();
		}

		printResult();
		saveRecord();

	}

	
	//Get Player's Name From Command Line
	public void getPlayerName() {
		System.out.println("Enter player name:");
		String name = sc.nextLine();
		p.setName(name);

		partation();

	}

	//Check Player's Difficulty Level Until Player Input is True
	private int checkDifLevel() {
		Difficulty dif = null;
		do {
			System.out.println("Choose Difficulty Level Easy:e Middle:m");
			dif = p.acceptDifLevel(sc.nextLine().toLowerCase().charAt(0));
		} while (dif == null);
		int loop_count = c.checkDifLevel(dif);
		return loop_count;
	}

	
	//Check Until Player's Input is True
	public void checkInput() {
		do {
			System.out.println("Choose Rock:r Paper:p Scissor:s");
		} while (!p.checkInput(sc.nextLine().toLowerCase().charAt(0)));

		System.out.println("You chose " + Constant.RPS_MAP.get(p.getChoice()));
	}
	
	
	//Check computer's 1 time choice for easy level and Computer's 3 time choices for middle level in rock,paper,scissor
	public List<Integer> getComputerChoice(int loop_count) {
		// 3,111
		// 1,111
		List<Integer> computer_choices = new ArrayList<>();
		for (int i = 0; i < loop_count; i++) {
			computer_choices.add(c.generateChoice());
		}
		if (computer_choices.size() == 1) {
			computer_choices.add(computer_choices.get(0));
			computer_choices.add(computer_choices.get(0));
		}
		return computer_choices;

		// System.out.println("Computer Choose:"+Constant.RPS_MAP.get(choice));
	}
	

	//Check Winner 
	public void checkWinner() {
		if (p.getChoice() == c.getChoice()) {
			System.out.println("Game is tied.");
		} else {
			int ans = p.getChoice() - c.getChoice();
			if (ans == -1 | ans == 2) {
				System.out.println("Winner is Computer");
				c.increaseScore(c.getScore());
			} else {
				System.out.println("winner is :" + p.getName());
				p.increaseScore(p.getScore());
			}
		}
	}
	

	//Print Result
	public void printResult() {
		// System.out.println(c.getName()+":"+p.getName());
		// System.out.println(c.getScore()+":"+p.getScore());
						// %s=String 		%d=digit
		System.out.printf("%20s :  %s\n%19d : %d", c.getName(), p.getName(), c.getScore(), p.getScore());
	}

	
	//Save Record In Excel Sheet
	public void saveRecord() throws IOException {
		Path dir_path = Paths.get(Constant.PATH + Constant.FOLDER);
		Path full_path = Paths.get(Constant.FULL_PATH);
															//  , means divide columns
		String st = System.lineSeparator() + LocalDate.now() + "," + p.getScore() + "," + c.getScore();
		try {
			Files.createDirectory(dir_path);
			Files.createFile(full_path);
			
			String title = "Date,Person,Computer";

			Files.write(full_path, (title + st).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			Desktop.getDesktop().open(full_path.toFile());
		} catch (FileAlreadyExistsException ex) {
			Files.write(full_path, (st).getBytes(), StandardOpenOption.APPEND);
			Desktop.getDesktop().open(full_path.toFile());
		}

		catch (IOException e) {

			e.printStackTrace();
			System.out.println("File handling something wrong...");
		}
	}

}
