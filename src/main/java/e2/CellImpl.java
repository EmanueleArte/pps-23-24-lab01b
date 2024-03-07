package e2;

public class CellImpl implements Cell {

    private final boolean isMine;
    private boolean isFlagged = false;
    private boolean isRevealed = false;

    /**
     * @param isMine true to make the cell a mine, false otherwise
     */
    public CellImpl(boolean isMine) {
        this.isMine = isMine;
    }

    @Override
    public boolean isMine() {
        return this.isMine;
    }

    @Override
    public boolean isFlagged() {
        return this.isFlagged;
    }

    @Override
    public void switchFlag() {
        this.isFlagged = !this.isFlagged;
    }

    @Override
    public boolean isRevealed() {
        return this.isRevealed;
    }

    @Override
    public void reveal() {
        this.isRevealed = true;
    }
}
