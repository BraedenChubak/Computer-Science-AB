package Q3;

import DataStructures.UnionFind;

public class UnionFindLab { // Island Connectivity finder
    private final UnionFind unionFind;

    public UnionFindLab(int n) {
        unionFind = new UnionFind(n); // n Islands
    }

    public void addBridge(int isle1, int isle2) {
        unionFind.union(isle1, isle2);
    }

    public boolean areConnected(int isle1, int isle2) {
        return unionFind.connected(isle1, isle2);
    }

    public int numberOfIslandGroups() {
        return unionFind.count();
    }

    public static void main(String[] args) {
        // Test Case 1
        var icf = new UnionFindLab(5);
        System.out.println(icf.numberOfIslandGroups()); // expected: 5

        // Test Case 2
        icf.addBridge(0, 1);
        System.out.println(icf.areConnected(0, 1)); // expected: true
        System.out.println(icf.numberOfIslandGroups()); // expected: 4

        // Test Case 3
        icf.addBridge(2, 3);
        icf.addBridge(1, 2);
        System.out.println(icf.areConnected(0, 3)); // expected: true
        System.out.println(icf.numberOfIslandGroups()); // expected: 2

        // Test Case 4
        icf.addBridge(0, 3); // already connected
        System.out.println(icf.numberOfIslandGroups()); // expected: 2
    }
}
/*
5
true
4
true
2
2
 */