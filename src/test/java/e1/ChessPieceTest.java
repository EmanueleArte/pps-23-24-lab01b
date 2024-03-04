package e1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ChessPieceTest {

    private static final Pair<Integer, Integer> PAIR = new Pair<>(0, 0);
    private ChessPiece piece;

    @BeforeEach
    void beforeEach() {
        this.piece = new ChessPieceImpl();
    }

    @Test
    public void testPiecePositioning() {
        assertAll(
                () -> assertEquals(this.piece.getX(), PAIR.getX()),
                () -> assertEquals(this.piece.getY(), PAIR.getY())
        );
    }

    @Test
    public void testPieceChangePositioning() {
        this.piece.setX(1);
        this.piece.setY(1);
        assertAll(
                () -> assertNotEquals(this.piece.getX(), PAIR.getX()),
                () -> assertNotEquals(this.piece.getY(), PAIR.getY())
        );
    }

}

