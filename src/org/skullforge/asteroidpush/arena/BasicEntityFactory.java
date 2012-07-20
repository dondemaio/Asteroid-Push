package org.skullforge.asteroidpush.arena;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.skullforge.asteroidpush.arena.entities.Scenery;
import org.skullforge.asteroidpush.arena.entities.Vessel;

public class BasicEntityFactory implements EntityFactory {

   @Override
   public Entity createVessel() throws SlickException {
      return new Vessel(new Image("shuttle.png"));
   }

   @Override
   public Entity createScenery() throws SlickException {
      return new Scenery();
   }

}
