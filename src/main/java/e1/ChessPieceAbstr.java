package e1;

/**
 * Implementation of {@link ChessPiece}.
 */
public abstract class ChessPieceAbstr implements ChessPiece {

    private Pair<Integer, Integer> position;

    public ChessPieceAbstr(int row, int col) {
        this.position = new Pair<>(row, col);
    }

    public ChessPieceAbstr() {
        this(0, 0);
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
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
    public abstract boolean move(int row, int column, int size);


}
