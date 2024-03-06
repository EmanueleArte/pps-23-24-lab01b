package e1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ChessboardTest {

    private static final int SIZE = 2;
    private Chessboard chessboard;

    @BeforeEach
    void beforeEach() {
        this.chessboard = new ChessboardAbstr(SIZE);
    }

    @Test
    public void testPiecePositioningInEmptyChessboard() {
        System.out.println(this.chessboard.randomEmptyPosition());
        assertNotNull(this.chessboard.randomEmptyPosition());
    }

}
