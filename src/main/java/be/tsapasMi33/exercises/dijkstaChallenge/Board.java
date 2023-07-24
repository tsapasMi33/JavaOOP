package be.tsapasMi33.exercises.dijkstaChallenge;

import java.util.LinkedList;
import java.util.Random;

public class Board {
    private Square[][] board= new Square[10][10];
    private final Random r = new Random();
    private PlayerSquare player;
    private TargetSquare target;
    private boolean isGameOver = false;
    private LinkedList<String> bestPath;
    private int minMoves;
    private LinkedList<String> playerPath = new LinkedList<>();


    public Board() {
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (!(r.nextInt(1,9) % 3 == 0)){
                    board[i][j] = new WhiteSquare(i, j);
                } else {
                    board[i][j] = new BlackSquare(i, j);
                }
            }
        }
        int x = r.nextInt(10);
        int y = r.nextInt(10);
        board[x][y] = new PlayerSquare(x,y);
        player = (PlayerSquare) board[x][y];
        int[] start = {x,y};
        playerPath.add("%d,%d".formatted(x,y));
        x = r.nextInt(10);
        y = r.nextInt(10);
        board[x][y] = new TargetSquare(x,y);
        target = (TargetSquare) board[x][y];
        int[] target = {x, y};
        bestPath = Cell.shortestPath(board, start, target);
        minMoves =bestPath.size();
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public LinkedList<String> getBestPath() {
        return bestPath;
    }

    public int getMinMoves() {
        return minMoves;
    }

    public LinkedList<String> getPlayerPath() {
        return playerPath;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j< board[0].length; j++){
                System.out.printf("%3s",board[i][j]);
            }
            System.out.println();
        }
    }

    public void moveLeft(){
        if (!(player.getY() - 1 < 0)){
            if (board[player.getX()][player.getY()-1] instanceof Walkable){
                var temp = board[player.getX()][player.getY()];
                board[player.getX()][player.getY()] = board[player.getX()][player.getY()-1];
                board[player.getX()][player.getY()-1] = temp;
                player.setY(player.getY() - 1);
            }
        }
        logMove(player.getX(), player.getY());
        checkIfWin();
    }

    public void moveRight(){
        if (!(player.getY() + 1 > 9)){
            if (board[player.getX()][player.getY()+1] instanceof Walkable){
                var temp = board[player.getX()][player.getY()];
                board[player.getX()][player.getY()] = board[player.getX()][player.getY()+1];
                board[player.getX()][player.getY()+1] = temp;
                player.setY(player.getY() + 1);
            }
        }
        logMove(player.getX(), player.getY());
        checkIfWin();
    }

    public void moveUp(){
        if (!(player.getX() - 1 < 0)){
            if (board[player.getX()-1][player.getY()] instanceof Walkable){
                var temp = board[player.getX()][player.getY()];
                board[player.getX()][player.getY()] = board[player.getX()-1][player.getY()];
                board[player.getX()-1][player.getY()] = temp;
                player.setX(player.getX() - 1);
            }
        }
        logMove(player.getX(), player.getY());
        checkIfWin();
    }

    public void moveDown(){
        if (!(player.getX() + 1 > 9)){
            if (board[player.getX()+1][player.getY()] instanceof Walkable){
                var temp = board[player.getX()][player.getY()];
                board[player.getX()][player.getY()] = board[player.getX()+1][player.getY()];
                board[player.getX()+1][player.getY()] = temp;
                player.setX(player.getX() + 1);
            }
        }
        logMove(player.getX(), player.getY());
        checkIfWin();
    }

    private void logMove(int x, int y){
        playerPath.add("%d,%d".formatted(x,y));
    }

    public void checkIfWin() {
        if (player.getX() == target.getX() && player.getY() == target.getY()){
            isGameOver = true;
        }
    }

    private static class Cell {
        int x;
        int y;
        int dist;
        Cell prev;

        Cell(int x, int y, int dist, Cell prev){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }

        public static LinkedList<String> shortestPath(Square[][] matrix, int[] start, int[] end) {
            int sx = start[0], sy = start[1];
            int dx = end[0], dy = end[1];

            int m = matrix.length;
            int n = matrix[0].length;
            Cell[][] cells = new Cell[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++) {
                    if ((matrix[i][j] instanceof Walkable )) {
                        cells[i][j] = new Cell(i,j,Integer.MAX_VALUE,null);
                    }
                }
            }

            LinkedList<Cell> queue = new LinkedList<>();
            Cell src = cells[sx][sy];
            src.dist = 0;
            queue.add(src);
            Cell dest = null;
            Cell p;
            while ((p = queue.poll()) != null){
                if (p.x == dx && p.y == dy) {
                    dest = p;
                    break;
                }
                visit(cells,queue, p.x-1,p.y, p);
                visit(cells,queue, p.x+1,p.y, p);
                visit(cells,queue, p.x,p.y-1, p);
                visit(cells,queue, p.x,p.y+1, p);
            }

            if (dest == null) {
                return null;
            } else {
                LinkedList<Cell> path = new LinkedList<>();
                p = dest;
                do {
                    path.addFirst(p);
                } while ((p = p.prev) != null);
                LinkedList<String> pathList =  new LinkedList<>();
                for (Cell cell : path){
                    pathList.add(cell.toString());
                }
                return pathList;
            }
        }
    }

    static void visit(Cell[][] cells, LinkedList<Cell> queue, int x, int y, Cell parent) {
        if (x < 0 || x >= cells.length || y < 0 || y >= cells[0].length || cells[x][y] == null) {
            return;
        }

        int dist = parent.dist + 1;
        Cell p = cells[x][y];
        if (dist < p.dist) {
            p.dist = dist;
            p.prev = parent;
            queue.add(p);
        }
    }
}
