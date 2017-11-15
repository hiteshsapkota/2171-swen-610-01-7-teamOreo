package com.webcheckers.model.Board;

/**
 * The space class consists of an id, isValid for the piece to be put in and the {@link Piece}.
 */
public class Space {

  /**
   * Attributes
   */
  private final int cellIdx;
  private Piece piece;

  public int getCellIdx() {
    return cellIdx;
  }

  public enum SPACECOLOR{
    BLACK,
    WHITE
  }
  private final SPACECOLOR spaceColor;

  /**
   * Constructor
   * @param cellIdx positon of the space
   */
  Space(int cellIdx, SPACECOLOR spaceColor) {
    this.cellIdx = cellIdx;
    this.piece = null;
    this.spaceColor = spaceColor;
  }

  /**
   * Returns color of corresponding space
   * @return SPACECOLOR
   */
  SPACECOLOR getSpaceColor() {
    return spaceColor;
  }

  /**
   * Returns piece
   * @return piece
   */
  public Piece getPiece() {
    return piece;
  }

  /**
   *  Sets piece
   * @param piece the piece to be set.
   */
  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public boolean isValid(){
    return spaceColor == SPACECOLOR.BLACK && getPiece() == null;
  }
}