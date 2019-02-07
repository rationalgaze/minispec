package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import codegen.CodeGenerator;
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
    
    assertTrue(m.getEntity(0).getName().equals("Satellite"));
    assertTrue(m.getEntity(0).getAttrNumber() == 2);
    assertTrue(m.getEntity(0).getAttr(0).getName().equals("nom"));
    assertTrue(m.getEntity(0).getAttr(0).getType().equals("String"));
    assertTrue(m.getEntity(0).getAttr(1).getName().equals("id"));
    assertTrue(m.getEntity(0).getAttr(1).getType().equals("Integer"));
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
  
  @Test
  public void testCodeGen() {
    Model m = new XMLReader().readXml();
    CodeGenerator codegen = new CodeGenerator();
    m.accept(codegen);
    System.out.println(codegen.generate());
    assertTrue(codegen.generate().equals("Model Nom: my model\n\n" + 
        "class Satellite {\n" + 
        "    String nom;\n" + 
        "    Integer id;\n" + 
        "}\n"));
  }

}
