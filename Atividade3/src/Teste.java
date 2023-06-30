import java.text.ParseException;
import java.text.SimpleDateFormat;
import entities.Contratacao;
import entities.Funcionario;
import entities.Projeto;
import entities.enums.Cargo;
import entities.enums.TipoDeDocumento;

public class Teste {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Projeto p1 = new Projeto("Boteco do Zé", df.parse("01/01/2021"), df.parse("31/12/2021"));
        Funcionario f1 = new Funcionario("Robert de Niro", TipoDeDocumento.CPF, "123.456.789-00");
        Funcionario f2 = new Funcionario("José Pires", TipoDeDocumento.CPF, "234.567.891-00");
        Contratacao c1 = new Contratacao(df.parse("01/01/2021"), Cargo.DIRETOR, f1, p1);
        Contratacao c2 = new Contratacao(df.parse("11/10/2021"), Cargo.ADMINISTRATIVO, f2, p1);

        p1.listarContratacoes();
        c1.contratar();
        p1.listarContratacoes();
        c1.demitir();
        c2.contratar();
        p1.listarContratacoes();
    }
}
