package e1;

import java.util.*;

public class LogicsImpl implements Logics {

    private final ChessPiece pawn;
    private final ChessPiece knight;
    private final Chessboard chessboard;

    public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
        this.chessboard = new ChessboardImpl(size);
        Pair<Integer, Integer> pawnPos = pawnPosition.getX() >= 0 ? pawnPosition : this.chessboard.randomEmptyPosition();
        this.pawn = new ChessPieceAbstr(pawnPos.getX(), pawnPos.getY()) {
            @Override
            public boolean move(int row, int column, int size) {
                return false;
            }
        };
        Pair<Integer, Integer> knightPos = pawnPosition.getX() >= 0 ? knightPosition : this.chessboard.randomEmptyPosition();
        this.knight = new Knight(knightPos.getX(), knightPos.getY());
        this.chessboard.addPiece(this.pawn);
        this.chessboard.addPiece(this.knight);
    }

    public LogicsImpl(int size) {
        this(size, new Pair<>(-1, -1), new Pair<>(-1, -1));
    }

    @Override
    public boolean hit(int row, int col) {
        if (this.chessboard.hit(this.knight, row, col)) {
            this.chessboard.removePiece(row, col);
            return true;
        }
        return false;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.getPosition().equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.getPosition().equals(new Pair<>(row, col));
    }
}