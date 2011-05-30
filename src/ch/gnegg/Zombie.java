package ch.gnegg;

import netscape.javascript.JSObject;

import java.applet.Applet;
import java.security.AccessController;
import java.security.PrivilegedAction;

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
    }

    public void dig(String f, JSObject t, JSObject c){
        final String file = f;
        final JSObject thisobj = t;
        final JSObject cb = c;
        final Zombie self = this;
        AccessController.doPrivileged(
                new PrivilegedAction<Object>() {
                    public Object run() {
                        FileReader fr = new FileReader(new StringAvailable(){
                            public void stringRetrieved(String s){
                                self.callback(thisobj, cb, s);
                            }
                        });
                        fr.read(file);
                        return null;
                    }
                }
        );

    }

    private void callback(JSObject thisobj, JSObject cb, Object arg){
        JSObject win = JSObject.getWindow(this);
        win.call("caller", new Object[]{thisobj, arg, cb});
    }

}
