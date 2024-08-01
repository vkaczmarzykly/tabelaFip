package br.com.vkl.tabelaFip.controller;

import br.com.vkl.tabelaFip.model.DadosMarcas;
import br.com.vkl.tabelaFip.service.MarcasService;
import br.com.vkl.tabelaFip.model.FrontEnd;
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

	@Override
	public void run(String... args) throws Exception {
		var tipoVeiculoSelecionado = frontEnd.exibeMenuTipoVeiculo();
		List<DadosMarcas> dadosMarcas = marcasService.listarMarcas(tipoVeiculoSelecionado);

		var marcaSelecionada = frontEnd.exibeMenuDois(dadosMarcas);
	}
}
