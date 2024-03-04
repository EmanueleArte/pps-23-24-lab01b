package e1;

/**
 * Implementation of {@link ChessPiece}.
 */
public class ChessPieceImpl implements ChessPiece {

    private Pair<Integer, Integer> position;

    public ChessPieceImpl(int x, int y) {
        this.position = new Pair<>(x, y);
    }

    public ChessPieceImpl() {
        this(0, 0);
    }

    @Override
    public int getRow() {
        return this.position.getX();
    }

    @Override
    public int getColumn() {
        return this.position.getY();
    }

    @Override
    public void setRow(int x) {
        this.position = new Pair<>(x, this.getY());
    }

    @Override
    public void setColumn(int y) {
        this.position = new Pair<>(this.getX(), y);
    }
}
