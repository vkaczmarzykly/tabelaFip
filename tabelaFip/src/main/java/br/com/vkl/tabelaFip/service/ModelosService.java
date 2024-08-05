package br.com.vkl.tabelaFip.service;

import br.com.vkl.tabelaFip.model.ConsumirApiFipe;
import br.com.vkl.tabelaFip.model.DadosAnos;
import br.com.vkl.tabelaFip.model.DadosModelos;
import br.com.vkl.tabelaFip.model.ListaModelos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ModelosService {

    private final ConsumirApiFipe apiFipe = new ConsumirApiFipe();

    private final ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    public DadosModelos listarModelos(String tipoVeiculoSelecionado, String codigoMarca) {
        var json = apiFipe.consumirApiFipe(ENDERECO + tipoVeiculoSelecionado + "/marcas/" +
                                          codigoMarca + "/modelos");
        return conversor.obterDados(json, DadosModelos.class);
    }

    public Stream<ListaModelos> buscarModelo(DadosModelos dadosModelos, String trechoSelecionado) {
       Stream<ListaModelos> modeloSelecionado = dadosModelos.modelos().stream()
                .filter(m -> m.nome().toUpperCase().contains(trechoSelecionado.toUpperCase()));
       return modeloSelecionado;
    }

    public List<DadosAnos> listarAnoValorModelo(String tipoVeiculoSelecionado, String marcaSelecionada,
                                     String modeloFiltradoEscolhido) {
        var json = apiFipe.consumirApiFipe(ENDERECO + tipoVeiculoSelecionado + "/marcas/" +
                marcaSelecionada + "/modelos/" + modeloFiltradoEscolhido + "/anos");
        return conversor.obterLista(json, DadosAnos.class);
    }
}
