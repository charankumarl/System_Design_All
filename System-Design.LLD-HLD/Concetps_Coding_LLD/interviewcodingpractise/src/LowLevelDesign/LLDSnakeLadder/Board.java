package LowLevelDesign.LLDSnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;   // for 10 * 10 board, cells[10][10]. generate 100 cells objects

    Board(int boardSize, int numberOfSnakes, int numberOfLadders) {

        initializeCells(boardSize);
        addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize) {

        cells = new Cell[boardSize][boardSize];    // cell[10][10]

        for(int i=0;i<boardSize;i++) {

            for(int j=0; j<boardSize;j++) {

                Cell cellObj = new Cell();
                cellObj.row =i;
                cellObj.col = j;

                cells[i][j] = cellObj;  // attach cell object to cell array.  each CELL obj is attached to cell array.
            }
        }
    }

    private void addSnakesLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders){

        while(numberOfSnakes > 0) {   // attach snakes to cells

           int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);  // generate random number.
           int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);

           if(snakeTail >= snakeHead) {   // if not valid snake, skip.
               continue;
           }

           Jump snakeObj = new Jump();

           snakeObj.start = snakeHead;   // attach snake head and tail to snake object.
           snakeObj.end = snakeTail;

           Cell cell = getCell(snakeHead);
           cell.jump = snakeObj;    // attach snake object JUMP to cell.

            numberOfSnakes--;
        }

        while(numberOfLadders > 0) {  // same do for ladders.

            int ladderStart = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(ladderStart >= ladderEnd) {
                continue;
            }

            Jump ladderObj = new Jump();

            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;

            Cell cell = getCell(ladderStart);
            cell.jump = ladderObj;

            numberOfLadders--;
        }

    }

    public Cell getCell(int playerPosition) {

        int boardRow = playerPosition / cells.length;    // get row and col number.   row = pos / len
        int boardColumn = (playerPosition % cells.length);  // col = pos % len

        return cells[boardRow][boardColumn];   // return that cell object.
    }

    public void display() {

        for(int i=0;i<cells.length;i++) {
            for(int j=0;j<cells.length;j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }
}
