package com.company.tic_tac_toe.model;

import java.util.Arrays;

public class Board {

	private Cell[] cell = new Cell[9];
	
	public Board() 
	{
		for(int i = 0; i < 9; i++)
		{
			cell[i] = new Cell(); // initialize each Cell object 
			
		}
	}
	
	@Override
	public String toString() {
		return "Board [cell=" + Arrays.toString(cell) + "]";
	}

	public boolean isBoardFull()
	{
		for(int i=0;i<cell.length;i++)
		{
			if(cell[i].getMark().equals(Mark.E))
			{
				return false;
			}
		}
		return true;
	}
	
	public void setCellMark(int loc,Mark mark)throws CellAlreadyMarkedException
	{
		if(cell[loc].getMark() == Mark.E)
		{
			cell[loc].setMark(mark);
		}
		
	}
	
	public Cell[] getCells() {
        return cell;
    }

	
	
}
