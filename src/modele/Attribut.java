package modele;

/**
 * @author Nikolai Vorotnikov
 * La classe qui sert pour representer les attributs 
 * d'un classe java génére à partir du langage Minispec. 
 *  
 */
public class Attribut implements Element {

  private String name;
  private String type;
  
  public Attribut(String name, String type) {
    this.name = name;
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }  
}
