package com.Ljh.creature;

import com.Ljh.article.ArticleWeapon;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/6/1 13:21
 * @version: 1.0
 * @modified By:
 */
public class MonsterPuppet extends Monster{
    @Override
    public void attack(ArticleWeapon articleWeapon, Creature enemy) {
        articleWeapon.useArticle(enemy);
    }

}
