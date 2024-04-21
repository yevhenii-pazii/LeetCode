package structure;

public class WeightedQuickUnion {

    /*
        Store Parents for node
        for the node i, parent node would be parents[i]
        if i == parents[i] -> i has no parent it is root
     */
    private final int[] parents;

    /*
        Tree size for nodes
        for the node i, size[i] stores size of tree 
     */
    private final int[] size;
    
    /**
     * Time Complexity O(N) -> loop over to initialize
     * 
     * @param n count of node 
     */
    public WeightedQuickUnion(int n) {
        parents = new int[n];
        size = new int[n];
        for (var i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Time Complexity O(Log N)
     *
     * @param i node
     * @return tree root for node <code>i</code>
     */
    public int find(int i) {
        while (parents[i] != i) {
            parents[i] = parents[parents[i]]; //this line flattens tree during traversing
            i = parents[i];
        }
        return i;
    }

    /**
     * Time Complexity O(Log N)
     *
     * @param p first node
     * @param q second node
     * @return <code>true</code> if connected
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Time Complexity O(Log N)
     *
     * @param p first node
     * @param q second node
     * @return <code>true</code> if nodes <code>u</code> and <code>v</code> united,
     * <code>false</code> means already connected
     */
    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return false;
        }

        /*
            Connect smaller tree to bigger one's root node
         */
        if (size[rootP] < size[rootQ]) {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

        return true;
    }
}
