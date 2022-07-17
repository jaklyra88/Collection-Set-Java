package br.com.jaklyra.set;


/*
    Dados os seguintes informações sobre algumas séries.
    Crie um conjunto e ordene este conjunto exibindo.
    (nome - genero - tempo do episódio)

    Série 1 - Nome: got , gênero: fantasia , tempoEpisodio: 60
    Série 2 - Nome: dark , gênero: drama, tempoEpisodio: 60
    Série 3 - Nome: that '70 show , gênero: comédia, tempoEpisodio: 25

 */

import java.sql.SQLOutput;
import java.util.*;

public class ExemploOrdenacaoSet {

    public static void main(String[] args){






        System.out.println("--\t Ordem Aleatória\t---");
        System.out.println(" ");

        Set<Serie> series = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama" , 60));
            add(new Serie("That '70s show" , "comedia", 25));
        }};

        for (Serie serie: series) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() +" - " + serie.getTempoEpisodio());

        }
        System.out.println(" ");

        System.out.println("--\t Ordem de Inserção\t---");
        System.out.println(" ");
        Set<Serie> series1 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("That '70s show", "comédia", 25));
        }};

        for (Serie serie: series1) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        }

        System.out.println(" ");

        //DEVEMOS CRIAR O COMPARABLE DE SERIE
        System.out.println("--\t Ordem Natural (Nome)\t---");
        System.out.println(" ");

        //CRIANDO A COLEÇÃO
        Set<Serie> series2 = new TreeSet<>(series);

        for (Serie serie: series2) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        }
        System.out.println(" ");

        //
        System.out.println("--\t Ordem Nome/Genero/TempoEpisodio\t---");
        Set<Serie> series3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        series3.addAll(series);
        System.out.println(" ");
        for (Serie serie: series3) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - "+ serie.getTempoEpisodio());

        }

        System.out.println(" ");

        System.out.println("--\t Ordem Gênero\t---");
        System.out.println(" ");
        Set<Serie> series4 = new TreeSet<>(new ComparatorGenero());
        series4.addAll(series);

        for (Serie serie : series4 ) {
            System.out.println(serie.getNome() + " - "+ serie.getGenero() + " - " + serie.getTempoEpisodio());

        }

        System.out.println(" ");

        System.out.println("--\t Ordem Tempo\t---");
        System.out.println("");
        Set<Serie> series5 = new TreeSet<>(new ComparatorTempoEpisodio());
        series5.addAll(series);

        for (Serie serie: series5 ) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        }




    }
}

    class Serie implements Comparable<Serie>{

        private String nome;
        private String genero;
        private Integer tempoEpisodio;

        public Serie(String nome, String genero, Integer tempoEpisodio) {
            this.nome = nome;
            this.genero = genero;
            this.tempoEpisodio = tempoEpisodio;
        }

        public String getNome() {
            return nome;
        }

        public String getGenero() {
            return genero;
        }

        public Integer getTempoEpisodio() {
            return tempoEpisodio;
        }

        //SOBREESCREVENDO O TO STRING

        @Override
        public String toString() {
            return "Serie{" +
                    "nome='" + nome + '\'' +
                    ", genero='" + genero + '\'' +
                    ", tempoEpisodio=" + tempoEpisodio +
                    '}';
        }


        //CRIAR EQUALS AND HASHCODE QUANDO UTILIZAMOS IMPLEMENTAÇÕES QUE NO NOME TENHAM A PALAVRA HASH
        //CRIANDO AS COMPARAÇÕES QUE DESEJAMOS UTILIZAR

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Serie serie = (Serie) o;
            return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, genero, tempoEpisodio);
        }

        //CRIANDO A COMPARABLE
        @Override
        public int compareTo(Serie serie) {
            //CRITÉRIO DE DESEMPATE, POIS O SET NÃO RETORNA ITENS REPETIDOS
            int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
                if(tempoEpisodio != 0) {
                    return tempoEpisodio;
                }
                return this.getGenero().compareTo(serie.getGenero());
        }
    }

    class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

        //IMPLEMENTANDO O MÉTODO COMPARE
        @Override
        public int compare(Serie s1, Serie s2) {

            //COMPARANDO PELO NOME - SE NOME É DIFERENTE COMPARO POR NOME
            int nome = s1.getNome().compareTo(s2.getNome());
            if(nome != 0){
                return nome;
            }

            //SE O NOME FOR IGUAL , TENTEMOS DESEMPATAR PELO GENERO -
            //SE O GENERO FOR DIFERENTE COMPARAMOS PELO GENERO
            int genero = s1.getGenero().compareTo(s2.getGenero());
                if (genero != 0) {
                    return genero;
                }

                //SE NOME E GENERO FOREM IGUAIS, COMPARAMOS PELO TEMPO DE EPISÓDIO
                 //SE TODOS OS ITENS FOREM IGUAIS, SO APARECE UM DELES NA LISTA
                return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());




        }
    }

    class ComparatorGenero implements Comparator<Serie>{


        @Override
        public int compare(Serie s1, Serie s2) {
            return s1.getGenero().compareToIgnoreCase(s2.getGenero());
        }
    }

    class ComparatorTempoEpisodio implements Comparator<Serie>{

        @Override

        public int compare(Serie s1, Serie s2) {

            int tempoEpisodio = s1.getTempoEpisodio().compareTo(s2.getTempoEpisodio());
            if(tempoEpisodio != 0){
                return tempoEpisodio;
            }

            return s1.getNome().compareToIgnoreCase(s2.getNome());
        }
    }