package br.com.jaklyra.set;


import java.util.*;

public class ExemploSet {

    public static void main(String[] args) {


        //Dada uma lista com 7 notas de um aluno [ 7,8.5, 9.3, 5,7,0, 3.6], faça:

        //Set notas = new HashSet(); //antes do java 5
        //Set<Double> notas = new HashSet<>(); //Generics (jdk5) - diamont operator ( jdk7)
        //HashSet<Double> notas = new HashSet<>();
        //Set<Double> notas = new HashSet<> (Arrays, asList(7d,8.5, 9.3, 5d,7d,0d, 3.6));



        /*
        //Set<Double> notas = Set.of(7d,8.5, 9.3, 5d,7d,0d, 3.6);
        //notas.add(10d);
        //notas.remove(5d);
        //System.out.println(notas);
         */


        System.out.println("Crie um conjunto e adicione as notas: ");

        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString());
        System.out.println(" ");


        //O MÉTODO SET NÃO PERMITE FAZER A BUSCA POR POSIÇÃO
        //System.out.println("Exiba a posição da nota 5.0: ");


        //O MÉTODO SET NÃO PERMITE FAZER A BUSCA POR POSIÇÃO
        //System.out.println("Adicione na lista a nota 8.0 na posição 4: ");

        //O MÉTODO SET NÃO PERMITE FAZER A BUSCA POR POSIÇÃO PARA ALTERAR O ELEMENTO
        //System.out.println("Substitua a nota 5.0 pela nota 6.0: ");


        //MÉTODO PARA VERIFICAR SE O ELEMENTO ESTÁ NO CONJUNTO
        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));
        System.out.println(" ");

        //NÃO É POSSIVEL EFETUAR A BUSCA, POIS O SET NÃO POSSUI O MÉTODO GET PARA VERIFICAR OS ELEMENTOS
        System.out.println("Exiba a terceira nota adicionada ");
        System.out.println(" ");

        //NÃO EXISTE MÉTODO NATIVO - UTILIZAMOS O COLLECTIONS PARA VERIFICAR A LISTA E RETORNAR O MENOR VALOR
        //UTILIZANDO O MÉTODO COMPARABLE - - MESMA FORMA QUE A LIST
        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.println(" ");


        //NÃO EXISTE MÉTODO NATIVO - UTILIZAMOS O COLLECTIONS PARA VERIFICAR A LISTA E RETORNAR O MENOR VALOR
        //UTILIZANDO O MÉTODO COMPARABLE - MESMA FORMA QUE A LIST
        System.out.println("Exiba a maior nota: " + Collections.max(notas));
        System.out.println(" ");


        //NÃO EXISTE MÉTODO NATIVO - PODEMOS UTILIZAR O MÉTODO ITERATOR PARA ITERAR OS ELEMENTOS DA CONJUNTO
        //ITERANDO OS ELEMENTOS DA COLEÇÃO
        System.out.println("Exiba a soma dos valores: ");

        Iterator<Double> iterator = notas.iterator();

        Double soma = 0d;

        while(iterator.hasNext()){

            Double next = iterator.next();
            soma+=next;
        }

        System.out.println("A soma das notas: " + soma);
        System.out.println(" ");

        //MÉTODO SIZE UTILIZADO PARA INFORMAR O TAMANHO DO CONJUNTO- RETORNA UM INTEIRO QUE É A QUANTIDADE DE ELEMENTOS DO CONJUNTO
        System.out.println("Exiba a média das notas: " + (soma / notas.size()));
        System.out.println(" ");

        //REMOVENDO ITENS DO CONJUNTO UTILIZANDO O REMOVE - INFORMANDO O ELEMENTO QUE DESEJA EXCLUIR (O)
        System.out.println("Remova a nota 0");
        notas.remove(0d);
        System.out.println(notas);
        System.out.println(" ");

        //NÃO É POSSÍVEL EXCLUIR INFORMANDO O ELEMENTO PELO ÍNDICE (I)
        //System.out.println("Remova a nota na posição 0: ");
        //System.out.println(" ");


        System.out.println("Remova as notas menores que 7 e exiba a lista: ");

        Iterator<Double> iterator1 = notas.iterator();

        while (iterator1.hasNext()){

            Double next = iterator1.next();

            if(next < 7){
                iterator1.remove();
            }
        }

        System.out.println(notas);
        System.out.println(" ");

        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        Set<Double> notas2 = new LinkedHashSet<>();

        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);

        System.out.println(notas2);

        //CRIANDO UMA COLEÇÃO TREESET ORDENADA - SÓ É POSSÍVEL CRIAR POIS A CLASSE POSSUI O COMPARABLE
        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);
        System.out.println(" ");

        System.out.println("Apague todo o conjunto");
        notas.clear();
        System.out.println(" ");

        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("Confira se o conjunto 2 está vazio: " + notas2.isEmpty());
        System.out.println("Confira se o conjunto 3 está vazio: " + notas3.isEmpty());

    }

}