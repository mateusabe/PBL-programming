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

package br.uefs.ecomp.bfs.util;

//Aqui eu implemento a inferface ILista.
public class ListaEncadeada implements ILista {
    private No head;
    private No tail;
    private int tamanhoLista = 0;

    @Override
    public Iterador iterador() {
        return new ListIterator();
    }
    //Aqui eu implemento a interface Iterador numa classe aninhada.
    public class ListIterator implements Iterador{
        private int atual = 0;
        //Esse método verifica se há algum elemento na "posição" atual.
        @Override
        public boolean temProximo() {
            return get(atual)!=null;
        }
        //Esse método devolve o proximo elemento da posição atual.
        @Override
        public Object proximo() {
            Object o = get(atual);
            atual++;
            return o;        
        }
        
    }
    
    public class No{
        private Object o;
        private No next;
        
        public No(Object o){
            this.o = o;
        }

        public Object getO() {
            return o;
        }

        public void setO(Object o) {
            this.o = o;
        }

        public No getNext() {
            return next;
        }

        public void setNext(No next) {
            this.next = next;
        }
    }
    //Esse método procura um elemento numa posição índice. Esse índice é contado 
    //pela quantidade de Nexts até chegar ao número índice.
    @Override
    public Object recupera(int indice){
        if(indice>=0 && indice<tamanhoLista){
            No n = head;
            for(int i = 0;i < indice;i++){
                n = n.getNext();
            }
            return n.getO();
        }
        return null;
    }
    //Esse método indica se a lista está vazia ou não.
    @Override
    public boolean estaVazia(){
        return tamanhoLista == 0;
    }
    //Esse método retorna a quantidade de elementos da lista.
    @Override
    public int tamanho(){
        return tamanhoLista;
    }
    //Esse método insere um elemento no final da lista encadeada, ou seja, tail
    //passa a referenciar o seu Next.
    @Override
    public void insereFinal(Object o){
        if(head == null)
            head = tail = new No(o);
        else{
            tail.setNext(new No(o));
            tail = tail.getNext();
        }
        tamanhoLista++;
    }
    //Esse método insere um elemento no início da lista encadeada, ou seja, head 
    //passa a referenciar esse objeto o. Se na lista houver um elemento, head
    //passa a referenciar esse objeto e tail passa a referenciar o next do novo 
    //head.
    @Override
    public void insereInicio(Object o){
        if(head == null){
            head = tail = new No(o);
        }
        else{
            No aux = new No(o);
            aux.setNext(head);
            head = aux;
            while(aux!=null){
                aux = aux.getNext();
            }
            tail = aux;
        }
        tamanhoLista++;
    }
    //Esse método remove o primeiro elemento da lista, ou seja, aquele cuja
    //referência está armazenada em head. Para remover, head passa a guardar
    //a referência do Next do head anterior.
    @Override
    public Object removeInicio(){
        if(head == null){
            return null;
        }
        else{
            No aux = head;
            head = head.getNext();
            aux.setNext(null);
            tamanhoLista--;
            return aux.getO();
        }
    }
    //Esse método remove o último objeto da lista, ou seja, remove aquele cujo o
    //seu ponteiro Next aponta para null.
    @Override
    public Object removeUltimo(){
        No aux = head;
        if(head == null){
            return head.getO();
        }
        else if(tamanhoLista==1){
            aux = tail;
            tail=head;
            tamanhoLista--;
            return aux.getO();
        }
        else{
            int i = 0;
            while(i<tamanhoLista-2){
                aux=aux.getNext();
                i++;
            }
            tail = aux;
            aux=aux.getNext();
            tail.setNext(null);
            tamanhoLista--;
            return aux.getO();
        }
    }
   //Esse método extra é para auxiliar nos métodos do Iterador.
    public Object get(int index) {
        No aux = new No(recupera(index));
        if (aux != null){
            return aux.getO();
        }
        return null;
    }
}   
