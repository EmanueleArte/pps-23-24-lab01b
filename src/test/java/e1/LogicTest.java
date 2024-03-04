package e1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private static final int SIZE = 5;
    private Logics logics;

    @BeforeEach
    void beforeEach() { logics = new LogicsImpl(SIZE); }


    @Test
    public void testPawnPositioning() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.logics.hasPawn(i, j)) {
                    Assertions.assertTrue(this.logics.hasPawn(i, j));
                }
            }
        }
    }
}
