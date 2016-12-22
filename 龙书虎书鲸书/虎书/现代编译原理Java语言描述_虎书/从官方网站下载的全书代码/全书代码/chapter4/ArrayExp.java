package Absyn;
import Symbol.Symbol;
public class ArrayExp extends Exp {
   public Symbol typ;
   public Exp size, init;
   public ArrayExp(int p, Symbol t, Exp s, Exp i) {pos=p; typ=t; size=s; init=i;}
}
