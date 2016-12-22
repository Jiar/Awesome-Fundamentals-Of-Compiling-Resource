package Main;
import Semant.Semant;
import Translate.Translate;
import Parse.Parse;

class Main {

 static Frame.Frame frame = new <MyTargetMachine>.Frame();

 static void prStmList(Tree.Print print, Tree.StmList stms) {
     for(Tree.StmList l = stms; l!=null; l=l.tail)
	print.prStm(l.head);
 }

 static Assem.InstrList codegen(Frame.Frame f, Tree.StmList stms) {
  	Assem.InstrList first=null, last=null;
	    for(Tree.StmList s=stms; s!=null; s=s.tail) {
	       Assem.InstrList i = f.codegen(s.head);
	       if (last==null) {first=last=i;}
	       else {while (last.tail!=null) last=last.tail;
		     last=last.tail=i;
		    }
	    }
	    return first;
	}
		

 static void emitProc(java.io.PrintStream out, Translate.ProcFrag f) {
     java.io.PrintStream debug = 
          /* new java.io.PrintStream(new NullOutputStream()); */
          out;
     Temp.TempMap tempmap= new Temp.CombineMap(f.frame,new Temp.DefaultMap());
     Tree.Print print = new Tree.Print(debug, tempmap);
     debug.println("# Before canonicalization: ");
     print.prStm(f.body);
     debug.print("# After canonicalization: ");
     Tree.StmList stms = Canon.Canon.linearize(f.body);
     prStmList(print,stms);
     debug.println("# Basic Blocks: ");
     Canon.BasicBlocks b = new Canon.BasicBlocks(stms);
     for(Canon.StmListList l = b.blocks; l!=null; l=l.tail) {
       debug.println("#");
       prStmList(print,l.head);
     }       
     print.prStm(new Tree.LABEL(b.done));
     debug.println("# Trace Scheduled: ");
     Tree.StmList traced = (new Canon.TraceSchedule(b)).stms;
     prStmList(print,traced);
     Assem.InstrList instrs= codegen(f.frame,traced);
     debug.println("# Instructions: ");
     for(Assem.InstrList p=instrs; p!=null; p=p.tail)
	debug.print(p.head.format(tempmap));
 }

 public static void main(String args[]) throws java.io.IOException {
   Parse.Parse parse = new Parse.Parse(args[0]);
   java.io.PrintStream out = 
        new java.io.PrintStream(new java.io.FileOutputStream(args[0] + ".s"));
   Translate.Translate translate = new Translate.Translate(frame);
   Semant semant = new Semant(translate,parse.errorMsg);
   Translate.Frag frags = semant.transProg(parse.absyn);
   for(Translate.Frag f = frags; f!=null; f=f.next)
       if (f instanceof Translate.ProcFrag)
          emitProc(out, (Translate.ProcFrag)f);
       else if (f instanceof Translate.DataFrag)
          out.print(((Translate.DataFrag)f).data);
   out.close();
 }

}

class NullOutputStream extends java.io.OutputStream {
    public void write(int b) {}
}


