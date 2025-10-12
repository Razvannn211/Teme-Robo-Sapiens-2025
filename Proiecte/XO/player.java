import java.util.Scanner;
public class player {
    public char c;
    public player(char c) {
        this.c=c;
    }
    public int x, y;
    Scanner in = new Scanner(System.in);
    public void readpos(){
        System.out.println("Jucator "+c + ":");
        System.out.println("Introduceti coordonatele:");
        int x_pos = in.nextInt();
        int y_pos = in.nextInt();
        if(x_pos<0 || x_pos>2 || y_pos<0 || y_pos>2) {
            System.out.println("Coordonate invalide! Reincercati!");
            readpos();
        }
        else {
            x=x_pos;
            y=y_pos;
            if(XO.tabel1.checksquare(x, y)==false) {
                System.out.println("Pozitie ocupata! Reincercati!");
                readpos();
        }
        else {
            XO.tabel1.setaPos(x, y, c);
        }
    }
}
}
