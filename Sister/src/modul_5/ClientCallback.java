/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_5;

/**
 *
 * @author riza
 * @param <T> response
 */
public interface ClientCallback<T extends Object> {

    void onResponse(T data);

    void onError(String msg);
    
}
