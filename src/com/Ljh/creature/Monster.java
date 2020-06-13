package com.Ljh.creature;


import com.Ljh.article.ArticleWeapon;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:08
 * @version: 1.0
 * @modified By:
 */
public class Monster extends Creature {
    private int LeftExp;//通关后人物可获得的经验值


    @Override
    public void attack(ArticleWeapon articleWeapon, Creature enemy) {
        articleWeapon.useArticle(enemy);
    }

    public int getLeftExp() {
        return LeftExp;
    }

    public void setLeftExp(int leftExp) {
        LeftExp = leftExp;
    }

}
