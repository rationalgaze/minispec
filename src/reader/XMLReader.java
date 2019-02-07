package reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modele.Attribut;
import modele.Entity;
import modele.Model;

public class XMLReader {
  
  private Model model;
  
  public Model readXml() {
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    
    try {
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document= builder.parse(new File("resources/minispec.xml"));
      
      document.getDocumentElement().normalize();      
      
      model = new Model("my model");
      
      //Affichage de l'élément racine
      System.out.println("\n" + document.getDocumentElement().getNodeName());
      
      NodeList entity = document.getElementsByTagName("entity");
      
      for (int i = 0; i<entity.getLength(); i++) {
        Node nNode = entity.item(i);
        if(nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element el = (Element) nNode;
          
          Element name = (Element) el.getElementsByTagName("name").item(0);
          Entity e = new Entity(name.getTextContent());
          
          System.out.println("Name : " + name.getTextContent());
          
          NodeList attr = el.getElementsByTagName("attribute");
          for (int j=0; j<attr.getLength();j++) {
            Node arg = attr.item(j);
            System.out.println("Attr : " + arg.getNodeName());
            
            if(arg.getNodeType() == Node.ELEMENT_NODE) {
              Element attrEl = (Element) arg;
              
              Element att_name = (Element) attrEl.getElementsByTagName("name").item(0);
              Element att_type = (Element) attrEl.getElementsByTagName("type").item(0);
              
              e.addAttr(new Attribut(att_name.getTextContent(), att_type.getTextContent()));
              System.out.println("  Attr Name : " + att_name.getTextContent());
              System.out.println("  Attr Type : " + att_type.getTextContent());
            }
          }
          model.addEntity(e);
        }
      }
      
    } catch (final ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (final IOException e) {
        e.printStackTrace();
    }
    
    return model;
  }
}
