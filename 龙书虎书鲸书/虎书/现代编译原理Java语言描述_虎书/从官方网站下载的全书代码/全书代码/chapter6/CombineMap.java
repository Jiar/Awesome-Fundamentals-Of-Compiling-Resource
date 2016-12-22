package Temp;

public class CombineMap implements TempMap {
	TempMap tmap1, tmap2;
	public String tempMap(Temp.Temp t) {
	   String s = tmap1.tempMap(t);
	   if (s!=null) return s;
	   return tmap2.tempMap(t);
	}

	public CombineMap(TempMap t1, TempMap t2) {
	   tmap1=t1; tmap2=t2;
	}
}
