/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_8;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author riza
 */
public class TimerAgent extends Agent {

    private int timeSecond;
    private String message;

    private TimerGui myGui;

    @Override
    protected void setup() {
        myGui = new TimerGui(this);
        myGui.showGui();
    }

    public void setTimer(int timeSecond, String message) {
        this.timeSecond = timeSecond;
        this.message = message;
        
        
        addBehaviour(new TickerBehaviour(this, 1000) {
            int deltaTime = timeSecond;
            @Override
            protected void onTick() {
                deltaTime--;
                System.out.print(deltaTime+" ");
                if(deltaTime==0){
                    System.out.println("");
                    System.out.println(message);
                    doDelete();
                }
            }
        });
        
    }

}
