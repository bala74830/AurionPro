package com.company.tic_tac_toe.model;

public class ResultAnalyzer {

	private Board board;
	private ResultType resultType;
	
	public ResultAnalyzer(Board board)
	{
		this.board = board;
		resultType = ResultType.PROGRESS;
	}
	
	private boolean horizontalWinCheck()
	{
		Cell[] cells = board.getCells();
        return checkLine(cells[0], cells[1], cells[2]) ||
               checkLine(cells[3], cells[4], cells[5]) ||
               checkLine(cells[6], cells[7], cells[8]);
		
	}
	
	private boolean verticalWinCheck()
	{
		Cell[] cells = board.getCells();
        return checkLine(cells[0], cells[3], cells[6]) ||
               checkLine(cells[1], cells[4], cells[7]) ||
               checkLine(cells[2], cells[5], cells[8]);
	}
	
	private boolean diagonalWinCheck()
	{
		 Cell[] cells = board.getCells();
	        return checkLine(cells[0], cells[4], cells[8]) ||
	               checkLine(cells[2], cells[4], cells[6]);
	}
	
	
	
	public ResultType analyzeResult()
	{
		if (horizontalWinCheck() || verticalWinCheck() || diagonalWinCheck()) {
            return ResultType.WIN;
        } else if (board.isBoardFull()) {
            return ResultType.DRAW;
        } else {
            return ResultType.PROGRESS;
        }
	}
	
	  private boolean checkLine(Cell c1, Cell c2, Cell c3) {
	        return !c1.isEmpty() &&
	               c1.getMark() == c2.getMark() &&
	               c2.getMark() == c3.getMark();
	    }
	  
	  
}
