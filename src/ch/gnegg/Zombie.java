package ch.gnegg;

import netscape.javascript.JSObject;

import java.applet.Applet;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class Zombie extends Applet {
    private String caller = "caller";

    public Zombie(){
        super();
        System.out.println("You've dug too deply");
        System.out.println("BRRRRAAAAIIINNNNNSSSSSS! v0.3");
    }

    public void logToConsole(String in){
        System.out.println("Got from JS: "+in);
    }

    public void init(){
        String caller = this.getParameter("caller");
        if (caller != null){
            this.caller = caller;
        }
    }

    public void start(){
        String notify = this.getParameter("zombie_resurrected");
        if (notify != null){
            JSObject win = JSObject.getWindow(this);
            win.call(notify, null);
        }
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
        win.call(this.caller, new Object[]{thisobj, arg, cb});
    }

}
