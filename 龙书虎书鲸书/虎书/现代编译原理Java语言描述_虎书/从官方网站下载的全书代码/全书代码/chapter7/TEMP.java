package Tree;

public class TEMP extends Exp {
  public Temp.Temp temp;
  public TEMP(Temp.Temp t) {temp=t;}
  public ExpList kids() {return null;}
  public Exp build(ExpList kids) {return this;}
}

