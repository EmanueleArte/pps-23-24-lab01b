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
    public void testPiecePositioningInEmptyChessboard() {
        assertNotNull(this.chessboard.randomEmptyPosition());
    }

    @Test
    public void testAddPiece() {
        this.chessboard.addPiece(new Knight());
        assertEquals(1, this.chessboard.getPieces().size());
    }

}
