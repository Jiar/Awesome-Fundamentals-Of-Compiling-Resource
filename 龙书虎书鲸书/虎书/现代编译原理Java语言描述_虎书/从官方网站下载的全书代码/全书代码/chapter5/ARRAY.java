package Types;

public class ARRAY extends Type {
   public Type element;
   public ARRAY(Type e) {element = e;}
   public boolean coerceTo(Type t) {
	return this==t.actual();
   }
}

