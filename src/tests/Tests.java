package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import modele.Attribut;
import modele.Entity;
import modele.Model;
import reader.XMLReader;

public class Tests {

  @Test
  public void testReadXml() {
    XMLReader reader = new XMLReader();
    Model m = reader.readXml();
    assertTrue(m.size() == 1);
  }
  
  @Test
  public void testModel() {
    Model m = new Model("My mod");
    assertTrue(m.size() == 0);
    
    assertTrue(m.addEntity(new Entity("e")));
    assertTrue(m.size() == 1);
  }
  
  @Test
  public void testEntity() {
    Entity e = new Entity("My ent");
    assertTrue(e.getAttrNumber() == 0);
    
    assertTrue(e.addAttr(new Attribut("x", "int")));
    assertTrue(e.getAttrNumber() == 1);
  }

}
