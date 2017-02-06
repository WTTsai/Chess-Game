package chessGame;
/**
 * 
 * @author Wan-Ting Tsai
 * 
 * Pieces class contains the position and the color 
 * of the piece. 
 */

public abstract class Pieces{
	private int x;
	private int y;
	private int pieceColor;
	private Player player;
	
	/**
	 * Pieces constructor. 
	 * @param color
	 * @param x
	 * @param y
	 */
	public Pieces(int color, int x, int y, Player player)
	{
		this.pieceColor = color;
		this.x = x;
		this.y = y;
		this.player = player;
	}
	
	/**get function for piece color 
	 * 
	 * @return
	 */
	public int getcolor(){
		return this.pieceColor;
	}
	
	/**get function for x position
	 * 
	 * @return
	 */
	public int getx(){
		return this.x;
	}
	
	/**get function for y position
	 * 
	 * @return
	 */
	
	public int gety(){
		return this.y;
	}
	
	/**set position for piece at x, y
	 * 
	 * @param x
	 * @param y
	 */
	
	public Player getPlayer(){
		return this.player;
	}
	public void setPiece(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**set color for piece 
	 * 
	 * @param color
	 */
	public void setcolor(int color){
		this.pieceColor = color;
	}
	/**
	 * 
	 * @param x
	 */
	public void setx(int x){
		this.x = x;
	}
	/**
	 * 
	 * @param y
	 */
	public void sety(int y){
		this.y = y;
	}
	
	public void setPlayer(Player player){
		this.player = player;
	}
	
	//helper function for Pawn
	void capture_enemy(Chessboard board, int[][] validBoard, int color, int newx, int newy) {
		if(newx <=7  && newx >= 0 && newy <= 7 && newy >=0)
		{
			//fill position with enemy piece
			if(board.getPosition(newx, newy) != null && board.getPosition(newx, newy).getcolor() != color)
			{
				validBoard[newx][newy] = 1;
			}
		}
	}
	
	//helper function for Knight and King
	void validMove(int[][] validBoard, int newx, int newy, int color, Chessboard Board) {
		if(newx <=7 && newx >= 0 && newy <=7 && newy >=0)
		{
			//new position is empty
			if(Board.getPosition(newx, newy) == null){
				validBoard[newx][newy] = 1;
			}
			//set at enemy's place
			else {
				capture_enemy(Board, validBoard, color, newx, newy);
			}
		}
	}
	

	//helper function for Bishop and Queen and Knightrider 
	int validMove_blocked(int[][] validBoard, int newx, int newy, Chessboard Board, int blocked){
		if(Board.getPosition(newx, newy) == null){
			validBoard[newx][newy] = 1;
			
			blocked = 0;
		}
		else{
			
			blocked = 1;
		}
		return blocked;
	}
	
	abstract int[][] validMove(Chessboard Board);
	
}