package org.academiadecodigo.hexallents.lusozuca;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");


        Game g = new Game(200, 100, 100);
        g.init();

        try {
            g.start();
        }catch (InterruptedException ex){
            System.out.println("some exception");
            ex.printStackTrace();
        }

    }
}
