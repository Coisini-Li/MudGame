package com.Ljh.article;

import com.Ljh.creature.Creature;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:24
 * @version: 1.0
 * @modified By:
 */
public class ArticleAttack extends ArticleWeapon{
    @Override
    public void useArticle(Creature enemyCreature) {
        enemyCreature.setHp(enemyCreature.getHp()+this.getEffectValue());
    }

    public ArticleAttack() {
    }

    public ArticleAttack(String id, String description, int effectValue) {
        super(id, description, effectValue);
    }
}
