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
  public enum SPACECOLOR{
    BLACK,
    WHITE
  }
  private SPACECOLOR spaceColor;

  /**
   * Constructor
   * @param cellIdx positon of the space
   * @param piece can be null
   */
  public Space(int cellIdx, SPACECOLOR spaceColor, Piece piece) {
    this.cellIdx = cellIdx;
    this.piece = piece;
    this.spaceColor = spaceColor;
  }

  public SPACECOLOR getSpaceColor() {
    return spaceColor;
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
    return this.spaceColor == SPACECOLOR.BLACK && this.piece == null;
  }

  public Piece getPiece() {
    return piece;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }
}