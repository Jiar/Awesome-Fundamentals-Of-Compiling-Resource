package Tree;
import Temp.Temp;
import Temp.Label;
public class ESEQ extends Exp {
  public Stm stm;
  public Exp exp;
  public ESEQ(Stm s, Exp e) {stm=s; exp=e;}
  public ExpList kids() {throw new Error("kids() not applicable to ESEQ");}
  public Exp build(ExpList kids) {throw new Error("build() not applicable to ESEQ");}
}

