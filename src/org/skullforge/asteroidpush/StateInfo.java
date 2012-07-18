package org.skullforge.asteroidpush;

public enum StateInfo {
  ARENA(1);

  private int stateID;

  StateInfo(int number) {
    stateID = number;
  }

  public int getID() {
    return stateID;
  }
}