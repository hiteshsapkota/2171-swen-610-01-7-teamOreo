package com.webcheckers.model.Board;

/**
 * The space class consists of an id, isValid for the piece to be put in and the {@link Piece}.
 */
public class Space {

  /**
   * Attributes
   */
  private int cellIdx;
  private boolean isValid;
  private Piece piece;

  /**
   * Constructor
   * @param cellIdx positon of the space
   * @param isValid if the position is valid for the piece
   * @param piece can be null
   */
  public Space(int cellIdx, boolean isValid, Piece piece) {
    this.cellIdx = cellIdx;
    this.isValid = isValid;
    this.piece = piece;
  }

  /**
   * Public methods
   */

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
