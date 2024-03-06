package e1;

import java.util.ArrayList;
import java.util.List;
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
            return null;
        }
        Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
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
    public void addPiece(ChessPiece piece) {
        this.pieces.add(piece);
    }

}
