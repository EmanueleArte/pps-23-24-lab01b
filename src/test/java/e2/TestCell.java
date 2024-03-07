package e2;

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

    @Test
    void testIsNotMine() {
        this.cell = new CellImpl(false);
        assertFalse(this.cell.isMine());
    }

    @Test
    void testIsFlagged() {
        assertFalse(this.cell.isFlagged());
    }

    @Test
    void testSwitchFlag() {
        this.cell.switchFlag();
        assertTrue(this.cell.isFlagged());
    }

    @Test
    void testMultipleSwitchFlag() {
        this.cell.switchFlag();
        this.cell.switchFlag();
        assertFalse(this.cell.isFlagged());
        this.cell.switchFlag();
        assertTrue(this.cell.isFlagged());
    }

    @Test
    void testIsRevealed() {
        assertFalse(this.cell.isRevealed());
    }

    @Test
    void testReveal() {
        this.cell.reveal();
        assertTrue(this.cell.isRevealed());
    }

}
