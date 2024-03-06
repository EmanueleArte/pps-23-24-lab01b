package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Basic implementation of {@link Chessboard}.
 */
public class ChessboardImpl implements Chessboard {

    private final int size;
    private final List<Pair<Integer, Integer>> piecesPositions;
    private final Random random = new Random();

    public ChessboardImpl(int size) {
        this.size = size;
        this.piecesPositions = new ArrayList<>();
    }

    @Override
    public Pair<Integer, Integer> randomEmptyPosition() {
        Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        boolean emptyPosition = true;
        for (Pair<Integer, Integer> position : piecesPositions) {
            if (position.equals(pos)) {
                emptyPosition = false;
                break;
            }
        }
        // the recursive call below prevents clash with an existing pawn
        return emptyPosition ? pos : randomEmptyPosition();
    }

}
