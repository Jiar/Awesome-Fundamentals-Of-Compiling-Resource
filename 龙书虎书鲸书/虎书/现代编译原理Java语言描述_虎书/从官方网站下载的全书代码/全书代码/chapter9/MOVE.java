package Assem;

public class MOVE extends Instr {
   public Temp.Temp dst;   
   public Temp.Temp src;

   public MOVE(String a, Temp.Temp d, Temp.Temp s) {
      assem=a; dst=d; src=s;
   }
   public Temp.TempList use() {return new Temp.TempList(src,null);}
   public Temp.TempList def() {return new Temp.TempList(dst,null);}
   public Targets jumps()     {return null;}

}
