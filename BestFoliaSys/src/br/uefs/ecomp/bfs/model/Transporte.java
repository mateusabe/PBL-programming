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

package br.uefs.ecomp.bfs.model;

import br.uefs.ecomp.bfs.util.ListaEncadeada;
import java.util.Objects;

public final class Transporte {
    //Aqui crio os atributos exigidos pelo problema.
    private int id;
    private String nome;
    private String tipo;
    private double valor;
    private int capacidade;
    private int saida;
    private String localSaida;
    private int retorno;
    private String localRetorno;
    private int chegada;
    private String localChegada;
    private Bloco bloco;
    //Aqui crio uma lista encadeada do para guardar a referencia dos
    //folioes de cada transporte.
    public ListaEncadeada foliao = new ListaEncadeada();
    //Aqui crio um construtor, para a realização dos testes.
    public Transporte(String nome, String tipo, double valor, int capacidade, int saida, 
                      String localSaida, int retorno, String localRetorno, int chegada, String localChegada, Bloco b1){
        setNome(nome);
        setTipo(tipo);
        setValor(valor);
        setCapacidade(capacidade);
        setSaida(saida);
        setLocalSaida(localSaida);
        setRetorno(retorno);
        setLocalRetorno(localRetorno);
        setChegada(chegada);
        setLocalChegada(localChegada);
        setBloco(b1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

    public String getLocalSaida() {
        return localSaida;
    }

    public void setLocalSaida(String localSaida) {
        this.localSaida = localSaida;
    }

    public int getRetorno() {
        return retorno;
    }

    public void setRetorno(int retorno) {
        this.retorno = retorno;
    }

    public String getLocalRetorno() {
        return localRetorno;
    }

    public void setLocalRetorno(String localRetorno) {
        this.localRetorno = localRetorno;
    }

    public int getChegada() {
        return chegada;
    }

    public void setChegada(int chegada) {
        this.chegada = chegada;
    }

    public String getLocalChegada() {
        return localChegada;
    }

    public void setLocalChegada(String localChegada) {
        this.localChegada = localChegada;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }
    //Aqui crio um construtor do equals para a realização dos testes.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transporte other = (Transporte) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (this.capacidade != other.capacidade) {
            return false;
        }
        if (this.saida != other.saida) {
            return false;
        }
        if (this.retorno != other.retorno) {
            return false;
        }
        if (this.chegada != other.chegada) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.localSaida, other.localSaida)) {
            return false;
        }
        if (!Objects.equals(this.localRetorno, other.localRetorno)) {
            return false;
        }
        if (!Objects.equals(this.localChegada, other.localChegada)) {
            return false;
        }
        return Objects.equals(this.bloco, other.bloco);
    }
    
    
}
