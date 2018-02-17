package org.academiadecodigo.hexallents.lusozuca;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");


        Game g = new Game(100, 50, 100);
        //antigo: colunas 192 e linhas 108
        g.init();

        try {
            g.start();
        }catch (InterruptedException ex){
            System.out.println("some exception");
            ex.printStackTrace();
        }

    }
}
