package Assem;

public class LABEL extends Instr {
   public Temp.Label label;

   public LABEL(String a, Temp.Label l) {
      assem=a; label=l;
   }

   public Temp.TempList use() {return null;}
   public Temp.TempList def() {return null;}
   public Targets jumps()     {return null;}

}
