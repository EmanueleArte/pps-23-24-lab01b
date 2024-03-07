package e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestGrid {

    private static final int SIZE = 5;
    private static final int MINES = 5;
    private Grid grid;

    @BeforeEach
    void beforeEach() {
        this.grid = new GridImpl(SIZE, MINES);
    }

}
