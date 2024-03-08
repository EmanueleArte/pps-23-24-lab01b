package e2;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.util.*;
import java.util.List;
import java.util.Map.Entry;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {

    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton, Pair<Integer, Integer>> buttons = new HashMap<>();
    private final Logics logics;

    public GUI(int size, int mines) {
        this.logics = new LogicsImpl(size, mines);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100 * size, 100 * size);

        JPanel panel = new JPanel(new GridLayout(size, size));
        this.getContentPane().add(BorderLayout.CENTER, panel);

        ActionListener onClick = (e) -> {
            final JButton bt = (JButton) e.getSource();
            final Pair<Integer, Integer> pos = buttons.get(bt);
            boolean aMineWasFound = this.logics.isLost(pos); // call the logic here to tell it that cell at 'pos' has been seleced
            if (aMineWasFound) {
                quitGame();
                this.removeAllListeners();
                JOptionPane.showMessageDialog(this, "You lost!!");
            } else {
                drawBoard();
            }
            this.checkVictory();
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton) e.getSource();
                if (bt.isEnabled()) {
                    final Pair<Integer, Integer> pos = buttons.get(bt);
                    // call the logic here to put/remove a flag
                    logics.switchCellFlag(pos);
                }
                drawBoard();
                checkVictory();
            }
        };

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb, new Pair<>(i, j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }

    public GUI(int size) {
        this(size, size);
    }

    private void quitGame() {
        this.logics.revealAll();
        this.clearFlags();
        this.drawBoard();
        final var board = this.logics.getCellsToShow();
        for (var entry : this.buttons.entrySet()) {
            // call the logic here
            // if this button is a mine, draw it "*"
            // disable the button
            final JButton bt = entry.getKey();
            final Pair<Integer, Integer> pos = entry.getValue();
            final int cellValue = board.get(pos);
            if (cellValue == GridImpl.MINE_FOUND) {
                bt.setText("*");
                bt.setEnabled(false);
            } else if (cellValue == GridImpl.FLAGGED) {
                bt.setText(String.valueOf(cellValue));
                bt.setEnabled(false);
            }
        }
    }

    private void drawBoard() {
        final var board = this.logics.getCellsToShow();
        this.clearFlags();
        if (board.isEmpty()) {
            return;
        }
        for (var entry : board.entrySet()) {
            var pos = entry.getKey();
            var cellValue = entry.getValue();
            final JButton bt = getButtonFromPosition(pos);
            if (cellValue == GridImpl.FLAGGED) {
                bt.setText("F");
            } else {
                bt.setText(String.valueOf(cellValue));
                bt.setEnabled(false);
            }
        }
    }

    private JButton getButtonFromPosition(Pair<Integer, Integer> pos) {
        return this.buttons.entrySet().stream()
                .filter(e -> e.getValue().equals(pos))
                .map(Entry::getKey)
                .findFirst()
                .orElseThrow();
    }

    private void clearFlags() {
        for (var bt : this.buttons.keySet()) {
            if (bt.getText().equals("F")) {
                bt.setText("");
            }
        }
    }

    private void removeAllListeners() {
        for (var bt : this.buttons.keySet()) {
            for (var l : bt.getActionListeners()) {
                bt.removeActionListener(l);
            }
            for (var l : bt.getMouseListeners()) {
                bt.removeMouseListener(l);
            }
        }
    }

    private void checkVictory() {
        boolean isThereVictory = this.logics.isWin(); // call the logic here to ask if there is victory
        if (isThereVictory) {
            quitGame();
            JOptionPane.showMessageDialog(this, "You won!!");
            System.exit(0);
        }
    }

}