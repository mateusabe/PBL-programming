/************************************************************************************************
Autor: Mateus de Almeida Miranda.
Componente Curricular: MI - Programação.
Concluído:26/04/2018.
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum trecho
de código de outro colega ou de outro autor, tais como provindos de livros e apostilas, e páginas
ou documentos eletrônicos da Internet. Qualquer trecho de código de outra autoria que não a minha
está destacado com uma citação para o autor e a fonte do código, e estou ciente que estes trechos
não serão considerados para fins de avaliação.
*************************************************************************************************/

package br.uefs.ecomp.bfs.controller;

import br.uefs.ecomp.bfs.model.Bloco;
import br.uefs.ecomp.bfs.model.Foliao;
import br.uefs.ecomp.bfs.model.Transporte;
import br.uefs.ecomp.bfs.util.Iterador;
import br.uefs.ecomp.bfs.util.ListaEncadeada;

public class ControllerBFS {
    //Nessa classe, criei todos os métodos e atributos exigidos pelo teste e 
    //pelo facade.
    public ListaEncadeada blocos = new ListaEncadeada();
    public ListaEncadeada folioes = new ListaEncadeada();
    public Iterador listarTransportes;
    private int blocoId = 0;
    private int transporteId = 1000; 
    //Esse método insere referências objetos do tipo bloco na lista 
    //encadeada blocos.
    public Bloco cadastrarBloco(String nome, String local, int saida){
        Bloco bloco = new Bloco(nome,local,saida);
        bloco.setId(blocoId++);
        blocos.insereFinal(bloco);
        return bloco;
    }
    //Esse método insere referências de objetos do tipo foliao na lista 
    //encadeada folioes.
    public Foliao cadastrarFoliao(String CPF, String RG, String Nome, int Idade){
        Foliao foliao = new Foliao(CPF, RG, Nome, Idade);
        folioes.insereFinal(foliao);
        return foliao;
    }
    //Esse método insere referências de objetos do tipo transporte na lista 
    //encadeada transportes que está na classe Bloco.
    public Transporte cadastrarTransporte(String nome, String tipo, double valor, int capacidade, int saida, 
    String localSaida, int retorno, String localRetorno, int chegada, String localChegada, Bloco bloco){
        Transporte transporte = new Transporte(nome, tipo, valor, capacidade, saida, localSaida, retorno,
                                               localRetorno, chegada, localChegada, bloco);
        bloco.transportes.insereFinal(transporte);
        transporte.setId(transporteId++);
        
        return transporte;
    }
    //Esse método recebe um bloco como parâmetro para que possa listar os 
    //transportes inseridos na lista encadeada do mesmo.
    public Iterador listarTransportes(Bloco bloco){
        for(int i = 0; blocos.recupera(i) != null; i++){
            if(blocos.recupera(i) == bloco)
                return bloco.transportes.iterador();
        }
        return null;
    }
    //Criei esse método para que não seja adicionado um foliao numa lista 
    //de tranportes que já tenha esse foliao.
    private boolean foliaoRepetido(Transporte transporte, Foliao foliao){
        for(int i = 0; i<transporte.foliao.tamanho(); i++){
            if(foliao == transporte.foliao.recupera(i)){
                return true;
            }
        }
        return false;
    }
    //Esse método insere referências de objetos do tipo foliao na lista
    //encadeada foliao, presente na classe Transporte.
    public boolean registrarFoliaoEmTransporte(Foliao foliao, Transporte transporte){
        if(transporte.foliao.estaVazia()){
            transporte.foliao.insereFinal(foliao);
            return true;
        }
        else if(transporte.foliao.tamanho() == 1){
            if(foliao != transporte.foliao.recupera(0)){
                transporte.foliao.insereFinal(foliao);   
                foliao.setTransporte(transporte);
                return true;                   
            }
            return false;
        }
        else{
            if(foliaoRepetido(transporte, foliao) == false){
                transporte.foliao.insereFinal(foliao);
                foliao.setTransporte(transporte);
                return true;
            }
            return false;
        }
    }
    //Esse método recebe um transporte como parâmetro para que possa listar os
    //folioes inseridos na lista encadeada do mesmo.
    public Iterador listarFolioes(Transporte transporte){
        return transporte.foliao.iterador();
    }
    //Esse método recebe como parâmetro um id. Para localizar um bloco, um id 
    //é a melhor opção. Se o bloco que possua tal id for achado, o mesmo é 
    //retornado, senão, é retornado null.
    public Bloco obterBloco(int id){
        Bloco bloco;
        for(int i = 0; i<blocos.tamanho(); i++){
            bloco = (Bloco)blocos.recupera(i);
            if(bloco.getId()==id){
                return bloco;
            }
        }
        return null;
    }
    //Esse método funciona da mesma forma que o anterior, porém, este id é para 
    //localizar transportes. Diferente do id de bloco, que começa a partir de 0,
    //o de transporte começa a partir de 1000.
    public Transporte obterTransporte(int id){
        Bloco bloco;
        Transporte transporte;
        for(int i = 0; i<blocos.tamanho(); i++){
            bloco = (Bloco)blocos.recupera(i);
            for(int x = 0; i<bloco.transportes.tamanho(); x++){
                transporte = (Transporte)bloco.transportes.recupera(x);
                if(transporte.getId() == id){
                    return transporte;
                }
            }
        }
        return null;
    }
    //Esse método funciona da mesma forma que os dois anteriores, porém, é para
    //localizar um foliao, e o id do foliao é o seu CPF.
    public Foliao obterFoliao(String cpf){
        Foliao foliao;
        for(int i = 0; i < folioes.tamanho(); i++){
            foliao = (Foliao)folioes.recupera(i);
            if(foliao.getCpf().equals(cpf)){
                return foliao;
            } else {
            }
        }
        return null;
    }
    //Esse método recebe o nome de um local como parâmetro. Para procurar e 
    //retornar os blocos que possuam esse mesmo local, criei uma nova lista
    //encadeada e adicionei nela os blocos que possuam esse local. Assim
    //retornei o iterador dessa nova lista.
    public Iterador listarBlocos(String local){
        ListaEncadeada bloco = new ListaEncadeada();
        Bloco b;
        for(int i = 0; i<blocos.tamanho(); i++){
            b = (Bloco)blocos.iterador().proximo();
            if(b.getLocal().equals(local))
                bloco.insereFinal(b);
        }
        return bloco.iterador();
    }
}