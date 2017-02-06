package chessGame;

/**Ferz moves like Bishop but only one 
 * square at a time
*/
public class Ferz extends Pieces{
	
	public Ferz(int color, int x, int y, Player player){
		super(color, x, y, player);
	}
	
	//create another 2D array to store the valid move of Ferz
	//initialized all positions to 0, set to 1 if valid move
	public int[][] validMove(Chessboard Board){
		int[][] validBoard = new int[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				validBoard[i][j] = 0;
			}
		}
		
		int currx = this.getx();
		int curry = this.gety();
		
		int newx, newy;
		
		//check if all 4 positions are available for Ferz
		newx = currx+1;
		newy = curry+1;
		FerzMove(validBoard, newx, newy, Board);
		
		newx = currx+1;
		newy = curry-1;
		FerzMove(validBoard, newx, newy, Board);
		
		newx = currx-1;
		newy = curry-1;
		FerzMove(validBoard, newx, newy, Board);
		
		newx = currx-1;
		newy = curry+1;
		FerzMove(validBoard, newx, newy, Board);
				
		return validBoard;
	}
	
	

void FerzMove(int[][] validBoard, int newx, int newy, Chessboard Board){
	if(newx <=7 && newx >= 0 && newy <=7 && newy >=0)
{
	//new position is empty
	if(Board.getPosition(newx, newy) == null){
		validBoard[newx][newy] = 1;
	}
	else{
		validBoard[newx][newy] = 0;
	}
}
}

}