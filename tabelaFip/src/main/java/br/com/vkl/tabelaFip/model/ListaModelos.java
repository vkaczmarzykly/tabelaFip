package br.com.vkl.tabelaFip.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaModelos(Integer codigo, String nome) {
    @Override
    public String toString() {
        return "Modelo: " + nome + "\nCodigo: " + codigo + "\n";
    }
}
