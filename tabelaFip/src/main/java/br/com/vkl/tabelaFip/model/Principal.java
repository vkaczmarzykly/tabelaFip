package br.com.vkl.tabelaFip.model;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    public String exibeMenuTipoVeiculo(){
        System.out.println("\nDigite o tipo de veículo desejado (carros, caminhoes ou motos): ");
        return leitura.nextLine();
    }

}
