package br.com.vkl.tabelaFip.controller;

import br.com.vkl.tabelaFip.service.MarcasService;
import br.com.vkl.tabelaFip.model.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelaFipController implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TabelaFipController.class, args);
	}

	private final Principal principalService = new Principal();
	private final MarcasService marcasService = new MarcasService();

	@Override
	public void run(String... args) throws Exception {
		var tipoVeiculoSelecionado = principalService.exibeMenuTipoVeiculo();
		marcasService.listarMarcas(tipoVeiculoSelecionado);
	}
}
