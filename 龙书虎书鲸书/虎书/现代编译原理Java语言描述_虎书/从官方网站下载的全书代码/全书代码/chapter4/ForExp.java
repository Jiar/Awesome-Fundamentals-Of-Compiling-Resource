package Absyn;
import Symbol.Symbol;
public class ForExp extends Exp {
   public VarDec var;
   public Exp hi, body;
   public ForExp(int p, VarDec v, Exp h, Exp b) {pos=p; var=v; hi=h; body=b;}
}
