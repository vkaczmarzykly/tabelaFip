package br.com.vkl.tabelaFip.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarcas(String codigo, String nome) {
    @Override
    public String toString() {
        return "Marca: " + nome + "\nCodigo: " + codigo + "\n";
    }
}
