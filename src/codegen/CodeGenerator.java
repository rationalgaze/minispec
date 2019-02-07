package codegen;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import modele.Model;

public class CodeGenerator extends Visitor {
  private String res;
  MustacheFactory mf = new DefaultMustacheFactory();
  Mustache m = mf.compile("resources/codetemplate.mustache");
  
  public String generate() {
    return res;
  }
  
  @Override
  public void visit(Model model) {
    StringWriter writer = new StringWriter();
    try {
      m.execute(writer, model).flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
    res = writer.toString();
  }
}
