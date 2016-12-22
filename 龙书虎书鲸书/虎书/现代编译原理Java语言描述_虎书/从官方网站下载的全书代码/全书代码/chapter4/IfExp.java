package Absyn;
import Symbol.Symbol;
public class IfExp extends Exp {
   public Exp test;
   public Exp thenclause;
   public Exp elseclause; /* optional */
   public IfExp(int p, Exp x, Exp y) {pos=p; test=x; thenclause=y; elseclause=null;}
   public IfExp(int p, Exp x, Exp y, Exp z) {pos=p; test=x; thenclause=y; elseclause=z;}
}
