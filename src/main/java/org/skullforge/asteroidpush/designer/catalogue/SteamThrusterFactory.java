//    Asteroid Push - A game featuring selfmade spaceships and pompous physics
//    Copyright (C) 2013  Christian Meyer, Silvan Wegmann
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

package org.skullforge.asteroidpush.designer.catalogue;

import org.jbox2d.common.Vec2;
import org.skullforge.asteroidpush.designer.data.ComponentData;
import org.skullforge.asteroidpush.designer.data.Material;
import org.skullforge.asteroidpush.designer.data.ModuleData;
import org.skullforge.asteroidpush.designer.data.PrimitiveData;
import org.skullforge.asteroidpush.designer.data.effectors.ForceFeederData;
import org.skullforge.asteroidpush.designer.grid.GridVector;

public class SteamThrusterFactory {

   static public ModuleData createData() {
      ModuleData data = new ModuleData("Steam Jet Engine");

      ComponentData component = new ComponentData();
      data.addComponent(component);

      PrimitiveData nozzle = new PrimitiveData();
      nozzle.setMaterial(Material.METAL);
      Vec2 shape[] = {
            new Vec2(0.0f, -0.25f),
            new Vec2(0.25f, -0.25f),
            new Vec2(0.5f, -0.125f),
            new Vec2(0.5f, 0.125f),
            new Vec2(0.25f, 0.25f),
            new Vec2(0.0f, 0.25f)
      };
      nozzle.setVertices(shape);
      component.addPrimitive(nozzle);

      ForceFeederData thruster = new ForceFeederData();
      thruster.setAnchor(new Vec2(0.0f, 0.0f), 0.0f);
      thruster.setMagnitude(50000.0f);
      component.addEffector(thruster);

      component.addWeldDirection(GridVector.FORWARD);

      return data;
   }

}
