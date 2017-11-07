package com.webcheckers.model;

import java.util.ArrayList;

/**
 * The OnlinePlayers class has the information about the player which
 * contains the player name and a boolean if it is free.
 */
public class OnlinePlayers {

  //
  // Attributes
  //
  private String name;
  private boolean isFree;

  //
  // Constructors
  //

  /**
   * Constructor of creating a new player.
   * @param name the name of the player.
   */
  public OnlinePlayers(String name) {
    this.name = name;
    this.isFree = true;
  }

  /**
   * Accessor for name of the player
   * @return name of the player
   */
  public String getName() {
    return name;
  }

  /**
   *  Checks if the player is busy or free
   * @return true if the player is free to play a game
   */
  public boolean isFree()
  {
    return isFree;
  }

  /**
   * Sets the player to busy or free.
   * @param free change the player from engaged to free.
   */
  public void setFree(boolean free)
  {
    isFree = free;
  }

  // Equals and Hashcode
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OnlinePlayers that = (OnlinePlayers) o;

    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override
  public int hashCode()
  {
    return name != null ? name.hashCode() : 0;
  }

  @Override
  public String toString() {
    return this.getName();
  }
}
