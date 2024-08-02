package br.com.vkl.tabelaFip.service;

import br.com.vkl.tabelaFip.model.ConsumirApiFipe;
import br.com.vkl.tabelaFip.model.DadosMarcas;
import br.com.vkl.tabelaFip.model.DadosModelos;
import br.com.vkl.tabelaFip.model.ListaModelos;

import java.util.ArrayList;
import java.util.List;

public class ModelosService {

    private final ConsumirApiFipe apiFipe = new ConsumirApiFipe();

    private final ConverteDados conversor = new ConverteDados();

    private final List<DadosModelos> listaModelos = new ArrayList<>();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    public DadosModelos listarModelos(String tipoVeiculoSelecionado, String codigoMarca) {
        var json = apiFipe.consumirApiFipe(ENDERECO + tipoVeiculoSelecionado + "/marcas/" +
                                          codigoMarca + "/modelos");
        return conversor.obterDados(json, DadosModelos.class);
    }
}
