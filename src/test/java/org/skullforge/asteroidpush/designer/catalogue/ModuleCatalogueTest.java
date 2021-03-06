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

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Collection;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.junit.Before;
import org.junit.Test;
import org.skullforge.asteroidpush.designer.data.ComponentData;
import org.skullforge.asteroidpush.designer.data.ModuleData;
import org.skullforge.asteroidpush.designer.data.PrimitiveData;
import org.skullforge.asteroidpush.utils.GeometryVerifier;

public class ModuleCatalogueTest {

   ModuleCatalogue testCatalogue;

   @Before
   public void setUp() throws Exception {
      testCatalogue = new ModuleCatalogue();
   }

   @Test
   public void testPrimitives() {
      Transform testTransform = new Transform();
      testTransform.set(new Vec2(), 0.0f);
      float testSize = 5.0f;

      for (ModuleData module : testCatalogue.getModuleData()) {
         Collection<ComponentData> components = module.getComponents();
         for (ComponentData component : components) {
            for (PrimitiveData primitive : component.getPrimitives()) {
               PolygonShape poly = primitive.getShape(testTransform, testSize);
               assertThat(module.getName() + " geometry winding", GeometryVerifier.IsWoundCorrectly(poly), is(true));
            }
         }
      }
   }

}
