package chessGame;

public class Knight extends Pieces{

	public Knight(int x, int y, int color, Player player) {
		super(x, y, color, player);
	}
	//create another 2D array to store the valid move of Knight
	//initialized all positions to 0, set to 1 if valid move
	public int[][] validMove(Chessboard board) {
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
		int currcolor = this.getcolor();
		
		//check all 8 positions
		int newx, newy;
		newx = currx+1;
		newy = curry+2;
		validMove(validBoard, newx, newy, currcolor, board);
		
		newx = currx+2;
		newy = curry+1;
		validMove(validBoard, newx, newy, currcolor, board);
		
		newx = currx+2;
		newy = curry-1;
		validMove(validBoard, newx, newy, currcolor, board);
		
		newx = currx+1;
		newy = curry-2;
		validMove(validBoard, newx, newy, currcolor, board);
		
		newx = currx-1;
		newy = curry-2;
		validMove(validBoard, newx, newy, currcolor, board);
		
		newx = currx-2;
		newy = curry-1;
		validMove(validBoard, newx, newy, currcolor, board);
		
		newx = currx-2;
		newy = curry+1;
		validMove(validBoard, newx, newy, currcolor, board);
		
		newx = currx-1;
		newy = curry+2;
		validMove(validBoard, newx, newy, currcolor, board);
		
		return validBoard;
	}

}