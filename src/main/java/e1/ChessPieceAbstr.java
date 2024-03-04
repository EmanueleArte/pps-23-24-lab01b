package e1;

/**
 * Implementation of {@link ChessPiece}.
 */
public abstract class ChessPieceAbstr implements ChessPiece {

    private Pair<Integer, Integer> position;

    public ChessPieceAbstr(int x, int y) {
        this.position = new Pair<>(x, y);
    }

    public ChessPieceAbstr() {
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
    public void setRow(int row) {
        this.position = new Pair<>(row, this.getColumn());
    }

    @Override
    public void setColumn(int column) {
        this.position = new Pair<>(this.getRow(), column);
    }

    @Override
    public abstract boolean move(int row, int column);


}
