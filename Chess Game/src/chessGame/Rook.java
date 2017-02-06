package chessGame;

public class Rook extends Pieces{
	
	public Rook(int color, int x, int y, Player player){
		super(color, x, y, player);
	}
	
	//create another 2D array to store the valid move of Rook 
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
		//int currcolor = this.getcolor();
		
		int newx, newy, blocked;
		
		//check all 4 directions
		//set blocked flag
		blocked = 0;
		while(blocked == 1){
			newx = currx+1;
			newy = curry;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
		}
		

		blocked = 0;
		while(blocked == 1){
			newx = currx;
			newy = curry-1;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
			
		}
		
		blocked = 0;
		while(blocked == 1){
			newx = currx-1;
			newy = curry;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
		}
		
		
		blocked = 0;
		while(blocked == 1){
			newx = currx;
			newy = curry+1;
			blocked = validMove_blocked(validBoard, newx, newy, Board, blocked);
		}
		
		return validBoard;
	}
	

}