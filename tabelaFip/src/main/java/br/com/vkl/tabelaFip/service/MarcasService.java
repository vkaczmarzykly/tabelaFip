package br.com.vkl.tabelaFip.service;

import br.com.vkl.tabelaFip.model.ConsumirApiFipe;

import java.util.Objects;

public class MarcasService {

    private final ConsumirApiFipe apiFipe = new ConsumirApiFipe();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void listarMarcas(String tipoVeiculoSelecionado) {
        var jsonApiFipe = apiFipe.consumirApiFipe(ENDERECO + tipoVeiculoSelecionado + "/marcas");
        System.out.println(jsonApiFipe);
    }
}
