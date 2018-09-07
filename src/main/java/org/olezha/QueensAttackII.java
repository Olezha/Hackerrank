package org.olezha;

import java.util.HashSet;
import java.util.Set;

public class QueensAttackII {

    public static void main(String[] args) {
        System.out.println(queensAttack(4, 0, 4, 4, new int[][]{}) + " = 9");
        System.out.println(queensAttack(5, 3, 4, 3, new int[][]{{5, 5}, {4, 2}, {2, 3}}) + " = 10");
        System.out.println(queensAttack(1, 0, 1, 1, new int[][]{}) + " = 0");
    }

    private static int queensAttack(int nXNChessboard, int numberOfObstacles, int rowQueenPosition, int columnQueenPosition, int[][] obstacles) {
        Board board = new Board();
        board.boardSize = nXNChessboard;
        board.obstacles = new HashSet<>();
        for (int[] obstacle : obstacles)
            board.obstacles.add(new Point(obstacle[0], obstacle[1]));

        Point queenPoint = new Point(rowQueenPosition, columnQueenPosition);
        int possibleNumberOfSquaresThatTheQueenCanAttack = 0;
        for (Direction direction : Direction.values())
            possibleNumberOfSquaresThatTheQueenCanAttack += countPossibleSquares(board, direction, queenPoint);
        return possibleNumberOfSquaresThatTheQueenCanAttack;
    }

    private static int countPossibleSquares(Board board, Direction direction, Point point) {
        int counter = 0;
        Point nextPoint = direction.changePosition(point);
        if (board.pointOnBoard(nextPoint) && !board.pointOnObstacle(nextPoint)) {
            counter++;
            counter += countPossibleSquares(board, direction, nextPoint);
        }
        return counter;
    }
}

enum Direction {

    LEFT(-1, 0), RIGHT(1, 0), UP(0, 1), DOWN(0, -1),
    LEFT_UP(-1, 1), RIGHT_UP(1, 1), LEFT_DOWN(-1, -1), RIGHT_DOWN(1, -1);

    private final int dx, dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    Point changePosition(Point point) {
        return new Point(point.row + dy, point.column + dx);
    }
}

class Point {

    int row, column;

    Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Point point = (Point) obj;

        return point.row == row && point.column == column;
    }

    @Override
    public int hashCode() {
        return row + column;
    }
}

class Board {

    int boardSize;
    Set<Point> obstacles;

    boolean pointOnBoard(Point point) {
        return !(point.row < 1 || point.column < 1 || point.row > boardSize || point.column > boardSize);
    }

    boolean pointOnObstacle(Point point) {
        return obstacles.contains(point);
    }
}
