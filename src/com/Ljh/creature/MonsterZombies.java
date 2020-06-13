package com.Ljh.creature;

import com.Ljh.article.ArticleWeapon;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:27
 * @version: 1.0
 * @modified By:
 */
public class MonsterZombies extends Monster{
    @Override
    public void attack(ArticleWeapon articleWeapon, Creature enemy) {
        articleWeapon.useArticle(enemy);
    }


}
