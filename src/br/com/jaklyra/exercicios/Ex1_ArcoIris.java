package br.com.jaklyra.exercicios;

/*
    Crie um conjunto contendo as cores do arco-iris e:

    1 - Exiba todas as cores uma do lado da outra;
    2 - Mostre a quantidade de cores que o arco iris tem;
    3 = Exiba as cores em ordem alfabetica
    4 - Exiba as cores na ordem inversa da que foram informadas - Crie uma List e passe um para um set - e usar método de reversão
    5 - Exiba todas as cores que começam com a letra V
    6 - Remova todas as cores que nao começam com a letra V - utilizar método
    7 - Limpe o conjunto
    8 - confira se o conjunto está vazio

 */

import java.util.*;


public class Ex1_ArcoIris {

    public static void main(String[] args){

        //CEIANDO O CONJUNTO ARCO-ÍRIS
        Set<String> arcoIris = new LinkedHashSet<>();

        //ADICIONANDO OS ELEMENTOS DO CONJUNTO ARCO-ÍRIS
        arcoIris.add("Vermelho");
        arcoIris.add("Laranja");
        arcoIris.add("Amarelo");
        arcoIris.add("Verde");
        arcoIris.add("Azul");
        arcoIris.add("Anil");
        arcoIris.add("Violeta");

        System.out.println(" ");

        //EXIBINDO AS CORES UMA ABAIXO DA OUTRA
        Set<String> arcoIris2 = new LinkedHashSet<>(arcoIris);
        System.out.println("");
        System.out.println("Cores do Arco-Íris uma abaixo da outra: ");
        System.out.println(" ");

        Iterator<String> iterator = arcoIris2.iterator();

        while (iterator.hasNext()){

           String next = iterator.next();
            System.out.println(next);

        }


        System.out.println("");

        //CONTANDO A QUANTIDADE DE ELEMENTOS DO CONJUNTO
        System.out.println("A quantidade de cores que o Arco-Íris tem : " + arcoIris.size());

        //ORGANIZANDO O CONJUNTO EM ORDEM ALFABÉTICA UTILIZANDO O TREESET QUE RECEBE OS
        //ELEMENTOS E MANTÉM POR DEFAULT A ORDEM NATURAL
        Set<String> arcoIris3 = new TreeSet<>(arcoIris);
        System.out.println(" ");
        System.out.println("O conjunto Arco-Iris em ordem alfabética: ");
        System.out.println(arcoIris3);
        System.out.println(" ");

        //EXIBINDO AS CORES NA ORDEM INVERSA
        List<String> listArcoIris = new ArrayList<>(arcoIris);

        System.out.println("Ordem Informada: ");
        System.out.println(listArcoIris);
        Collections.reverse(listArcoIris);
        System.out.println(" ");

        System.out.println("O conjunto em ordem inversa da informada: ");
        Set<String> arcoIris4 = new LinkedHashSet<>(listArcoIris);

        System.out.println(arcoIris4);
        System.out.println(" ");

        //EXIBINDO TODAS AS CORES QUE COMEÇAM COM A LETRA V
        Set<String> arcoIris5 = new TreeSet<>(arcoIris);

        Iterator<String> iterator1 = arcoIris5.iterator();

        System.out.println("Cores que iniciam com a letra V: ");
        while(iterator1.hasNext()){

            String next = iterator1.next();

            if(next.startsWith("V")){
                System.out.println(next);
            }
        }

            System.out.println("");

        //REMOVA TODAS AS CORES QUE NÃO COMEÇAM COM A LETRA V
        Iterator<String> iterator2 = arcoIris5.iterator();

        System.out.println("Removendo as cores que não começam com a letra V: ");
        System.out.println(" ");

        while (iterator2.hasNext()){

            String next = iterator2.next();

            if(!next.startsWith("V")){
               iterator2.remove();
            }
        }

        System.out.println("Exibindo o conjunto após a exclusão das palavras sem a letra V ");
        System.out.println(arcoIris5);


        //LIMPE O CONJUNTO
        System.out.println("");
        System.out.println("Limpando o conjunto: ");
        arcoIris.clear();
        System.out.println(arcoIris);
        System.out.println("");

        //CONFIRA SE O CONJUNTO ESTÁ VAZIO
        System.out.println("O conjunto Arco-Íris está vazio? " + arcoIris.isEmpty());



    }
}
