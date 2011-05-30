package ch.gnegg;

import java.applet.Applet;

public class Zombie extends Applet {

    public Zombie(){
        super();
        System.out.println("You've dug too deply");
        System.out.println("This is ZombieApplet v0.1");
    }

    public void logToConsole(String in){
        System.out.println("Got from JS: "+in);
    }

}
