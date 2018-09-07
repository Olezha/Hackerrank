package org.olezha;

import java.util.*;
import java.util.stream.*;

public class FavoriteSequence {

    /**
     * https://www.hackerrank.com/challenges/favourite-sequence
     * http://chasethered.com/2014/11/my-problem-for-hackerrank-weekly-challenge-12-favorite-sequence/
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        int n = scan.nextInt();
        int[][] nM = new int[n][];

        for (int i = 0; i < n; i++) {
            int k = scan.nextInt();
            int[] m = new int[k];
            for (int j = 0; j < k; j++) {
                m[j] = scan.nextInt();
            }
            nM[i] = m;
        }

        int[] lessSequence = lessSequence(nM);
        if (lessSequence == null) throw new RuntimeException();

        System.out.println(
                IntStream.of(lessSequence)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(" ")));
    }

    static int[] lessSequence(int[][] nCopiesOfBrokenSequenceM) {
        NodesSet occurrences = new NodesSet();
        for (int[] brokenM : nCopiesOfBrokenSequenceM) {
            Node previousNode = null;
            for (int x : brokenM) {
                Node node = occurrences.getOrPut(x);
                if (previousNode != null)
                    previousNode.nextNodes.add(node);
                previousNode = node;
            }
        }
        return occurrences.toOrderedSequenceArray();
    }
}

class Node {

    int x;
    Set<Node> nextNodes = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Node a = (Node) obj;

        return a.x == x;
    }

    @Override
    public int hashCode() {
        return x;
    }
}

class NodesSet {

    private Map<Node, Node> map = new HashMap<>();

    Node getOrPut(int i) {
        Node node = new Node() {{
            x = i;
        }};

        Node existingNode = map.putIfAbsent(node, node);
        if (existingNode != null) node = existingNode;

        return node;
    }

    int[] toOrderedSequenceArray() {
        return orderedSequence().stream().mapToInt(node -> node.x).toArray();
    }

    private List<Node> orderedSequence() {
        Set<Node> lasts = lasts();
        List<List<Node>> individualSequences = new ArrayList<>(lasts.size());
        int maxIndividualSequenceSize = 0;
        for (Node node : lasts) {
            List<Node> orderedSequence = new ArrayList<>();
            addNodeToOrderedSequence(node, orderedSequence);
            Collections.reverse(orderedSequence);
            individualSequences.add(orderedSequence);
            int orderedSequenceSize = orderedSequence.size();
            if (orderedSequenceSize > maxIndividualSequenceSize)
                maxIndividualSequenceSize = orderedSequenceSize;
        }

        List<Node> orderedSequence = new ArrayList<>(map.size());
        while (individualSequences.size() > 0) {
            Node nextNode = null;
            for (List<Node> individualSequence : individualSequences) {
                if (nextNode == null)
                    nextNode = individualSequence.get(0);
                else if (lexicographicallyCompare(nextNode, individualSequence.get(0)) < 0)
                    nextNode = individualSequence.get(0);
            }
            for (List<Node> individualSequence : individualSequences) {
                if (individualSequence.remove(nextNode)) {
                    if (individualSequence.size() == 0)
                        individualSequences.remove(individualSequence);
                    break;
                }
            }
            orderedSequence.add(nextNode);
        }

        return orderedSequence;
    }

    private void addNodeToOrderedSequence(Node node, List<Node> orderedSequence) {
        orderedSequence.add(node);
        for (Node previousNode : lexicographicallySort(previous(node)))
            addNodeToOrderedSequence(previousNode, orderedSequence);
    }

    private Set<Node> previous(Node node) {
        return map.values().stream()
                .filter(nod3 -> {
                    if (!nod3.nextNodes.contains(node))
                        return false;
                    nod3.nextNodes.remove(node);
                    return nod3.nextNodes.isEmpty();
                })
                .collect(Collectors.toSet());
    }

    private Set<Node> lasts() {
        return map.values().stream().filter(node -> node.nextNodes.isEmpty()).collect(Collectors.toSet());
    }

    private List<Node> lexicographicallySort(Set<Node> nodes) {
        return nodes.stream()
                .sorted(this::lexicographicallyCompare)
                .collect(Collectors.toList());
    }

    private int lexicographicallyCompare(Node node1, Node node2) {
        return Integer.toString(node2.x).compareTo(Integer.toString(node1.x));
    }
}
