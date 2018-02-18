package org.academiadecodigo.hexallents.lusozuca;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");


        //Game g = new Game(200, 100, 50);
        //g.init();

        try {
            Game g = new Game(200, 100, 50);
            g.init();
            g.start();
        }catch (InterruptedException ex){
            System.out.println("some exception");
            ex.printStackTrace();
        }

    }
}