package e1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ChessboardTest {

    private static final int SIZE = 2;
    private Chessboard chessboard;

    @BeforeEach
    void beforeEach() {
        this.chessboard = new ChessboardImpl(SIZE);
    }

    @Test
    public void testPieceRandomPositioningInEmptyChessboard() {
        assertNotNull(this.chessboard.randomEmptyPosition());
    }

    @Test
    public void testAddPiece() {
        this.chessboard.addPiece(new Knight());
        assertEquals(1, this.chessboard.getPieces().size());
    }

    @Test
    public void testAddPieceToFullChessboard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.chessboard.addPiece(new Knight(i, j));
            }
        }
        assertThrows(IllegalStateException.class, () -> this.chessboard.addPiece(new Knight()));
    }

    @Test
    public void testAddPieceToOccupiedPosition() {
        this.chessboard.addPiece(new Knight(0, 0));
        assertThrows(IllegalStateException.class, () -> this.chessboard.addPiece(new Knight(0, 0)));
    }

    @Test
    public void testRemovePiece() {
        this.chessboard.addPiece(new Knight());
        this.chessboard.removePiece(0, 0);
        assertAll(
                () -> assertEquals(0, this.chessboard.getPieces().size()),
                () -> assertThrows(IllegalArgumentException.class, () -> this.chessboard.removePiece(0, 0))
        );
    }

    @Test
    public void testPieceRandomPositioningInNotEmptyChessboard() {
        for (int i = 0; i < SIZE; i++) {
            Pair<Integer, Integer> position = this.chessboard.randomEmptyPosition();
            this.chessboard.addPiece(new Knight(position.getX(), position.getY()));
        }
        assertEquals(SIZE, this.chessboard.getPieces().size());
    }

    @Test
    public void testHit() {
        this.chessboard = new ChessboardImpl(4);
        ChessPiece knight1 = new Knight(0, 0);
        ChessPiece knight2 = new Knight(1, 2);
        this.chessboard.addPiece(knight1);
        this.chessboard.addPiece(knight2);
        assertTrue(this.chessboard.hit(knight1, knight2.getRow(), knight2.getColumn()));
    }

    @Test
    public void testHitEmptyPosition() {
        this.chessboard = new ChessboardImpl(4);
        ChessPiece knight1 = new Knight(0, 0);
        this.chessboard.addPiece(knight1);
        assertFalse(this.chessboard.hit(knight1, 1, 2));
    }

    @Test
    public void testHitImpossibleMove() {
        this.chessboard = new ChessboardImpl(4);
        ChessPiece knight1 = new Knight(0, 0);
        ChessPiece knight2 = new Knight(1, 1);
        this.chessboard.addPiece(knight1);
        this.chessboard.addPiece(knight2);
        assertFalse(this.chessboard.hit(knight1, knight2.getRow(), knight2.getColumn()));
    }

}
