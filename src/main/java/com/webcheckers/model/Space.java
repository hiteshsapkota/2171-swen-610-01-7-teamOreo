package com.webcheckers.model;

public class Space {
    public int cellIdx;
    public boolean isValid;
    public Piece piece;
    public Space(int cellIdx,boolean isValid,Piece piece)
    {
        this.cellIdx=cellIdx;
        this.isValid=isValid;
        this.piece=piece;
    }

    public int getCellIdx() {
        return cellIdx;
    }

    public void setCellIdx(int cellIdx) {
        this.cellIdx = cellIdx;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
