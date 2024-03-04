package e1;

import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class ChessPieceTest {

    private static final Pair<Integer, Integer> PAIR = new Pair<>(0, 0);
    private static final BiFunction<Pair<Integer, Integer>, Integer, Boolean> KNIGHT_MOVEMENT = (position, size) ->
    {
        int row = position.getX();
        int col = position.getY();

        return null;
    };

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

    @Test
    public void testKnightMovement() {
        Pair<Integer, Integer> pair = new Pair<>(1, 2);
        this.piece.setMovement();
        this.piece.move();
        assertAll(
                () -> assertEquals(this.piece.getX(), pair.getX()),
                () -> assertEquals(this.piece.getY(), pair.getY())
        );
    }

}

