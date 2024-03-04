package e1;

import org.junit.jupiter.api.*;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class ChessPieceTest {

    private static final Pair<Integer, Integer> PAIR = new Pair<>(0, 0);
    private ChessPiece piece;

    @BeforeEach
    void beforeEach() {
        this.piece = new ChessPieceAbstr() {

            @Override
            public boolean move(int row, int column) {
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
    public void testKnightMovement() {
        Pair<Integer, Integer> pair = new Pair<>(1, 2);
        this.piece.move(1, 1);
        assertAll(
                () -> assertEquals(this.piece.getRow(), pair.getX()),
                () -> assertEquals(this.piece.getColumn(), pair.getY())
        );
    }

}

