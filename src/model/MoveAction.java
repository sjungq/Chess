package model;

public class MoveAction extends Action
{
	private Square square1;
	private Square square2;
	
	public MoveAction(Square s1, Square s2)
	{
		this.square1 = s1;
		this.square2 = s2;
		this.actionType = ActionType.MOVEMENT;
	}
	
	@Override
	public void execute(Board board) 
	{
		// TODO Auto-generated method stub
		
		if(square1.isEmpty())
		{
			System.err.println("No piece to move on " + square1);
		}
		else
		{
			Piece movedPiece = square1.getPiece();
			if(movedPiece.getPossibleMoves(square1, board).contains(square2))
			{
				//if the square is occupied
				if(!square2.isEmpty())
				{
					System.err.println(square2 + " is already occupied.");
				}
				else
				{
					square2.setPiece(movedPiece);
					//clear
					square1.clearPiece();
					System.out.println("Moved " + movedPiece.getName() + " from " + square1 + " to " + square2);
				}
				
			}
			else
			{
				System.err.println("Not a valid move for " + movedPiece.getName());
			}
		}
		
	}

}