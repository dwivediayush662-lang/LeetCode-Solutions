class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }
        int[] newParent = Arrays.copyOf(parent, n);

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        // Step 2: Find the closest matching ancestor for every node
        findNewParents(0, adj, s, lastSeen, newParent);

        // Step 3: Build the final tree using newParent
        List<List<Integer>> finalTree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            finalTree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            finalTree.get(newParent[i]).add(i);
        }

        // Step 4: Count subtree sizes in the final tree
        int[] answer = new int[n];
        countSubtreeSize(0, finalTree, answer);

        return answer;
    }

    private void findNewParents(int u, List<List<Integer>> adj, String s, int[] lastSeen, int[] newParent) {
        int charIndex = s.charAt(u) - 'a';
        int previousAncestor = lastSeen[charIndex];

        // If an ancestor with the same character exists, update parent
        if (previousAncestor != -1) {
            newParent[u] = previousAncestor;
        }

        // Set current node as the most recent ancestor for this character
        lastSeen[charIndex] = u;

        // Visit all children
        for (int child : adj.get(u)) {
            findNewParents(child, adj, s, lastSeen, newParent);
        }

        // Backtrack: restore the previous ancestor before leaving this branch
        lastSeen[charIndex] = previousAncestor;
    }

    private int countSubtreeSize(int u, List<List<Integer>> finalTree, int[] answer) {
        int size = 1; // Count the node itself
        for (int child : finalTree.get(u)) {
            size += countSubtreeSize(child, finalTree, answer);
        }
        answer[u] = size;
        return size;
    }
}
