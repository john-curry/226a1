import java.util.Arrays;
class FLrep extends TreeAndRepresentation {
  // VARIABLES, IF ANY NEEDED
  int height = 0;
  int k = 0;
  boolean DEBUG = false;
  int depth_of_binary_tree = -1;

  FLrep( int N, BT t ) { // given tree build sequence
    super( N, t );
    M = 2 * (N + 1);
    a = new int[M];
    // process left child
    // process node
    // process right child    
    debug("Converting binary tree on: " + N + " nodes.\n"
         +"to array of size: " + M + "\n");
    traverse(t);

  }

  void traverse(BT t) {
    if (t == null) { return; }
    height++;
    traverse(t.L);
    height--;
    a[k++] = height;
    traverse(t.R);
  }

  FLrep( int m, int[] b ) { // given sequence build tree
    super( m, b );
    N = (m - 1) / 2;
    
    debug("Array " + Arrays.toString(b) 
         +"\nSize " + m+"\n\n");

    if (a.length == 1) { t = new BT(null, null); }
    else {
      while (a[k++] != 0) { }

      debug("Found root " + a[k] + " at index " + k);

      t = build(k, 0, m - 1); 
    }
  }

  BT build(int index_of_node, int lb, int ub) {
     /* 

      * the first occurance from the left of the next level up 
         is the left child

      * the first occurance of the same level to the right 
        is the right index

      */ 
     int lci = -1, rci = -1; // left & right child index
     BT rc = null, lc = null;

     if (lb == index_of_node) {
       lc = null; 
     } 
     else {
       int i = lb;
       do {
         if (a[i] == a[index_of_node] + 1) {
            lci = i;
            break;
         }
       } while (++i != index_of_node);
     }

     if (ub == index_of_node) {
       rc = null;
     }
     else {
       int j = index_of_node;
       while(j++ <= ub) {
         if (a[j] == a[index_of_node]) {
           rci = j;
           break;
         }
       }
     }

     debug("Vertex " + index_of_node + "\n"
           +"at height " + a[index_of_node] + "\n"
           +(lci == -1 ? "No left child.\n" : "left child at: " + lci + "\n")
           +(rci == -1 ? "No right child.\n": "right child at: " + rci + "\n")
           +"Upper bound: " + ub + "\nLower Bound: " + lb + "\n" 
          );

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
