package chess.pieces;

import bordgame.Board;
import bordgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		if (getColor() == Color.WHITE) {
			
			//above
			p.setValues(position.getRow()-1, position.getColumn());
			if (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow()-2, position.getColumn());
			Position p2 = new Position(position.getRow()-1, p.getColumn());
			if (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)&&getMoveCount()==0&&getBoard().positionExists(p2)&&!getBoard().thereIsAPiece(p2)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//NW
			p.setValues(position.getRow()-1, position.getColumn()-1);
			if (getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//NE
			p.setValues(position.getRow()-1, position.getColumn()+1);
			if (getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		else {
			
			//bellow
			p.setValues(position.getRow()+1, position.getColumn());
			if (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow()+2, position.getColumn());
			Position p2 = new Position(position.getRow()+1, p.getColumn());
			if (getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)&&getMoveCount()==0&&getBoard().positionExists(p2)&&!getBoard().thereIsAPiece(p2)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//SW
			p.setValues(position.getRow()+1, position.getColumn()-1);
			if (getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//SE
			p.setValues(position.getRow()+1, position.getColumn()+1);
			if (getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}
	
}