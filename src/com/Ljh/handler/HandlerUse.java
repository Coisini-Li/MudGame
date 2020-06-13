package com.Ljh.handler;

import com.Ljh.Sense;
import com.Ljh.creature.Monster;


/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/6/8 11:32
 * @version: 1.0
 * @modified By:
 */
public class HandlerUse extends Handler{
    public HandlerUse(Sense sense) {
        super(sense);
    }


    @Override
    public void doCmd(String word) {
        boolean flag = true;
        boolean attackflag = true;
        boolean Mpflag = true;
        Monster monster;
        monster = sense.getMonsterSet().selectByRoomId(sense.getPerson().getCurrentRoom().getId());
        int damage = 0;
        if (word.equals("Q")){
            attackflag = true;
            damage = sense.getPerson().getDamage()/2 - sense.getPerson().getCurrentWeapon().getEffectValue();

            if (sense.getPerson().getMp() >= 30){
                System.out.println(monster.getDescription()+" 对你使用了 "+monster.getCurrentWeapon().getDescription()+" 造成了 "
                        +(-monster.getCurrentWeapon().getEffectValue()-sense.getPerson().getCurrentDefense().getEffectValue())+" 点伤害！");

                System.out.println("你使用了 "+sense.getSkillSet().select2("Q").getValue()+" 对 "+monster.getDescription()
                        +" 造成了 "+damage+" 伤害 ");

                sense.getPerson().setMp(sense.getPerson().getMp()-30);
            }
            else{
                System.out.println("法力值不够，请重新输入指令");
                Mpflag = false;
            }
        }
        else if (word.equals("W")){
            damage = sense.getPerson().getDamage()/2;
            attackflag = false;
            if (sense.getPerson().getMp() >= 40){
                System.out.println("你使用了 "+sense.getSkillSet().select2("W").getValue()+" 眩晕了 "+monster.getDescription()
                        +" 此回合它无法攻击！");

                System.out.println("你使用了 "+sense.getSkillSet().select2("W").getValue()+" 对 "+monster.getDescription()
                        +" 造成了 "+damage+" 伤害 ");

                sense.getPerson().setMp(sense.getPerson().getMp()-40);
            }
            else{
                System.out.println("法力值不够，请重新输入指令");
                Mpflag = false;

            }
        }
        else if (word.equals("R")){
            damage = sense.getPerson().getDamage()*2 - sense.getPerson().getCurrentWeapon().getEffectValue();
            attackflag = false;
            if (sense.getPerson().getMp() >= 80){
                System.out.println("你使用了 "+sense.getSkillSet().select2("R").getValue()+" 闪避了 "+monster.getDescription()
                        +" 的 "+monster.getCurrentWeapon().getDescription());

                System.out.println("你使用了 "+sense.getSkillSet().select2("R").getValue()+" 对 "+monster.getDescription()
                        +" 造成了 "+damage+" 伤害 ");

                sense.getPerson().setMp(sense.getPerson().getMp()-80);
            }
            else{
                System.out.println("法力值不够，请重新输入指令");
                Mpflag = false;
            }
        }
        else if (word.equals("E")){
            attackflag = true;
            damage = sense.getPerson().getDamage();
            if (sense.getPerson().getMp() >= 40){
                sense.getPerson().DefenseAddblood(-monster.getCurrentWeapon().getEffectValue()/2);

                System.out.println(monster.getDescription()+" 对你使用了 "+monster.getCurrentWeapon().getDescription()+" 造成了 "
                        +(-monster.getCurrentWeapon().getEffectValue()/2-sense.getPerson().getCurrentDefense().getEffectValue())+" 点伤害！");

                System.out.println("你使用了 "+sense.getSkillSet().select2("E").getValue()+" 对 "+monster.getDescription()
                        +" 造成了 "+damage+" 伤害 ");

                sense.getPerson().setMp(sense.getPerson().getMp()-40);

            }
            else{
                System.out.println("法力值不够，请重新输入指令");
                Mpflag = false;
            }

        }

        if (sense.getSkillSet().select(word)){
            flag = false;
            if (Mpflag && (attackflag && monster.getHp()>0)){
                monster.attack(monster.getCurrentWeapon(),sense.getPerson());
                sense.getPerson().DefenseAddblood(sense.getPerson().getCurrentDefense().getEffectValue());
                sense.getPerson().MpUpdate();
            }
            if (Mpflag)
                sense.getPerson().UseSkill(sense.getMonsterSet().selectByRoomId(sense.getPerson().getCurrentRoom().getId()),damage);
        }
        if (flag)
            System.out.println("输入指令错误！请重新输入！");

        sense.showPromptAndProcess();

    }
}
