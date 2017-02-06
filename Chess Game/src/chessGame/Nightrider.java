package chessGame;

/**Nightrider can move any number of steps as a 
 * knight in the same direction until it is blocked 
 * by other pieces. Nightrider cannot leap over 
 * other pieces. 
 */

public class Nightrider extends Pieces{

	public Nightrider(int x, int y, int color, Player player) {
		super(x, y, color, player);
	}
	//create another 2D array to store the valid move of Nightrider
	//initialized all positions to 0, set to 1 if valid move
	public int[][] validMove(Chessboard Board) {
		int[][] validBoard = new int[8][8];
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{	
				validBoard[i][j] = 0;
			}
		}
		
		int currx = this.getx();
		int curry = this.gety();
		
		int newx, newy, blocked;
		
		blocked = 0;
		//check all 8 positions
		while(blocked == 1){
			newx = currx+1;
			newy = curry+2;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
		}
		

		blocked = 0;
		while(blocked == 1){
			newx = currx+2;
			newy = curry+1;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
			
		}
		
		blocked = 0;
		while(blocked == 1){
			newx = currx+2;
			newy = curry-1;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
		}
		
		
		blocked = 0;
		while(blocked == 1){
			newx = currx+1;
			newy = curry-2;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
		}
		
		blocked = 0;
		while(blocked == 1){
			newx = currx-1;
			newy = curry-2;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
		}
		
		blocked = 0;
		while(blocked == 1){
			newx = currx-2;
			newy = curry-1;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
		}
		
		blocked = 0;
		while(blocked == 1){
			newx = currx-2;
			newy = curry+1;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
		}
		
		blocked = 0;
		while(blocked == 1){
			newx = currx-1;
			newy = curry+2;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
		}
		return validBoard;
	}
	


}