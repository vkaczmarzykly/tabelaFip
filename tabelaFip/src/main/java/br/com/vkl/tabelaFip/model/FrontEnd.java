package br.com.vkl.tabelaFip.model;

import java.util.List;
import java.util.Scanner;

public class FrontEnd {

    private Scanner leitura = new Scanner(System.in);

    public String exibeMenuTipoVeiculo(){
        System.out.println("\nDigite o tipo de veículo desejado (carros, caminhoes ou motos): ");
        return leitura.nextLine();
    }

    public String exibeMenuDois(List<DadosMarcas> dadosMarcas) {
        dadosMarcas.forEach(m -> System.out.println("Marca: " + m.nome() + " \nCodigo: " + m.codigo() + "\n"));
        System.out.println("Digite o codigo da marca escolhida: ");
        return null;
    }
}
