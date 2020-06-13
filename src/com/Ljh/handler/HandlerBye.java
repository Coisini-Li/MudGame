package com.Ljh.handler;

import com.Ljh.Sense;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/6/1 20:43
 * @version: 1.0
 * @modified By:
 */
public class HandlerBye extends Handler{
    public HandlerBye(Sense sense){
        super(sense);
    }

    @Override
    public void doCmd(String word) {

    }

    @Override
    public boolean isBye() {
        return true;
    }
}
