package chessGame;

import chessGame.Pieces;

public class Chessboard {
	private Pieces[][] board;
	private Player[] player;
	private int winner; //-1 for no winner, 0 black wins and 1 white wins
	private int turn;
	
	//setup chessboard as 2D array
	public Chessboard(){
		this.board = new Pieces[8][8];
		this.player = new Player[2];	
		Player Player_0 = new Player(0);
		Player Player_1 = new Player(1);
		this.player[0] = Player_0;
		this.player[1] = Player_1;
		
		Pieces [] black = new Pieces[16];
		Pieces [] white = new Pieces[16];
		for (int i =0; i<8; i++){
			for (int j=0; j<8;j++){
				this.board[i][j] = null;
			}
		}
		for (int i = 0; i<16; i++){
			white[i] = null;
			black[i] = null;
		}

	}
	
	public int getTurn(){
		return this.turn;
	}
	public int getWinner(){
		return this.winner;
	}
	
	public Player getPlayer(int i){
		return this.player[i];
	}
	
	public Pieces[][] getBoard(){
		return this.board;
	}
	
	public Pieces getPosition(int x, int y){
		return this.board[x][y];
	}
	
	
    /**
     * Initialized the board with all the pieces 
     * at start position.
     */
	public void initBoard(){
		this.turn = 0; //black's turn
		this.winner = -1; //no winner yet
		Rook b_rook     = new Rook(0,0,7, this.player[0]);
		this.board[0][0] = b_rook;
		Knight b_knight = new Knight(0,1,7, this.player[0]);
		this.board[1][0] = b_knight;
		Bishop b_bishop = new Bishop(0, 2, 7, this.player[0]);
		this.board[2][0] = b_bishop;
		Queen b_queen = new Queen(0, 3, 7, this.player[0]);
		this.board[3][0] = b_queen;
		King b_king = new King(0, 4, 7, this.player[0]);
		this.board[4][0] = b_king;
		Bishop b_bishop_1 = new Bishop(0, 5, 7, this.player[0]);
		this.board[5][0] = b_bishop_1;
		Knight b_knight_1 = new Knight(0, 6, 7, this.player[0]);
		this.board[6][0] = b_knight_1;
		Rook b_rook_1 = new Rook(0, 7, 7, this.player[0]);
		this.board[7][0] = b_rook_1;
		Pawn b_pawn_0 = new Pawn(0, 0, 6, this.player[0]);
		this.board[0][1] = b_pawn_0;
		Pawn b_pawn_1 = new Pawn(0, 1, 6, this.player[0]);
		this.board[1][1] = b_pawn_1;
		Pawn b_pawn_2 = new Pawn(0, 2, 6, this.player[0]);
		this.board[2][1] = b_pawn_2;
		Pawn b_pawn_3 = new Pawn(0, 3, 6, this.player[0]);
		this.board[3][1] = b_pawn_3;
		Pawn b_pawn_4 = new Pawn(0, 4, 6, this.player[0]);
		this.board[4][1] = b_pawn_4;
		Pawn b_pawn_5 = new Pawn(0, 5, 6, this.player[0]);
		this.board[5][1] = b_pawn_5;
		Pawn b_pawn_6 = new Pawn(0, 6, 6, this.player[0]);
		this.board[6][1] = b_pawn_6;
		Pawn b_pawn_7 = new Pawn(0, 7, 6, this.player[0]);
		this.board[7][1] = b_pawn_7;
		
		Rook w_rook     = new Rook(1,0,0, this.player[1]);
		this.board[0][7] = w_rook;
		Knight w_knight = new Knight(1,1, 0, this.player[1]);
		this.board[1][7] = w_knight;
		Bishop w_bishop = new Bishop(1, 2, 0, this.player[1]);
		this.board[2][7] = w_bishop;
		Queen w_queen = new Queen(1, 3, 0, this.player[1]);
		this.board[3][7] = w_queen;
		King w_king = new King(1, 4, 0, this.player[1]);
		this.board[4][7] = w_king;
		Bishop w_bishop_1 = new Bishop(1, 5, 0, this.player[1]);
		this.board[5][7] = w_bishop_1;
		Knight w_knight_1 = new Knight(1, 6, 0, this.player[1]);
		this.board[6][7] = w_knight_1;
		Rook w_rook_1 = new Rook(1, 7, 0, this.player[1]);
		this.board[7][7] = w_rook_1;
		Pawn w_pawn_0 = new Pawn(1, 0, 1, this.player[1]);
		this.board[0][6] = w_pawn_0;
		Pawn w_pawn_1 = new Pawn(1, 1, 1, this.player[1]);
		this.board[1][6] = w_pawn_1;
		Pawn w_pawn_2 = new Pawn(1, 2, 1, this.player[1]);
		this.board[2][6] = w_pawn_2;
		Pawn w_pawn_3 = new Pawn(1, 3, 1, this.player[1]);
		this.board[3][6] = w_pawn_3;
		Pawn w_pawn_4 = new Pawn(1, 4, 1, this.player[1]);
		this.board[4][6] = w_pawn_4;
		Pawn w_pawn_5 = new Pawn(1, 5, 1, this.player[1]);
		this.board[5][6] = w_pawn_5;
		Pawn w_pawn_6 = new Pawn(1, 6, 1, this.player[1]);
		this.board[6][6] = w_pawn_6;
		Pawn w_pawn_7 = new Pawn(1, 7, 1, this.player[1]);
		this.board[7][6] = w_pawn_7;
		
		Pieces [] black = new Pieces[16];
		Pieces [] white = new Pieces[16];
		
		for(int i = 0; i < 8; i++)
		{
				white[i] = this.board[i][0];
				black[i] = this.board[i][7];
		}
		for (int i = 8; i < 16; i++){
			
			white[i] = this.board[i-8][1];
			black[i] = this.board[i-8][6];
		}
		
		
	}
	
	/**Function to examine whether or not  
	 * the piece can move. 
	 * @param piece
	 * @param posx
	 * @param posy
	 * @return -1 if invalid to move and 0 if valid to move. 
	 */
	public int movePiece(Pieces piece, int posx, int posy){
		int currx = piece.getx();
		int curry = piece.gety();
		
		if(this.turn != piece.getPlayer().getPlayerNum()){
			return -1;
		}
		//check if new position out of bounds
		if(posx < 0 || posx > 7 || posy < 0 || posy > 7){
			return -1;
		}
		
		else {
			
			int[][] valid = piece.validMove(this);
			
			//invalid to move
			if(valid[posx][posy] == 0){
				return -1;
			}
			else if(valid[posx][posy] == 1){		
				//set piece if new position is null
				if(this.board[posx][posy]==null){
					this.board[posx][posy] = piece;
					piece.setPiece(posx, posy);
					this.board[currx][curry] = null;
				}
			    //set piece if new position has an enemy piece
				else{
					this.board[posx][posy].setPiece(-1, -1); //enemy piece dead, set enemy piece to (-1, -1)
					this.board[posx][posy] = piece;
					piece.setPiece(posx, posy);
					this.board[currx][curry] = null;
				}
			}
			return 0;
		}
	}
	
	
	/** Function to see whether or not the current 
	 * board has any check mate situation. 
	 * @return 0 if black is in check mate, 1 if white is in check mate
	 * and -1 if neither are in check mate. 
	 */
	public int checkMate(){
		int checkMate = -1;
		int b_king_x = this.player[0].getPieces()[4].getx();
		int b_king_y = this.player[0].getPieces()[4].gety();
		int w_king_x = this.player[1].getPieces()[4].getx();
		int w_king_y = this.player[1].getPieces()[4].gety();
		
		for(int i = 0; i<16; i++){
			//for all the white pieces, check if validMove include black king's position
			Pieces curr = this.player[0].getPieces()[i];
			if(curr.getx() != -1 && curr.gety() != -1){
				int[][] valid = this.player[0].getPieces()[i].validMove(this);
				if(valid[w_king_x][w_king_y] == 1){
					checkMate = 1; //white check mate
					break;
				}
			}
		}

		for(int i = 0; i<16; i++){
			//for all the white pieces, check if validMove include black king's position
			Pieces curr = this.player[1].getPieces()[i];
			if(curr.getx() != -1 && curr.gety() != -1){
				int[][] valid = this.player[1].getPieces()[i].validMove(this);
				if(valid[b_king_x][b_king_y] == 1){
					checkMate = 0; //black check mate
					break;
				}
			}
		}
		return checkMate;
		
	}
	
	/**
	 * Stalemate to check if player can still move  
	 * @param player
	 * @return 0 if player can move, 1 if player can't move
	 */
	public int stalemate(Player player){
		int stalemate = 1; 
		for (int i = 0; i < 16; i++){
			Pieces piece = player.getPieceAtx(i);
			int[][] valid = piece.validMove(this);
			for(int x = 0; x < 8; x++){
				for(int y = 0; y < 8; y++){
					if(valid[x][y]==1){
						stalemate = 0;
						break;
					}
				}
			}
		}	
		stalemate = 1;
		return stalemate;
	}
	
	/**
	 * Gameover when either white or black king piece is 
	 * set to position (-1, -1). 
	 * @return 0 if black wins, 1 if white wins
	 */
	public int gameOver(){
		int b_king_x = this.player[0].getPieces()[4].getx();
		int b_king_y = this.player[0].getPieces()[4].gety();
		int w_king_x = this.player[1].getPieces()[4].getx();
		int w_king_y = this.player[1].getPieces()[4].gety();
		
		if((b_king_x == -1) && (b_king_y == -1)){
			winner = 1;
		}
		//black wins
		else if((w_king_x == -1) && (w_king_y == -1)){
			winner = 0;
		}
		return winner;
	}

}

	