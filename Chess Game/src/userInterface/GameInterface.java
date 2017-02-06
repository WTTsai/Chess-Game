package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import chessGame.Bishop;
import chessGame.Chessboard;
import chessGame.King;
import chessGame.Knight;
import chessGame.Pawn;
import chessGame.Pieces;
import chessGame.Queen;
import chessGame.Rook;

public class GameInterface {
	
	public JPanel panel;
	public JFrame frame;
	
	public static void main(String[] args) {
	}

	private JPanel initPanel() 
	{
		JPanel result = new JPanel();
		return result;
	}
	
	public GameInterface(Chessboard board, GameController ChessGame){
		JPanel panel= initPanel();
		this.panel= panel;
		JFrame frame= new JFrame("Chess Game");	
		this.frame= frame;
		panel.setLayout(new GridLayout(8,8));
		frame.setSize(750, 750);
		frame.setContentPane(panel);
		
		for (int i = 0; i < 8; i++){
			for (int j = 0; j<8; j++){
				final int jj = j;
				final int ii = i;
				Pieces piece  = board.getPosition(j, i);
				JButton chessSquare = new JButton();
				//if the piece at position(j, i) is null, insert either black or white background 
				if(piece == null)
				{
					if((i%2 == 0 && j % 2 == 0)||
						(i%2 == 1 && j % 2 == 1)){
						chessSquare.setBackground(Color.white);
					}
					else {
						chessSquare.setBackground(Color.black);
					}
					chessSquare.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							ChessGame.moveSelectPiece(board, ii, jj);
						}
					});
					panel.add(chessSquare);
				}
				//use helper function to insert pieces
				else{
				addPiece(piece, i, j, panel, ChessGame, board);
				}
				
			} 
		}
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
}	

	public void addPiece(Pieces piece, int i, int j, JPanel panel, GameController ChessGame, Chessboard board) {
		String file = null;
			//if playernum = 0, black piece player
			if(piece.getPlayer().getPlayerNum() == 0){
				if(piece instanceof Bishop) 
					file = "images/b_bishop.png";
				else if (piece instanceof Knight) 
					file = "images/b_knight.png";
				else if (piece instanceof King) 
					file = "images/b_king.png";
				else if (piece instanceof Queen) 
					file = "images/b_queen.png";
				else if (piece instanceof Rook) 
					file = "images/b_rook.png";
				else if (piece instanceof Pawn) 
					file = "images/b_pawn.png";
			}
			else {
				if(piece instanceof Bishop) 
					file = "images/w_bishop.png";
				else if (piece instanceof Knight) 
					file = "images/w_knight.png";
				else if (piece instanceof King) 
					file = "images/w_king.png";
				else if (piece instanceof Queen) 
					file = "images/w_queen.png";
				else if (piece instanceof Rook) 
					file = "images/w_rook.png";
				else if (piece instanceof Pawn) 
					file = "images/w_pawn.png";
			}
			
		File imageFile = new File(file);
		BufferedImage bufferedImage = null;
		
		try {
			bufferedImage = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JButton chessSquare = new JButton(new ImageIcon(bufferedImage)); 
		
		chessSquare.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	            {
	           
	              if(ChessGame.getSelected() == null) {
	               ChessGame.selectPiece(board, piece);
	            }
	                else{
	           
	                	ChessGame.moveSelectPiece(board, i, j);
	                }
	               
	            }
        }); 
		chessSquare.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
					
			}	
			@Override
			public void keyReleased(KeyEvent e) 
			{
					
			}
			@Override
			public void keyPressed(KeyEvent e) {
					System.out.println("You pressed "+ e.getKeyChar());
				char keypressed = e.getKeyChar();
				
				switch(keypressed){
				case 'r':
					ChessGame.restart();
					break;
				
				case 'u':
					ChessGame.undo();
					break;
					
				case 'f':
					ChessGame.forfeit(board);
					break;
				}
			}
			});
		panel.add(chessSquare);	
	}
		
}
