package com.Ljh.article;

import com.Ljh.creature.Creature;

/**
 * @description:  盔甲
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:36
 * @version: 1.0
 * @modified By:
 */
public class ArmorDefense extends ArticleDefense{
    public ArmorDefense() {
    }

    public ArmorDefense(String id, String description, int effectValue) {
        super(id, description, effectValue);
    }

    @Override
    public void useArticle(Creature enemyCreature) {
        super.useArticle(enemyCreature);
    }
}
