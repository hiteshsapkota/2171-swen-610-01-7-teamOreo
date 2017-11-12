package com.webcheckers.model;

/**
 * This class stores the movement and its start and end positions
 */
class Movement {
    //
    // Attributes
    //
    private int startRow;
    private int startCell;
    private int endRow;
    private int endCell;

    /**
     * Constructor, takes the values and sets it up accordingly
     * @param startRow row of the start position
     * @param startCell cellIdX of the start position
     * @param endRow row of the end position
     * @param endCell cellIdX of the end position
     */
    Movement(int startRow, int startCell, int endRow, int endCell) {
        this.startRow = startRow;
        this.startCell = startCell;
        this.endRow = endRow;
        this.endCell = endCell;
    }

    /**
     * getStartRow gets the start row.
     * @return start row
     */
    int getStartRow() {
        return startRow;
    }

    /**
     * getStartCell gets the start cell.
     * @return getStartCell integer
     */
    int getStartCell() {
        return startCell;
    }

    /**
     * gets the end row
     * @return end of the row
     */
    int getEndRow() {
        return endRow;
    }

    /**
     * gets the end cell
     * @return end of the cell
     */
    int getEndCell() {
        return endCell;
    }

}

