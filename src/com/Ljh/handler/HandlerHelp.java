package com.Ljh.handler;

import com.Ljh.Sense;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/6/1 20:53
 * @version: 1.0
 * @modified By:
 */
public class HandlerHelp extends Handler{

    public HandlerHelp(Sense sense) {
        super(sense);
    }

    @Override
    public void doCmd(String word) {
        System.out.println("新手玩家必看攻略如下:");
        System.out.println("你可以做的命令有: bye help chop use");
        System.out.println("如：\tchop zom(enemy) / bye");
        System.out.println("技能有：");
        System.out.println(sense.getSkillSet().getSkills().entrySet());

        System.out.println("Q:造成人物攻击力的一半和武器攻击的总伤害，消耗30法力值");
        System.out.println("W:造成人物攻击力的一半，并眩晕敌人，使之无法攻击，消耗40法力值");
        System.out.println("E:造成人物攻击并格挡怪物攻击力一半的伤害，消耗40法力值");
        System.out.println("R:造成2倍人物攻击和武器攻击的总伤害，并闪避此次敌人攻击，消耗80法力值");

        System.out.println("如：\tuse Q(技能id)(对当前场景的敌人造成伤害)");
        System.out.println("当你斩杀当前场景的敌人后，可前往下一场景！并且可以使用 'go' 命令");
        System.out.println("如：\tgo room(房间id)");
        System.out.println("玩家可进行升级,每100经验值升一级,每级所需经验值上升20点,升级后最大法力值增加10点," +
                "最大攻击力上升10点,武器攻击力上升10点,最大生命值上升20点,且生命值回满，每回合玩家法力值回复10点");

    }
}
