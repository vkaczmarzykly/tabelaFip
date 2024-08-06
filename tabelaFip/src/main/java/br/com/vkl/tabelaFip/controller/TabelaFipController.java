package br.com.vkl.tabelaFip.controller;

import br.com.vkl.tabelaFip.model.*;
import br.com.vkl.tabelaFip.service.ModelosService;
import br.com.vkl.tabelaFip.service.MarcasService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TabelaFipController implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TabelaFipController.class, args);
	}

	private final FrontEnd frontEnd = new FrontEnd();
	private final MarcasService marcasService = new MarcasService();

	private final ModelosService modelosService = new ModelosService();

	@Override
	public void run(String... args) throws Exception {
		var tipoVeiculoSelecionado = frontEnd.exibeMenuTipoVeiculo();
		List<DadosMarcas> dadosMarcas = marcasService.listarMarcas(tipoVeiculoSelecionado);

		var marcaSelecionada = frontEnd.exibeMenuMarca(dadosMarcas);
		var dadosModelos = modelosService.listarModelos(tipoVeiculoSelecionado, marcaSelecionada);

		var trechoSelecionado = frontEnd.exibeMenuModelo(dadosModelos);
		var modeloSelecionado = modelosService.buscarModelo(dadosModelos, trechoSelecionado);

		var modeloFiltradoEscolhido = frontEnd.exibeModeloFiltrado(modeloSelecionado);
		List<DadosAnos> listaAnoModelo = modelosService.listarAnoModelo(tipoVeiculoSelecionado, marcaSelecionada,
				modeloFiltradoEscolhido);

		List<DetalhesModelo> listaDetalhesModelo = modelosService.listarDetalhesModelo(tipoVeiculoSelecionado, marcaSelecionada,
				modeloFiltradoEscolhido, listaAnoModelo);
		frontEnd.exibeMenuFinal(listaDetalhesModelo);

	}
}
