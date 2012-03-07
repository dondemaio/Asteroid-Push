package org.skullforge.omegazone.arena;

import org.newdawn.slick.Graphics;

public interface Arena {
  public void render(Graphics g);
  public void update(int delta);  
  public void addObject(ArenaObject object);
}
