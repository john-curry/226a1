class FLrep extends TreeAndRepresentation {
  // VARIABLES, IF ANY NEEDED
  int height = 0;
  int k = 0;
  FLrep( int N, BT t ) { // given tree build sequence
    super( N, t );
    M = 2 * N + 1;
    a = new int[M];
    // process left child
    // process node
    // process right child    
    traverse(t);

  }

  void traverse(BT t) {
    if (t == null) { return; }
    height++;
    traverse(t.L);
    height--;
    a[k] = height;
    height++;
    traverse(t.R);
  }

  FLrep( int m, int[] b ) { // given sequence build tree
    super( m, b );
    N = (M - 1) / 2;
    
  }

  BT build() {

    if (a[k + 1] > a[k]) {
      return new BT(null, build());
    }
    else return null; // REMOVE THIS 
  }
}
