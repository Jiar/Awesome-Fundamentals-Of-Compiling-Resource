package Tree;
import Temp.Temp;
import Temp.Label;
public class JUMP extends Stm {
  public Exp exp;
  public Temp.LabelList targets;
  public JUMP(Exp e, Temp.LabelList t) {exp=e; targets=t;}
  public JUMP(Temp.Label target) {
      this(new NAME(target), new Temp.LabelList(target,null));
  }
  public ExpList kids() {return new ExpList(exp,null);}
  public Stm build(ExpList kids) {
    return new JUMP(kids.head,targets);
  }
}

