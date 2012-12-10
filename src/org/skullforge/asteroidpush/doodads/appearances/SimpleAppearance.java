package org.skullforge.asteroidpush.doodads.appearances;

import java.util.ArrayList;
import java.util.Collection;

import org.jbox2d.dynamics.Body;
import org.newdawn.slick.geom.Shape;
import org.skullforge.asteroidpush.doodads.assemblies.Assembly;
import org.skullforge.asteroidpush.utils.GeometryConverter;

public class SimpleAppearance implements Appearance {

   public SimpleAppearance(Assembly part) {
      this.part = part;
   }

   @Override
   public ArrayList<Shape> getOutline() {
      Collection<Body> bodies = part.getBodies();
      ArrayList<Shape> outline = new ArrayList<Shape>();

      for (Body body : bodies) {
         outline.addAll(GeometryConverter.extractOutline(body));
      }

      return outline;
   }

   private Assembly part;
}