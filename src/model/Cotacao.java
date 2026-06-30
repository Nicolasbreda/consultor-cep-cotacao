package model;

public class Cotacao {
    private double cotacaoCompra;
    private double cotacaoVenda;
    private String dataHoraCotacao;

    public Cotacao(double cotacaoCompra, double cotacaoVenda, String dataHoraCotacao) {
        this.cotacaoCompra = cotacaoCompra;
        this.cotacaoVenda = cotacaoVenda;
        this.dataHoraCotacao = dataHoraCotacao;
    }

    public double getCotacaoCompra() {
        return cotacaoCompra;
    }

    public double getCotacaoVenda() {
        return cotacaoVenda;
    }

    public String getDataHoraCotacao() {
        return dataHoraCotacao;
    }

    private String formatarData(String dataCompleta) {
        if (dataCompleta.contains(".")) {
            return dataCompleta.substring(0, dataCompleta.indexOf("."));
        }
        return dataCompleta;
    }

    @Override
    public String toString() {
        return String.format("Dólar - Compra: R$ %.2f | Venda: R$ %.2f (Data: %s)",
                cotacaoCompra, cotacaoVenda, formatarData(dataHoraCotacao));
    }
}