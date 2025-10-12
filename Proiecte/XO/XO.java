public class XO {
	static tabel tabel1 = new tabel();
	static player p1 = new player('X');
	static player p2 = new player('O');
    public static void main(String[] args) {
		tabel1.setareTabela();
		tabel1.printTabela();
		while(tabel1.checkWin()==false && !tabel1.estePlin()) {
			p1.readpos();
			tabel1.setaPos(p1.x, p1.y, p1.c);
			tabel1.printTabela();
			if(tabel1.checkWin()==false && !tabel1.estePlin()) {
				p2.readpos();
				tabel1.setaPos(p2.x, p2.y, p2.c);
				tabel1.printTabela();
			}
			else break;
    }
	}
}
