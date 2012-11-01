package org.skullforge.asteroidpush.doodads;

import org.jbox2d.common.Vec2;
import org.skullforge.asteroidpush.appearances.SimpleAppearance;
import org.skullforge.asteroidpush.designer.ShipDesign;
import org.skullforge.asteroidpush.logic.Logic;
import org.skullforge.asteroidpush.logic.Thruster;
import org.skullforge.asteroidpush.parts.Chassis;
import org.skullforge.asteroidpush.parts.SpaceshipHull;

public class SpaceshipFactory implements DoodadFactory {

   public SpaceshipFactory() {
      spawnPosition = new Vec2();
      design = null;
   }

   public void setParameters(Vec2 spawnPosition, ShipDesign design) {
      this.spawnPosition.set(spawnPosition);
      this.design = design;
   }

   @Override
   public Doodad createDoodad() {
      return initDoodad(new Doodad());
   }

   public Doodad initDoodad(Doodad doodad) {
      Chassis hull = new SpaceshipHull(spawnPosition, design);
      Logic thruster = new Thruster(hull);
      doodad.setChassis(hull);
      doodad.setLogic(thruster);
      doodad.setAppearance(new SimpleAppearance(hull));
      return doodad;
   }

   private Vec2 spawnPosition;
   private ShipDesign design;
}
