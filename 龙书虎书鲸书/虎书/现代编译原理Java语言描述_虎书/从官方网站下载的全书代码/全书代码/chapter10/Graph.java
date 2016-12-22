package Graph;

public class Graph {

  int nodecount=0;
  NodeList mynodes, mylast;
  public NodeList nodes() { return mynodes;} 

  public Node newNode() {
	return new Node(this);
  }

  void check(Node n) {
      if (n.mygraph != this)
	throw new Error("Graph.addEdge using nodes from the wrong graph");
  }

  static boolean inList(Node a, NodeList l) {
       for(NodeList p=l; p!=null; p=p.tail)
             if (p.head==a) return true;
       return false;
  }

  public void addEdge(Node from, Node to) {
      check(from); check(to);
      if (from.goesTo(to)) return;
      to.preds=new NodeList(from, to.preds);
      from.succs=new NodeList(to, from.succs);
  }

  NodeList delete(Node a, NodeList l) {
	if (l==null) throw new Error("Graph.rmEdge: edge nonexistent");
        else if (a==l.head) return l.tail;
	else return new NodeList(l.head, delete(a, l.tail));
  }

  public void rmEdge(Node from, Node to) {
	to.preds=delete(from,to.preds);
        from.succs=delete(to,from.succs);
  }

 /**
  * Print a human-readable dump for debugging.
  */
     public void show(java.io.PrintStream out) {
	for (NodeList p=nodes(); p!=null; p=p.tail) {
	  Node n = p.head;
	  out.print(n.toString());
	  out.print(": ");
	  for(NodeList q=n.succ(); q!=null; q=q.tail) {
	     out.print(q.head.toString());
	     out.print(" ");
	  }
	  out.println();
	}
     }

}