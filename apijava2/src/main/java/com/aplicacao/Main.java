package com.aplicacao;

import com.aplicacao.servico.ApiServico;

public class Main {
    public static void main(String[] args) {
        ApiServico apiServico = new ApiServico();
        System.out.println(apiServico.getEndereco("13737-460"));

    }
}