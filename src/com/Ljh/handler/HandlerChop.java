package com.Ljh.handler;

import com.Ljh.Room;
import com.Ljh.Sense;
import com.Ljh.creature.Monster;


/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/6/2 14:14
 * @version: 1.0
 * @modified By:
 */
public class HandlerChop extends Handler{
    public HandlerChop(Sense sense) {
        super(sense);
    }

    @Override
    public void doCmd(String word) {
        boolean flag = true;
        for (Monster monsters: sense.getMonsterSet().getMonsters()
        ){
            if (word.equals(monsters.getId()) && monsters.getCurrentRoom().getId().equals(sense.getPerson().getCurrentRoom().getId())){

                if (monsters.getHp()>0){
                    monsters.attack(monsters.getCurrentWeapon(),sense.getPerson());
                    sense.getPerson().DefenseAddblood(sense.getPerson().getCurrentDefense().getEffectValue());
                }

                sense.getPerson().attack(sense.getPerson().getCurrentWeapon(),monsters);//人攻击



                System.out.println(monsters.getDescription()+" 对你使用了 "+monsters.getCurrentWeapon().getDescription()+" 造成了 "
                +(-monsters.getCurrentWeapon().getEffectValue()-sense.getPerson().getCurrentDefense().getEffectValue())+" 点伤害！");

                System.out.println("你使用 "+sense.getPerson().getCurrentWeapon().getDescription()+" 对 "+monsters.getDescription()+" 造成了 "
                +-sense.getPerson().getCurrentWeapon().getEffectValue()+" 点伤害！ ");

                flag = false;
            }
        }
        if (flag)
            System.out.println("没有此敌人，请攻击正确的敌人！否则你将会被敌人强力攻击！");
        else
            sense.getPerson().MpUpdate();


        sense.showPromptAndProcess();

    }

}
