package FlowGraph;
import Temp.TempList;
import Temp.Temp;
import Graph.NodeList;
import Graph.Node;

/**
 * A control flow graph is a directed graph in which each edge
 * indicates a possible flow of control.  Also, each node in
 * the graph defines a set of temporaries; each node uses a set of
 * temporaries; and each node is, or is not, a <strong>move</strong>
 * instruction.
 *
 * @see AssemFlowGraph
 */

public abstract class FlowGraph extends Graph.Graph {
 /**
  * The set of temporaries defined by this instruction or block 
  */
	public abstract TempList def(Node node);

 /**
  * The set of temporaries used by this instruction or block 
  */
	public abstract TempList use(Node node);

 /**
  * True if this node represents a <strong>move</strong> instruction,
  * i.e. one that can be deleted if def=use. 
  */
	public abstract boolean isMove(Node node);

 /**
  * Print a human-readable dump for debugging.
  */
     public void show(java.io.PrintStream out) {
	for (NodeList p=nodes(); p!=null; p=p.tail) {
	  Node n = p.head;
	  out.print(n.toString());
	  out.print(": ");
	  for(TempList q=def(n); q!=null; q=q.tail) {
	     out.print(q.head.toString());
	     out.print(" ");
	  }
	  out.print(isMove(n) ? "<= " : "<- ");
	  for(TempList q=use(n); q!=null; q=q.tail) {
	     out.print(q.head.toString());
	     out.print(" ");
	  }
	  out.print("; goto ");
	  for(NodeList q=n.succ(); q!=null; q=q.tail) {
	     out.print(q.head.toString());
	     out.print(" ");
	  }
	  out.println();
	}
     }

}
    
    