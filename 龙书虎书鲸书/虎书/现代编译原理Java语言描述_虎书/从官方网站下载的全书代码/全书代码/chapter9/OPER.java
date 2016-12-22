package Assem;

public class OPER extends Instr {
   public Temp.TempList dst;   
   public Temp.TempList src;
   public Targets jump;

   public OPER(String a, Temp.TempList d, Temp.TempList s, Temp.LabelList j) {
      assem=a; dst=d; src=s; jump=new Targets(j);
   }
   public OPER(String a, Temp.TempList d, Temp.TempList s) {
      assem=a; dst=d; src=s; jump=null;
   }

   public Temp.TempList use() {return src;}
   public Temp.TempList def() {return dst;}
   public Targets jumps() {return jump;}

}
