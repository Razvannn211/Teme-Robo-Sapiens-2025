import java.util.Scanner;

public class Salut {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Introdu numele tau: ");
        String nume = input.nextLine();

        System.out.print("Introdu varsta ta: ");
        int varsta = input.nextInt();

        System.out.println("Salut, " + nume + "! Ai " + varsta + " ani.");

        input.close();
    }
}
