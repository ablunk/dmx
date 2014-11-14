package hub.sam.dmx.tests;

import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class TestInsert {
  public static void main(final String[] args) {
    final StringBuffer sb = new StringBuffer("e1 e2 e3");
    final int start = (0 + 2);
    sb.insert(start, "eX");
    String _string = sb.toString();
    InputOutput.<String>print(_string);
  }
}
