package com.company.tic_tac_toe.model;

public class Cell {
	//attributes
	private Mark marktype;

	//constructor
	public Cell() {
		this.marktype = Mark.E;
	}
	

	// getters and setters
	public Mark getMark()
	{
		return marktype;
	}
	
	@Override
	public String toString() {
		return "Cell [marktype=" + marktype + "]";
	}


	public void setMark(Mark markType) throws CellAlreadyMarkedException
	{
		if(this.marktype != Mark.E)
		{
			throw new CellAlreadyMarkedException("Cell is already marked.");
		}
		this.marktype = markType;
	}

	public boolean isEmpty()
	{
		return marktype == Mark.E;
	}
	
}
