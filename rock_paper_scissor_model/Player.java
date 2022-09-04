package rock_paper_scissor_model;

public class Player {
	
	protected String name;
	protected int score;
	
	public Player(){
		
	}
	public Player(String name) {
		
		this.name = name;
		score=0;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	
	

}
