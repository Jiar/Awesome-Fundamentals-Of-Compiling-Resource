package Tree;
import Temp.Temp;
import Temp.Label;
public class CJUMP extends Stm {
  public int relop;
  public Exp left, right;
  public Label iftrue, iffalse;
  public CJUMP(int rel, Exp l, Exp r, Label t, Label f) {
     relop=rel; left=l; right=r; iftrue=t; iffalse=f;
  }
  public final static int EQ=0, NE=1, LT=2, GT=3, LE=4, GE=5,
		   ULT=6, ULE=7, UGT=8, UGE=9;
  public ExpList kids() {return new ExpList(left, new ExpList(right,null));}
  public Stm build(ExpList kids) {
    return new CJUMP(relop,kids.head,kids.tail.head,iftrue,iffalse);
  }
  public static int notRel(int relop) {
    switch (relop) {
        case EQ:  return NE;
        case NE:  return EQ;
	case LT:  return GE;
	case GE:  return LT;
	case GT:  return LE;
	case LE:  return GT;
	case ULT: return UGE;
	case UGE: return ULT;
	case UGT: return ULE;
	case ULE: return UGT;
	default: throw new Error("bad relop in CJUMP.notRel");
    }
  }
}

