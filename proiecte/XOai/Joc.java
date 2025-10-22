
import java.util.Random;
import java.util.Scanner;
public class Joc {
    Random random = new Random();
    static int chance;
    int turn;
    int weak = 0;
    char [][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
    static char player;
    static char ai;
    public static void main(String[] args) {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Alege X sau O:");
         player = newScanner.next().charAt(0);
         ai = (player == 'X') ? 'O' : 'X';
         System.out.println("Alege dificultatea: 1. Usor  2. Greu 3. Bebeh");
         int difficulty = newScanner.nextInt();
         if(difficulty == 1) {
                chance = 2;
         }
         else if(difficulty == 2) {
            chance = 100;
         }
         else if (difficulty == 3) {
            chance = 1;
         }
         else {
            System.out.println("Dificultate invalida. Setat pe Greu.");
            chance = 100;
         }
        Joc game = new Joc();
        game.afisareTabla();
        while(true) {
            if(game.turn % 2 == 0) {
                game.playerMove();
                game.afisareTabla();
                if(game.checkWin(player)) {
                    System.out.println("Felicitari! Ai castigat!");
                    break;
                }
            } else {
                game.aiMove();
                game.afisareTabla();
                if(game.checkWin(ai)) {
                    System.out.println("AI a castigat! Mai incearca.");
                    break;
                }
            }
            if(game.isFull()) {
                System.out.println("Remiza!");
                break;
            }
        }
    }
    void afisareTabla() {
    System.out.println(" ");
        for(int i=0; i<=2; i++) {
            for(int j=0; j<=2; j++) {
                if(board[i][j] != 'X' && board[i][j] != 'O') {
                    int cellNumber = i * 3 + j + 1;
                    System.out.print("|" + cellNumber);
            }
            else System.out.print("|" + board[i][j]);
        }
        System.out.println("|");
    }
    System.out.println("---------");
}
    boolean isFull() {
        for(int i=0; i<=2; i++) {
            for(int j=0; j<=2; j++) {
                if(board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
    boolean checkWin(char symbol) {
        for(int i=0; i<=2; i++) {
            if(board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            if(board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        if(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if(board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }
    int MinMax (int depth, boolean isMax) {
        if(checkWin(ai)) {
            return 10 - depth;
        }
        if(checkWin(player)) {
            return depth - 10;
        }
        if(isFull()) {
            return 0;
        }
        if(isMax) {
            int bestScore = Integer.MIN_VALUE;
            int lowScore = Integer.MAX_VALUE;
            for(int i=0; i<=2; i++) {
                for(int j=0; j<=2; j++) {
                    if(board[i][j] != 'X' && board[i][j] != 'O') {
                        char backup = board[i][j];
                        board[i][j] = ai;
                        int score = MinMax(depth + 1, false);
                        board[i][j] = backup;
                        bestScore = Math.max(score, bestScore);
                        lowScore = Math.min(score, lowScore);
                    }
                }
            }
            if(weak == 0) {
                return lowScore;
            }
            else {
            return bestScore;
            }
        } else {
            int bestScore = Integer.MAX_VALUE;
            for(int i=0; i<=2; i++) {
                for(int j=0; j<=2; j++) {
                    if(board[i][j] != 'X' && board[i][j] != 'O') {
                        char backup = board[i][j];
                        board[i][j] = player;
                        int score = MinMax(depth + 1, true);
                        board[i][j] = backup;
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
    void aiMove() {
        int bestScore = Integer.MIN_VALUE;
        int lowScore = Integer.MAX_VALUE;
        int moveRow = -1;
        int moveCol = -1;
              weak = random.nextInt(chance);
              System.out.println(weak);
        for(int i=0; i<=2; i++) {
            for(int j=0; j<=2; j++) {
                if(board[i][j] != 'X' && board[i][j] != 'O') {
                    char backup = board[i][j];
                    board[i][j] = ai;
                    int score = MinMax(0, false);
                    board[i][j] = backup;
                    if (weak != 0) {
                    if(score > bestScore) {
                        bestScore = score;
                        moveRow = i;
                        moveCol = j;
                    }
                }
                else{
                    if(score < lowScore) {
                        lowScore  = score;
                        moveRow = i;
                        moveCol = j;
                        System.out.println("Low score: " + lowScore + " at (" + moveRow + ", " + moveCol + ")");
                    }
                }
                }
            }
        }
        board[moveRow][moveCol] = ai;
        turn++;
    }
    void playerMove() {
        Scanner newScanner = new Scanner(System.in);
        int move;
        while(true) {
            System.out.println("Alege o pozitie (1-9):");
            move = newScanner.nextInt();
            if(move < 1 || move > 9) {
                System.out.println("Pozitie invalida. Alege din nou.");
                continue;
            }
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            if(board[row][col] == 'X' || board[row][col] == 'O') {
                System.out.println("Pozitie deja ocupata. Alege din nou.");
                continue;
            }
            board[row][col] = player;
            turn++;
            break;
        }
    }
}
