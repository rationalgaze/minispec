package modele;

import java.util.ArrayList;
import java.util.List;

public class Model implements Element {
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
