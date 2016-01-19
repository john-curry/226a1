import java.util.*;
class TestAss1 {
   public static void main ( String[] args ) {
      int M = StdIn.readInt();
      int a[] = new int[M];
      int b[];
      for (int i=0; i<M; ++i) a[i] = StdIn.readInt();
      boolean testZO =false;
      if (testZO) {
        long start = System.nanoTime();
        ZOrep zo1 = new ZOrep( M, a );
        System.out.println("Array to tree: " + ((double)((System.nanoTime() - start)) / 100000.0) + " milliseconds.\n");

        start = System.nanoTime();
        ZOrep zo2 = new ZOrep( zo1.N, zo1.t );
        System.out.println("Array to tree: " + ((double)((System.nanoTime() - start)) / 100000.0) + " milliseconds.\n");

        b = zo2.a;
      } else {
        long start = System.nanoTime();
        FLrep fl1 = new FLrep( M, a );
        System.out.println("Array to tree: " + ((double)((System.nanoTime() - start)) / 100000.0) + " milliseconds.\n");

        start = System.nanoTime();
        FLrep fl2 = new FLrep( fl1.N, fl1.t );
        System.out.println("Tree to array: " + ((double)((System.nanoTime() - start)) / 100000.0) + " milliseconds.\n");

        b = fl2.a;
      }
      // the arrays should be the same.
      for (int i=0; i<M; ++i) System.out.print( a[i] );  System.out.println();
      for (int i=0; i<M; ++i) System.out.print( b[i] );  System.out.println();
   }
}
