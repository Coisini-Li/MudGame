package com.Ljh.creature;

import com.Ljh.article.ArticleWeapon;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/6/1 16:18
 * @version: 1.0
 * @modified By:
 */
public class MonsterTaoistMaster extends Monster{
    @Override
    public void attack(ArticleWeapon articleWeapon, Creature enemy) {
        articleWeapon.useArticle(enemy);
    }

}
