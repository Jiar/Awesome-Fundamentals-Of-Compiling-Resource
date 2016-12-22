package Absyn;
import Symbol.Symbol;
public class SeqExp extends Exp {
   public ExpList list;
   public SeqExp(int p, ExpList l) {pos=p; list=l;}
}
