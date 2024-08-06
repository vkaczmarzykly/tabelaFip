package br.com.vkl.tabelaFip.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DetalhesModelo(String Valor,
                             String Marca,
                             String Modelo,
                             Integer AnoModelo,
                             String Combustivel,
                             String CodigoFipe,
                             String MesReferencia,
                             String SiglaCombustivel) {

    @Override
    public String toString() {
                return Modelo +
                " Ano: " + AnoModelo +
                "  Valor: " + Valor +
                "  Combustivel: " + Combustivel;
    }
}
