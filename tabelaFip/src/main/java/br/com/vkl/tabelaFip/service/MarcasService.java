package br.com.vkl.tabelaFip.service;

import br.com.vkl.tabelaFip.model.ConsumirApiFipe;
import br.com.vkl.tabelaFip.model.DadosMarcas;

import java.util.List;

public class MarcasService {

    private final ConsumirApiFipe apiFipe = new ConsumirApiFipe();

    private final ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public List<DadosMarcas> listarMarcas(String tipoVeiculoSelecionado) {
        var json = apiFipe.consumirApiFipe(ENDERECO + tipoVeiculoSelecionado + "/marcas");
        return conversor.obterLista(json, DadosMarcas.class);
    }
}
