package modele;

import java.util.ArrayList;
import java.util.List;

public class Entity implements Element {
  String name;
  List<Attribut> attr;
  
  public Entity(String name) {
    this.name = name;
    this.attr = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Attribut> getAllAttr() {
    return attr;
  }
  
  public Attribut getAttr(int i) {
    return attr.get(i);
  }

  public int getAttrNumber() {
    return this.attr.size();
  }
  
  public boolean addAttr(Attribut a) {
    int res = this.getAttrNumber();
    this.attr.add(a);
    return this.attr.size() > res;
  }
}
