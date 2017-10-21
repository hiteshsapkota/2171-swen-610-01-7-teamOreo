package com.webcheckers.model;

import java.util.ArrayList;

/**
 * The OnlinePlayers class has the information about the player which
 * contains the player name and a boolean if it is free.
 * It also contains a list of all the online players.
 */
public class OnlinePlayers {

  // List of all online players.
  public static ArrayList<OnlinePlayers> onlineList = new ArrayList<>();

  private String name;
  private boolean isFree;

  public OnlinePlayers(String name) {
    this.name = name;
    this.isFree = true;
  }

  public OnlinePlayers(String name, boolean isFree) {
    this.name = name;
    this.isFree = isFree;

  }

  /**
   * Accessor for name of the player
   * @return name of the player
   */
  public String getName() {
    return name;
  }


  /**
   *
   * @return true if the player is free to play a game
   */
  public boolean isFree() {
    return isFree;
  }

  /**
   *
   * @param free change the player from engaged to free.
   */
  public void setFree(boolean free) {
    isFree = free;
  }

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
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  @Override
  public String toString() {
    return this.getName();
  }
}
