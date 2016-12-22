package Absyn;
import Symbol.Symbol;
public class VarExp extends Exp {
   public Var var;
   public VarExp(int p, Var v) {pos=p; var=v;}
}   
