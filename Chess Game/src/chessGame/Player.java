package chessGame;


public class Player {
	private Pieces[] allPieces;
	private int num;
	
	
	public Player(int num){
		this.num = num;
	
	}
	
	//get functions
	public int getPlayerNum(){
		return this.num;
	}
	
	public Pieces[] getPieces(){
		return this.allPieces;
	}
	
	public Pieces getPieceAtx(int i){
		return this.allPieces[i];
	}
	
	//set functions
	public void setPlayerNum(int num)
	{
		this.num = num;
	}
	
	public void setPieces(Pieces[] pieces){
		this.allPieces = pieces;
	}
	 
	public void setPieceAtx(Pieces piece, int i){
		this.allPieces[i] = piece;
	}
	
}