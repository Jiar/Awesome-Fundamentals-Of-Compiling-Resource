package Canon;

public class TraceSchedule {

  public Tree.StmList stms;
  BasicBlocks theBlocks;
  java.util.Dictionary table = new java.util.Hashtable();

  Tree.StmList getLast(Tree.StmList block) {
     Tree.StmList l=block;
     while (l.tail.tail!=null)  l=l.tail;
     return l;
  }

  void trace(Tree.StmList l) {
   for(;;) {
     Tree.LABEL lab = (Tree.LABEL)l.head;
     table.remove(lab.label);
     Tree.StmList last = getLast(l);
     Tree.Stm s = last.tail.head;
     if (s instanceof Tree.JUMP) {
	Tree.JUMP j = (Tree.JUMP)s;
        Tree.StmList target = (Tree.StmList)table.get(j.targets.head);
	if (j.targets.tail==null && target!=null) {
               last.tail=target;
	       l=target;
        }
	else {
	  last.tail.tail=getNext();
	  return;
        }
     }
     else if (s instanceof Tree.CJUMP) {
	Tree.CJUMP j = (Tree.CJUMP)s;
        Tree.StmList t = (Tree.StmList)table.get(j.iftrue);
        Tree.StmList f = (Tree.StmList)table.get(j.iffalse);
        if (f!=null) {
	  last.tail.tail=f; 
	  l=f;
	}
        else if (t!=null) {
	  last.tail.head=new Tree.CJUMP(Tree.CJUMP.notRel(j.relop),
					j.left,j.right,
					j.iffalse,j.iftrue);
	  last.tail.tail=t;
	  l=t;
        }
        else {
	  Temp.Label ff = new Temp.Label();
	  last.tail.head=new Tree.CJUMP(j.relop,j.left,j.right,
					j.iftrue,ff);
	  last.tail.tail=new Tree.StmList(new Tree.LABEL(ff),
		           new Tree.StmList(new Tree.JUMP(j.iffalse),
					    getNext()));
	  return;
        }
     }
     else throw new Error("Bad basic block in TraceSchedule");
    }
  }

  Tree.StmList getNext() {
      if (theBlocks.blocks==null) 
	return new Tree.StmList(new Tree.LABEL(theBlocks.done), null);
      else {
	 Tree.StmList s = theBlocks.blocks.head;
	 Tree.LABEL lab = (Tree.LABEL)s.head;
	 if (table.get(lab.label) != null) {
          trace(s);
	  return s;
         }
         else {
	   theBlocks.blocks = theBlocks.blocks.tail;
           return getNext();
         }
      }
  }

  public TraceSchedule(BasicBlocks b) {
    theBlocks=b;
    for(StmListList l = b.blocks; l!=null; l=l.tail)
       table.put(((Tree.LABEL)l.head.head).label, l.head);
    stms=getNext();
    table=null;
  }        
}


