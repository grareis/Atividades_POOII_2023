public class TesteContaDePoupanca {
	
    public static void main(String[] args) {
        ContaDePoupanca.modifiqueTaxaDeJuros(0.06);

        ContaDePoupanca poupador1 = new ContaDePoupanca();
        poupador1.setSaldoDaPoupanca(2000.0);

        ContaDePoupanca poupador2 = new ContaDePoupanca();
        poupador2.setSaldoDaPoupanca(3000.0);

        poupador1.calculeRendimentoMensal();
        poupador2.calculeRendimentoMensal();

        System.out.println("Saldo cliente 1 após 1 mês: R$" + poupador1.getSaldoDaPoupanca());
        System.out.println("Saldo cliente 2 após 1 mês: R$" + poupador2.getSaldoDaPoupanca());

        ContaDePoupanca.modifiqueTaxaDeJuros(0.08);

        poupador1.calculeRendimentoMensal();
        poupador2.calculeRendimentoMensal();

        System.out.println("Saldo cliente 1 após 2 meses: R$" + poupador1.getSaldoDaPoupanca());
        System.out.println("Saldo cliente 2 após 2 meses: R$" + poupador2.getSaldoDaPoupanca());
    }
}