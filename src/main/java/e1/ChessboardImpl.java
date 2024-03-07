package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Basic implementation of {@link Chessboard}.
 */
public class ChessboardImpl implements Chessboard {

    private final int size;
    private final List<ChessPiece> pieces;
    private final Random random = new Random();

    public ChessboardImpl(int size) {
        this.size = size;
        this.pieces = new ArrayList<>();
    }

    @Override
    public Pair<Integer, Integer> randomEmptyPosition() {
        if (this.pieces.size() == this.size * this.size) {
            throw new IllegalStateException("Chessboard is full");
        }
        Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
        boolean emptyPosition = true;
        for (ChessPiece piece : pieces) {
            if (piece.getPosition().equals(pos)) {
                emptyPosition = false;
                break;
            }
        }
        // the recursive call below prevents clash with an existing pawn
        return emptyPosition ? pos : randomEmptyPosition();
    }

    @Override
    public List<ChessPiece> getPieces() {
        return this.pieces;
    }

    @Override
    public void addPiece(ChessPiece piece) throws IllegalStateException {
        if (this.pieces.size() == this.size * this.size) {
            throw new IllegalStateException("Chessboard is full");
        }
        if (this.pieces.stream().anyMatch(p -> p.getPosition().equals(piece.getPosition()))) {
            throw new IllegalStateException("Position is already occupied");
        }
        this.pieces.add(piece);
    }

    @Override
    public ChessPiece removePiece(int row, int column) throws IllegalArgumentException {
        ChessPiece p = this.pieces.stream()
                .filter(piece -> piece.getRow() == row && piece.getColumn() == column)
                .findAny()
                .orElse(null);
        if (this.pieces.removeIf(piece -> piece.getRow() == row && piece.getColumn() == column)) {
            return p;
        } else {
            throw new IllegalArgumentException("Piece not found");
        }
    }

    @Override
    public boolean hit(ChessPiece piece, int row, int column) {
        if (piece.getRow() != row && piece.getColumn() != column) {
            boolean isHit = isHit(row, column);
            if (piece.move(row, column, this.size)) {
                return isHit;
            }
        }
        return false;
    }

    private boolean isHit(int row, int column) {
        return this.pieces.stream()
                .anyMatch(p -> p.getRow() == row && p.getColumn() == column);
    }

}
