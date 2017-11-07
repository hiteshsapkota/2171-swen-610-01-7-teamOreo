package com.webcheckers.model.Board;

/**
 * Piece class consists of the type of the piece {SINGLE, KING} and color {RED, WHITE}
 */
public class Piece {

  /**
   * attributes
   */
  public typeEnum type;
  public colorEnum color;
//constructor
  public Piece(typeEnum type, colorEnum color) {
    this.type = type;
    this.color = color;
  }

  /**
   * Public methods
   */
  /** Returns type of the piece(King or Single)
   *
   * @return typeEnum
   */
  public typeEnum getType() {
    return type;
  }

  /**
   * Sets piece typr(King or Single)
   * @param type
   */
  public void setType(typeEnum type) {
    this.type = type;
  }

  /**
   *  Returns color of the piece
   * @return colorEnum
   */
  public colorEnum getColor() {
    return color;
  }

  /**
   * Sets color of the piece
   * @param color
   */
  public void setColor(colorEnum color) {
    this.color = color;
  }

  /**
   * declaration of enum for piece type
   */
  public enum typeEnum {
    SINGLE,
    KING

  }

  /**
   * declaration of enum for piece color
   */
  public enum colorEnum {
    RED,
    WHITE
  }
}
