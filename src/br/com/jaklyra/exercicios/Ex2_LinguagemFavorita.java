package br.com.jaklyra.exercicios;

/*
    Crie uma classe LinguagemFavorita que possua atributos, anodecriaçao e ide.
    Em seguida , crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:

    1 - Ordem de inserção
    2 - Ordem Natural
    3 - IDE
    4 - Ano de criação e nome
    5 - Nome, ano de criação e IDE

    Ao final exiba as linguagens no console uma embaixo da outra

 */


import java.util.*;

public class Ex2_LinguagemFavorita {

    public static void main(String [] args){

        //
        Set<LinguagemFavorita> linguagensFavoritas = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Java", "Intellij", 1991));
            add(new LinguagemFavorita("Python", "Pycharm" ,1989 ));
            add(new LinguagemFavorita("C Sharp", "Visual Studio", 2000));
        }};


        //CONJUNTO EM ORDEM DE INSERÇÃO
        System.out.println("Conjunto em ordem de inserção: ");
        System.out.println(" ");

        for (LinguagemFavorita linguagemFavorita : linguagensFavoritas ) {
            System.out.println(linguagemFavorita.getNome() +  " - " + linguagemFavorita.getIde()+
                   " - " +  linguagemFavorita.getAnoCriacao());
        }


        System.out.println("");

        System.out.println("Conjunto organizado pela ordem natural");
        //CONJUNTO EM ORDEM NATURAL
        Set<LinguagemFavorita> linguagemFavorita2 = new TreeSet<>(linguagensFavoritas);
        System.out.println("");

        for (LinguagemFavorita linguagemFavorita: linguagemFavorita2) {
            System.out.println(linguagemFavorita.getNome() + " - " + linguagemFavorita.getIde() + " _ " +
                    linguagemFavorita.getAnoCriacao());

        }

        System.out.println(" ");

        //CONJUNTO ORDENADO PELA IDE
        Set<LinguagemFavorita> linguagemFavorita3 = new TreeSet<>(new CompareIde());
        linguagemFavorita3.addAll(linguagensFavoritas);
        System.out.println("");

        System.out.println("Conjunto Linguagem Favorita ordenada pela IDE: ");
        for (LinguagemFavorita linguagemFavorita :linguagemFavorita3 ) {
            System.out.println(linguagemFavorita.getNome()+ " - " + linguagemFavorita.getIde() + " - " +
                    linguagemFavorita.getAnoCriacao());

        }

        System.out.println(" ");

        System.out.println("Conjunto organizado por Ano de Criação e Nome");
        Set<LinguagemFavorita> linguagemFavorita4 = new TreeSet<>(new CompareAnoCriacaoNome());
        linguagemFavorita4.addAll(linguagensFavoritas);
        System.out.println("");

        for (LinguagemFavorita linguagemFavorita: linguagemFavorita4) {
            System.out.println(linguagemFavorita.getNome() +" - " + linguagemFavorita.getIde() +" - "
                    + linguagemFavorita.getAnoCriacao());

        }


        System.out.println(" ");
        System.out.println("Conjunto organizado por Nome, Ano de Criação e IDE");
        Set<LinguagemFavorita> linguagemFavorita5 = new TreeSet<>(new CompareNomeIdeAnoCriacao());
        linguagemFavorita5.addAll(linguagensFavoritas);
        System.out.println("");

        for (LinguagemFavorita linguagemFavorita : linguagemFavorita5) {
            System.out.println(linguagemFavorita.getNome()+ " - " + linguagemFavorita.getIde()+ " - "
            + linguagemFavorita.getAnoCriacao());

        }
    }
}



    class LinguagemFavorita implements Comparable<LinguagemFavorita>{


        private String nome;
        private String ide;
        private Integer anoCriacao;

        public LinguagemFavorita(String nome, String ide, Integer anoCriacao) {
            this.nome = nome;
            this.ide = ide;
            this.anoCriacao = anoCriacao;
        }

        public String getNome() {
            return nome;
        }

        public String getIde() {
            return ide;
        }

        public Integer getAnoCriacao() {
            return anoCriacao;
        }

        @Override
        public String toString() {
            return "{" +
                    "nome='" + nome + '\'' +
                    ", ide='" + ide + '\'' +
                    ", anoCriacao=" + anoCriacao +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LinguagemFavorita that = (LinguagemFavorita) o;
            return nome.equals(that.nome) && ide.equals(that.ide) && anoCriacao.equals(that.anoCriacao);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, ide, anoCriacao);
        }


        @Override
        public int compareTo(LinguagemFavorita linguagemFavorita){
            return this.getNome().compareToIgnoreCase(linguagemFavorita.getNome());
        }

    }

    class CompareIde implements Comparator<LinguagemFavorita>{

        @Override
        public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
            return l1.getIde().compareToIgnoreCase(l2.getIde());
        }
    }

    class CompareAnoCriacaoNome implements Comparator<LinguagemFavorita>{


        @Override
        public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {

            int anoCriacao = Integer.compare(l1.getAnoCriacao(), l2.getAnoCriacao());
                if(anoCriacao != 0){
                    return anoCriacao;
                }


            return l1.getNome().compareToIgnoreCase(l2.getNome());
        }
    }

    class CompareNomeIdeAnoCriacao implements Comparator<LinguagemFavorita>{


        @Override
        public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {

           int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
           if(nome != 0){

               return nome;
           }

           int anoCriacao = Integer.compare(l1.getAnoCriacao(), l2.getAnoCriacao());
           if(anoCriacao != 0){
               return anoCriacao;
           }


            return l1.getIde().compareToIgnoreCase(l2.getIde());
        }
    }