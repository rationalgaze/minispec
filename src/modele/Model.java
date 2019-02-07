package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikolai Vorotnikov
 * La classe qui réprésent métamodèle généré à partir d'un minispec.
 * Elle contient un nom et liste des éntités (classes)
 * de métamodèle. 
 * 
 */
public class Model {
  String name;
  List<Entity> entities;
  
  public Model(String n) {
    this.name = n;
    this.entities = new ArrayList<>();
  }
  
  public int size() {
    return this.entities.size();
  }
  
  public boolean addEntity(Entity e) {
    int size = entities.size();
    this.entities.add(e);
    return this.entities.size() > size;
  }
}
