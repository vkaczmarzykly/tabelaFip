package br.com.vkl.tabelaFip.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FrontEnd {

    private Scanner leitura = new Scanner(System.in);

    private List<DadosModelos> listaModelos = new ArrayList<>();
    public String exibeMenuTipoVeiculo(){
        System.out.println("\nDigite o tipo de veículo desejado (carros, caminhoes ou motos): ");
        return leitura.nextLine();
    }

    public String exibeMenuMarca(List<DadosMarcas> dadosMarcas) {
        dadosMarcas.forEach(System.out::println);
        System.out.println("Digite o codigo da marca escolhida: ");
        return leitura.nextLine();
    }

    public String exibeMenuModelo(DadosModelos dadosModelos) {
        dadosModelos.modelos().stream()
                .sorted(Comparator.comparing(ListaModelos::nome))
                .forEach(System.out::println);

        System.out.println("Digite um trecho do modelo desejado (ex. palio): ");
        return leitura.nextLine();
    }

    public String exibeModeloFiltrado(Stream<ListaModelos> modeloSelecionado) {
        modeloSelecionado.forEach(System.out::println);
        System.out.println("Digite o código do modelo desejado: ");
        return leitura.nextLine();
    }
}
