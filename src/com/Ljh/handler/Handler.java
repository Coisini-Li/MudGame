package com.Ljh.handler;

import com.Ljh.Sense;
import com.Ljh.creature.Monster;



/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/6/1 20:41
 * @version: 1.0
 * @modified By:
 */
public class Handler {
    protected Sense sense;

    public Handler(Sense sense){
        this.sense = sense;
    }

    public void doCmd(String word){
    }

    public boolean isBye(){
        return false;
    }
}
