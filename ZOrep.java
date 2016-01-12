class ZOrep extends TreeAndRepresentation {
  private int k;
  ZOrep( int m, int[] b ) { // given sequence build tree
     super( m, b );
     N = (M-1)/2;
     k  = -1;
     t = build();
  }
  ZOrep( int n, BT t ) { // given tree build sequence
      super( n, t );
      M = (2 * M) + 1;
      a = new int[M];
      k = -1;
      traverse( t );
      // preorder:
      //  process this node
      //  process left child 
      //    if left child is empty put 0
      //    else put 1
      //  process right child
      //    if right child is empty put 0
      //    else put 1
  }

  BT build() { return( a[++k] == 0 ? null : new BT( build(), build() )); }

  void traverse( BT t ) {
    if (t == null) { 
      a[k++] = 0; 
    } else {
      a[k++] = 1;
      traverse(t.L);
      traverse(t.R);
    }
  }
}
