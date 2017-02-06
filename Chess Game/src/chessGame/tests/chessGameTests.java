package chessGame.tests;

import chessGame.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class chessGameTests{
	
	@Test
	public void boardInitTest(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
	}
	
	
	@Test
	public void testInvalidMove1(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Rook = testing.getPosition(0,0);
		assertTrue(testing.movePiece(Rook, 0, 1) == -1);
	}
	
	
	@Test 
	public void testInvalidMove2(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Bishop = testing.getPosition(2, 7);
		assertTrue(testing.movePiece(Bishop, 2, 6) == -1);
	}
	
	
	@Test
	public void testInvalidMove3(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Queen = testing.getPosition(3, 7);
		assertTrue(testing.movePiece(Queen, 2, 7) == -1);
	}
	

	@Test
	public void testPawn()
	{
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Pawn = testing.getPosition(0, 1);
		assertTrue(testing.movePiece(Pawn,0, 3) == 0);
	}
		
	@Test
	public void testInvalidMove4(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Pawn = testing.getPosition(0, 1);
		assertTrue(testing.movePiece(Pawn, 1, 2) == -1);
	}

	@Test
	public void testKnight(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Knight = testing.getPosition(1, 0);
		assertTrue(testing.movePiece(Knight, 2, 2) == 0);
	
	}

	@Test
	public void testInvalidMove5(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Knight = testing.getPosition(1, 0);
		assertTrue(testing.movePiece(Knight, 1, 3) == -1);
	}
	@Test
	public void testOutofBound(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Bishop = testing.getPosition(2,0);
		assertTrue(testing.movePiece(Bishop,8,0) == -1);
	}
	
	@Test
	public void gameOver(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces King = testing.getPosition(4, 0);
		assertTrue(testing.movePiece(King, -1, -1) == -1);
	}
	
	@Test
	public void testBishop(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Bishop = testing.getPosition(2, 7);
		Pieces Pawn = testing.getPosition(1, 6);
		testing.movePiece(Pawn, 1, 5);
		assertTrue(testing.movePiece(Bishop, 1, 6) == 0);
	}
	
	@Test
	public void testRook(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Rook = testing.getPosition(0,0);
		assertTrue(testing.movePiece(Rook, 0, 2) == 0);

	}
	
	@Test
	public void testQueen(){
		Chessboard testing  = new Chessboard();
		testing.initBoard();
		Pieces Queen = testing.getPosition(3, 7);
		Pieces Pawn = testing.getPosition(3, 6);
		testing.movePiece(Pawn, 3, 4);
		assertTrue(testing.movePiece(Queen, 4, 6) == 0);
		
	}
	
	@Test
	public void testMoveIntoOwn(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces Rook = testing.getPosition(0, 1);
		assertTrue(testing.movePiece(Rook, 0, 0)==-1);
	}
	
	@Test
	public void testPawnCaptureMove(){
		Chessboard testing = new Chessboard();
		testing.initBoard();
		Pieces W_pawn = testing.getPosition(3,  1);
		Pieces B_pawn = testing.getPosition(3, 6);
		testing.movePiece(W_pawn, 0, 2);
		testing.movePiece(B_pawn, 1, 3);
		assertTrue(testing.movePiece(W_pawn,1,3) == 0);
		assertTrue(B_pawn.getx() == -1);
		
	}
	
}	





