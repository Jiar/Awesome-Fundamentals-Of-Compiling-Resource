class prog {
static Stm prog = 
new CompoundStm(new AssignStm("a",new OpExp(new NumExp(5), OpExp.Plus, 
					    new NumExp(3))),
 new CompoundStm(new AssignStm("b",
     new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
                       new LastExpList(new OpExp(new IdExp("a"), OpExp.Minus,
				  	         new NumExp(1))))),
             new OpExp(new NumExp(10), OpExp.Times, new IdExp("a")))),
  new PrintStm(new LastExpList(new IdExp("b")))));
}
