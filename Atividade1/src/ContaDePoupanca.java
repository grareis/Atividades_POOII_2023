class ContaDePoupanca {
	
    private static double taxaDeJurosAnual;    
    private double saldoDaPoupanca;

    public void calculeRendimentoMensal() {
        double rendimentoMensal = saldoDaPoupanca * (taxaDeJurosAnual / 12);
        saldoDaPoupanca += rendimentoMensal;
    }

    public static void modifiqueTaxaDeJuros(double novaTaxa) {
        taxaDeJurosAnual = novaTaxa;
    }

    public double getSaldoDaPoupanca() {
        return saldoDaPoupanca;
    }

    public void setSaldoDaPoupanca(double saldo) {
        saldoDaPoupanca = saldo;
    }
}
