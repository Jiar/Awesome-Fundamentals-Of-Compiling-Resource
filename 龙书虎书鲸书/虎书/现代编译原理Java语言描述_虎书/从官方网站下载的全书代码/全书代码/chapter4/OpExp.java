package Absyn;
import Symbol.Symbol;
public class OpExp extends Exp {
   public Exp left, right;
   public int oper;
   public OpExp(int p, Exp l, int o, Exp r) {pos=p; left=l; oper=o; right=r;}
   public final static int PLUS=0, MINUS=1, MUL=2, DIV=3,
		    EQ=4, NE=5, LT=6, LE=7, GT=8, GE=9;
}
