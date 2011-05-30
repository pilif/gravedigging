package ch.gnegg;

import netscape.javascript.JSObject;

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

    public void callbackTest(JSObject thisobj, JSObject func){
        JSObject win = JSObject.getWindow(this);
        System.out.println("About to call in using window.caller");
        win.call("caller", new Object[]{thisobj, func});
    }

}
