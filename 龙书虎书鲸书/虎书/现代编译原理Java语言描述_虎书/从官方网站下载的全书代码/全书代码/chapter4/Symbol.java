package Symbol;
public class Symbol {
  private String name;
  private Symbol(String n) {
    name=n;
  }
  private static java.util.Dictionary dict = new java.util.Hashtable();

  public String toString() {
	return name;
  }

  /** 
   * Make return the unique symbol associated with a string.
   * Repeated calls to <tt>symbol("abc")</tt> will return the same Symbol.
   */

  public static Symbol symbol(String n) {
	String u = n.intern();
	Symbol s = (Symbol)dict.get(u);
	if (s==null) {
		s = new Symbol(u);
		dict.put(u,s);
	}
	return s;
  }
}

