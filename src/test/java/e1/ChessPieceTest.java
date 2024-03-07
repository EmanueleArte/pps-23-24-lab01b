package e1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ChessPieceTest {

    private static final Pair<Integer, Integer> PAIR = new Pair<>(0, 0);
    private static final int SIZE = 5;
    private ChessPiece piece;

    @BeforeEach
    void beforeEach() {
        this.piece = new ChessPieceAbstr() {

            @Override
            public boolean move(int row, int column, int size) {
                return false;
            }
        };
    }

    @Test
    public void testPiecePositioning() {
        assertAll(
                () -> assertEquals(this.piece.getRow(), PAIR.getX()),
                () -> assertEquals(this.piece.getColumn(), PAIR.getY())
        );
    }

    @Test
    public void testPieceChangePositioning() {
        this.piece.setRow(1);
        this.piece.setColumn(1);
        assertAll(
                () -> assertNotEquals(this.piece.getRow(), PAIR.getX()),
                () -> assertNotEquals(this.piece.getColumn(), PAIR.getY())
        );
    }

    @Test
    public void testImpossibleKnightMovement() {
        this.piece = new Knight();
        assertFalse(this.piece.move(1, 1, SIZE));
    }

    @Test
    public void testPossibleKnightMovement() {
        this.piece = new Knight();
        assertTrue(this.piece.move(1, 2, SIZE));
    }

}

