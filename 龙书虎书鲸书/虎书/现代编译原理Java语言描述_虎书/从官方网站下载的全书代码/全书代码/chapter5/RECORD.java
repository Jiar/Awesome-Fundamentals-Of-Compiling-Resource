package Types;

public class RECORD extends Type {
   public Symbol.Symbol fieldName;
   public Type fieldType;
   public RECORD tail;
   public RECORD(Symbol.Symbol n, Type t, RECORD x) {
       fieldName=n; fieldType=t; tail=x;
   }
   public boolean coerceTo(Type t) {
	return this==t.actual();
   }
}
   

