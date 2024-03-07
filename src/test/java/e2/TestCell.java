package e2;

import e1.ChessPieceAbstr;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCell {

    private Cell cell;

    @BeforeEach
    void beforeEach() {
        this.cell = new CellImpl(true);
    }

    @Test
    void testIsMine() {
        assertTrue(this.cell.isMine());
    }

}
