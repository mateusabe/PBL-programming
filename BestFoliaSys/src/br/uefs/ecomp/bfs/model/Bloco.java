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

public final class Bloco {
    //Aqui crio os atributos exigidos pelo problema.
    private int id;
    private String nome;
    private String local;
    private int saida;
    //Aqui crio uma lista encadeada do para guardar a referencia dos
    //transportes de cada bloco.
    public ListaEncadeada transportes = new ListaEncadeada();
    
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }
    
    
    public Bloco(String nome, String local, int saida){
        setNome(nome);
        setLocal(local);
        setSaida(saida);
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
        final Bloco other = (Bloco) obj;
        if (this.saida != other.saida) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        return true;
    }
    
    
    
}
