package e1;

public class Knight extends ChessPieceAbstr {
    @Override
    public boolean move(int row, int column, int size) {

        if (row < 0 || column < 0 || row >= size || column >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Below a compact way to express allowed moves for the knight
        int x = row - this.getRow();
        int y = column - this.getColumn();
        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
            this.setRow(row);
            this.setColumn(column);
            return true;
        }
        return false;
    }
}
