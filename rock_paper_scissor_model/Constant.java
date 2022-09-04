package rock_paper_scissor_model;

import java.util.HashMap;
import java.util.Map;

public class Constant {

	static final int ROCK = 0;
	static final int PAPER = 1;
	static final int SCISSOR = 2;

	public static final int GAME_COUNT = 3;

	// file path
	// public static final String PATH =
	// Paths.get("").toAbsolutePath().toString();
	public static final String PATH = "D:/";
	public static final String FOLDER = "/score";
	public static final String FILE = "/record.csv";
	public static final String FULL_PATH = PATH + FOLDER + FILE;

	public static final Map<Integer, String> RPS_MAP = new HashMap<Integer, String>() {

		private static final long serialVersionUID = 1L;

		{
			put(ROCK, "ROCK");
			put(PAPER, "PAPER");
			put(SCISSOR, "SCISSOR");
		}
	};

}
