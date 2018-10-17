/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author riza
 */
public class MyClient<V extends Object, T extends Object> {

    private final String host;
    private final int port;

    public MyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void post(V obj, ClientCallback callback) throws ClassNotFoundException{

        try {
            Socket daytime = new Socket(host, port);
            daytime.setSoTimeout(3000);
            OutputStream out = daytime.getOutputStream();
            
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(obj);
            out.flush();
            out.close();
            daytime.close();
            callback.onResponse(getResponse());
        } catch (IOException ex) {
            System.out.println("error");
            callback.onError(ex.getMessage());
        }

    }

    public T getResponse() throws IOException, ClassNotFoundException {

        T result = null;
        try (Socket daytime = new Socket(host, port)) {
            System.out.println("Prepare to receive");
            daytime.setSoTimeout(3000);
            
            ObjectInputStream ois = new ObjectInputStream(daytime.getInputStream());
            
            result = (T) ois.readObject();
        }
        return result;
    }

}
