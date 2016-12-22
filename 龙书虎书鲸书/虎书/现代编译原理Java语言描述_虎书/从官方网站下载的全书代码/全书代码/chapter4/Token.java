package Parse;

class Token extends java_cup.runtime.token {
  int left,right;
  Token(int l, int r, int kind) {
   super(kind);
   left=l; right=r;
  }
}

class StrToken extends Token {
  String val;
  StrToken(int l, int r, int kind, String v) { 
    super(l,r,kind);
    val=v;
  }
}

class IntToken extends Token {
  int val;
  IntToken(int l, int r, int kind, int v) { 
    super(l,r,kind);
    val=v;
  }
}
