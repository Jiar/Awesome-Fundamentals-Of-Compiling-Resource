package RegAlloc;

public class MoveList {
   public Graph.Node src, dst;
   public MoveList tail;
   public MoveList(Graph.Node s, Graph.Node d, MoveList t) {
	src=s; dst=d; tail=t;
   }
}

