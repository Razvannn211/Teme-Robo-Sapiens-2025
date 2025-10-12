public class tabel {
    static private final  char tabela[][]=new char[3][3]; 
        public void setareTabela() {
    	for(int i=0;i<3;i++) {
    		for(int j=0;j<3;j++) {
    			tabela[i][j]='-';
    		}
    	}
    }
        public void setaPos(int i, int j, char c) {
            tabela[i][j]=c;
    }
    public boolean  checksquare(int i, int j) {
        return tabela[i][j] == '-';
    }
    boolean estePlin() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(tabela[i][j]=='-') {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean  checkWin() {
        if(estePlin()) {
            System.out.println("Egalitate!");
            return  true;
        }
        else {
        for(int i=0; i<3; i++) {
            if(tabela[i][0]==tabela[i][1] && tabela[i][1]==tabela[i][2] && tabela[i][0]!='-') {
                System.out.println("Jucator "+tabela[i][0]+" a castigat!");
                return true;
            }
            else if(tabela[0][i]==tabela[1][i] && tabela[1][i]==tabela[2][i] && tabela[0][i]!='-') {
                System.out.println("Jucator "+tabela[0][i]+" a castigat!");
                return true;
            }
        }
        if(tabela[0][0]==tabela[1][1] && tabela[1][1]==tabela[2][2] && tabela[0][0]!='-') {
            System.out.println("Jucator "+tabela[0][0]+" a castigat!");
            return true;
        }
        else if(tabela[0][2]==tabela[1][1] && tabela[1][1]==tabela[2][0] && tabela[0][2]!='-') {
            System.out.println("Jucator "+tabela[0][2]+" a castigat!");
            return true;
        }
    }
    return false;
    }
    public void printTabela() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(tabela[i][j]+" ");
            }
            System.out.println();
        }
    }
}
