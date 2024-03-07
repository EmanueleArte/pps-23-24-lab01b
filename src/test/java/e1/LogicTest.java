package e1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private static final int SIZE = 5;
    private Logics logics;

    @BeforeEach
    void beforeEach() {
        this.logics = new LogicsImpl(SIZE);
    }

    @Test
    public void testPawnPositioning() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.logics.hasPawn(i, j)) {
                    assertTrue(this.logics.hasPawn(i, j));
                }
            }
        }
    }

    @Test
    public void testKnightPositioning() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.logics.hasKnight(i, j)) {
                    assertTrue(this.logics.hasKnight(i, j));
                }
            }
        }
    }

    @Test
    public void testOverlappedPositioning() {
        this.logics = new LogicsImpl(SIZE);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.logics.hasPawn(i, j)) {
                    int finalI = i;
                    int finalJ = j;
                    assertAll(
                            () -> assertTrue(this.logics.hasPawn(finalI, finalJ)),
                            () -> assertFalse(this.logics.hasKnight(finalI, finalJ))
                    );
                }
            }
        }
    }

    @Test
    public void testKnightImpossibleMove() {
        this.logics = new LogicsImpl(SIZE, new Pair<>(1, 1), new Pair<>(2, 1));
        assertFalse(this.logics.hit(1, 1));
    }

    @Test
    public void testKnightMiss() {
        this.logics = new LogicsImpl(SIZE, new Pair<>(1, 1), new Pair<>(2, 1));
        assertFalse(this.logics.hit(0, 0));
    }

    @Test
    public void testKnightHit() {
        this.logics = new LogicsImpl(SIZE, new Pair<>(0, 0), new Pair<>(2, 1));
        assertTrue(this.logics.hit(0, 0));
    }

}
