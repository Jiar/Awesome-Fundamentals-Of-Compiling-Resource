package RegAlloc;
import Graph.Node;
import Graph.Graph;

abstract public class InterferenceGraph extends Graph {
   abstract public Node tnode(Temp.Temp temp);
   abstract public Temp.Temp gtemp(Node node);
   abstract public MoveList moves();
   public int spillCost(Node node) {return 1;}
}
