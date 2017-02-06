package userInterface;
import javax.swing.*;

import chessGame.Player;
import chessGame.Chessboard;
import userInterface.GameInterface;
import chessGame.Pieces;


public class GameController {
	
	
	private Pieces selectedPiece;
	public Chessboard board;
	public GameInterface gameInterface;
	
	public static void main(String[] args){
		Chessboard board = new Chessboard();
		board.initBoard();
		GameController ChessGame = new GameController();
		ChessGame.board = new Chessboard();
		ChessGame.board.initBoard();
		ChessGame.gameInterface = new GameInterface(board, ChessGame);
		
	}
	
	public Pieces getSelected(){
		return this.selectedPiece;
	}
	
	//select the piece to move
	public void selectPiece(Chessboard board, Pieces piece) 
	{
		//if player selected piece is the correct color
		if(board.getTurn() == piece.getPlayer().getPlayerNum()){
			this.selectedPiece = piece;
		}
		else {
			JFrame popUpWindow = new JFrame();
			JOptionPane.showMessageDialog(popUpWindow, "Cannot move opponent's piece!");
		}
		
	}
	
	//if movable == 0, then the piece is valid to move 
	public void moveSelectPiece(Chessboard board, int i, int j) 
	{
		if(getSelected() == null) return;
		int movable = board.movePiece(getSelected(), i, j);
		this.selectedPiece = null;
		this.gameInterface.panel = new JPanel();
		if(movable == 0)
		{
			this.gameInterface.frame.setVisible(false);
			this.gameInterface = new GameInterface(board, this);
		}
	}
	
	//Start a new board 
	public void restart(){
		Chessboard board = new Chessboard();
		board.initBoard();
		this.gameInterface.frame.setVisible(false);
		this.gameInterface = new GameInterface(board, this);
		JFrame popUpWindow = new JFrame();
		JOptionPane.showMessageDialog(popUpWindow, "Game Restart");
	}
	
	//show the previous board
	public void undo(){
		JFrame popUpWindow = new JFrame();
		JOptionPane.showMessageDialog(popUpWindow, "Undo!");
		this.gameInterface.frame.setVisible(false);
		this.gameInterface = new GameInterface(this.board , this);
		
	}
	
	//when black player pressed forfeit, white player wins, vice versa
	public void forfeit(Chessboard board){
		JFrame popUpWindow = new JFrame();
		JOptionPane.showMessageDialog(popUpWindow, "Player Forfeit!");
		Player player = null;
		if(board.getPlayer(0).getPlayerNum() == board.getTurn()){
			player = board.getPlayer(0);
			JFrame popUpWindow_1= new JFrame();
			JOptionPane.showMessageDialog(popUpWindow_1, "White Wins!");
		}
		else {
			player = board.getPlayer(1);
			JFrame popUpWindow_2 = new JFrame();
			JOptionPane.showMessageDialog(popUpWindow_2, "Black Wins!");
		}
		
	}
	
}
		
			
