package com.Ljh.creature;


import com.Ljh.article.ArticleWeapon;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/6/13 11:17
 * @version: 1.0
 * @modified By:
 */
public class Eggshell extends Monster{

    public void Random(){
        final double d = Math.random();
        final int i = (int)(d*100);
        System.out.println("欢迎来到九州大地，此地你将会随机获取或未获取彩蛋");
        if (i%3 == 0){
            this.setHp(0);
            System.out.println("你获取彩蛋，成功升级！");
        }
        else {
            this.setLeftExp(0);
            this.setHp(0);
            System.out.println("你未成功获取彩蛋!");
        }
        System.out.print("出口有:  ");
        System.out.print(this.getCurrentRoom().getExitDesc()+"  桃园冢");
        System.out.println();
    }

    @Override
    public void attack(ArticleWeapon articleWeapon, Creature enemy) {
        super.attack(articleWeapon, enemy);
    }
}
