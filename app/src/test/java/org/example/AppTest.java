package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test
  void testBoard() {
    Board board = new Board();
    assertEquals(1, board.checkWin());
    board.setGridSquare(0, -1);
    board.setGridSquare(1, -1);
    board.setGridSquare(2, -1);
    assertEquals(-1, board.checkWin());
  }
}
