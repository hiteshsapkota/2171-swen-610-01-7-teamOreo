package com.webcheckers.model.Board;

/**
 * The space class consists of an id, isValid for the piece to be put in and the {@link Piece}.
 */
public class Space {

  /**
   * Attributes
   */
  private int cellIdx;
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
  Space(int cellIdx, SPACECOLOR spaceColor, Piece piece) {
    this.cellIdx = cellIdx;
    this.piece = piece;
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
}