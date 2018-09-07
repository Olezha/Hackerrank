package org.olezha;

import lombok.extern.slf4j.Slf4j;

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
                    previousNode.nextNode = node; // todo: if previous node already has next node
                previousNode = node;
            }
        }
        return occurrences.toArray();
    }
}

class Node {

    int x;
    Node nextNode;

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

        Node previousNode = map.putIfAbsent(node, node);
        if (previousNode != null) node = previousNode;

        return node;
    }

    int[] toArray() {
        return map.values().stream().mapToInt(node -> node.x).toArray();
    }
}

@Slf4j
class Main2 {

    public static void main(String[] args) {
        log.info("should 1 2 3 4: {}", FavoriteSequence.lessSequence(new int[][]{
                {1, 3},
                {2, 3, 4}}));
        log.info("should 1 2 3 4: {}", FavoriteSequence.lessSequence(new int[][]{
                {2, 3, 4},
                {1, 3}}));
        log.info("should 7 1 2 3 4: {}", FavoriteSequence.lessSequence(new int[][]{
                {2, 3, 4},
                {1, 3},
                {7, 1, 3}}));
    }
}
