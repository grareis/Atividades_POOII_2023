public class Comando {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);

        Orientador o1 = new Orientador("Felipão");
        Orientador o2 = new Orientador("Dunga");
        
        Orientador e1 = new Orientador("Kaká");
        Orientador e2 = new Orientador("Ronaldinho");
        Orientador e3 = new Orientador("Cafu");
       
        

       System.out.println("Orientadores disponíveis → " + o1 + o2);
       System.out.println("Estudantes disponíveis → " + e1 + e2 + e3 );
       
    }
}