import java.util.Arrays;
class FLrep extends TreeAndRepresentation {
  // VARIABLES, IF ANY NEEDED
  int height = 0;
  int k = 0;
  boolean DEBUG = true;
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
    a[k++] = height;
    height--;
    traverse(t.R);
  }

  FLrep( int m, int[] b ) { // given sequence build tree
    super( m, b );
    N = (M - 1) / 2;
    
    debug("Input array " + Arrays.toString(b) + " with size " + b.length);
    if (a[k] == 0) t = new BT(null, null);
    else {
      while (a[++k] != 0) { }

      debug("Found root " + a[k] + " at index " + k);

      t = build(k, 0, N); 
    }
  }

  BT build(int index_of_node, int lb, int ub) {
     // the first occurance from the left of the next level up is the left child
     // the first occurance of the same level to the right is the right index
     int lci = -1, rci = -1; // left&right child index
     BT rc = null, lc = null;
     if (lb == index_of_node) {
       lc = null; 
     } 
     else {
       int i = lb;
       while (i++ != index_of_node) {
         if (a[i] == a[index_of_node] + 1) {
            lci = i;
            break;
         }
       }
     }
     if (rci == index_of_node) {
       rc = null;
     }
     else {
       int j = index_of_node;
       while(j++ != ub) {
         if (a[j] == a[index_of_node]) {
           rci = j;
           break;
         }
       }
     }
     if (lci != -1) {
       lc = build(lci, lb, index_of_node - 1);
     }
     if (rci != -1) {
       rc = build(rci, index_of_node + 1, ub);
     }
     return new BT(lc, rc);
  }

  void debug(String out) {
    if (DEBUG) System.out.println(out);
  }
}
