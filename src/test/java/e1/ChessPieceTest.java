package e1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ChessPieceTest {

    private static final Pair<Integer, Integer> PAIR = new Pair<>(0, 0);
    private ChessPiece piece;

    @BeforeEach
    void beforeEach() {
        this.piece = new ChessPieceImpl(PAIR.getX(), PAIR.getY());
    }

    @Test
    public void testPawnPositioning() {
        assertAll(
                () -> assertEquals(this.piece.getX(), PAIR.getX()),
                () -> assertEquals(this.piece.getY(), PAIR.getY())
        );

    }

}

