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
     * Sets the start row
     * @param startRow integer of the position of row
     */
    void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    /**
     * getStartCell gets the start cell.
     * @return getStartCell integer
     */
    int getStartCell() {
        return startCell;
    }

    /**
     * sets the start cell.
     * @param startCell integer of the start cell
     */
    void setStartCell(int startCell) {
        this.startCell = startCell;
    }

    /**
     * gets the end row
     * @return end of the row
     */
    int getEndRow() {
        return endRow;
    }

    /**
     * sets the end row
     * @param endRow end row integer
     */
    void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    /**
     * gets the end cell
     * @return end of the cell
     */
    int getEndCell() {
        return endCell;
    }

    /**
     * sets the end cell
     * @param endCell new position of the end cell.
     */
    void setEndCell(int endCell) {
        this.endCell = endCell;
    }
}

