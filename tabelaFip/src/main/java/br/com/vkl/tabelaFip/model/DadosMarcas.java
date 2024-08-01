package br.com.vkl.tabelaFip.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarcas(String codigo, String nome) {

}
