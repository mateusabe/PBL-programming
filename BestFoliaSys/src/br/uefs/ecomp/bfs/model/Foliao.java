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

import java.util.Objects;

public class Foliao {
    //Aqui crio os atributos exigidos pelo problema.
    private String nome;
    private String rg;
    private String cpf;
    private int idade;
    //Aqui criei um objeto do tipo tranporte para facilitar a impressão das 
    //informações do foliao.
    private Transporte transporte;

    //Aqui crio os getters e setters dos atributos.
    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    //Aqui crio um construtor, para a realização dos testes.
    public Foliao(String CPF, String RG, String Nome, int Idade){
        setCpf(CPF);
        setRg(RG);
        setNome(Nome);
        setIdade(Idade);
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
        final Foliao other = (Foliao) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }
  
    
}
