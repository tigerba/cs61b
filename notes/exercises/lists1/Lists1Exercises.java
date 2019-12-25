public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        IntList Q = new IntList(0, null);
        int i = L.size() - 1;
        
        while (i > 0) {
            Q.first = L.get(i) + x;
            Q = new IntList(L.get(i - 1) + x, Q);
            i -= 1;
        }
        return Q;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList Q = L;
        
        while (Q != null) {
            Q.first += x;
            Q = Q.rest;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        // System.out.println(L.size());
        // System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(2));
        // System.out.println(incrList(L, 3).size());
        // System.out.println(dincrList(L, 3).size());
        System.out.println(incrList(L, 3).get(0));
        System.out.println(incrList(L, 3).get(1));
        System.out.println(incrList(L, 3).get(2));
        
        System.out.println(L.get(0));
        System.out.println(L.get(1));
        System.out.println(L.get(2));
        
        IntList Q = dincrList(L, 3);
        System.out.println(Q.get(0));
        System.out.println(Q.get(1));
        System.out.println(Q.get(2));
        
        System.out.println(L.get(0));
        System.out.println(L.get(1));
        System.out.println(L.get(2));
    }
}
