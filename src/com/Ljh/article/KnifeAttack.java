package com.Ljh.article;

import com.Ljh.creature.Creature;

/**
 * @description:  刀
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:35
 * @version: 1.0
 * @modified By:
 */
public class KnifeAttack extends ArticleAttack{
    @Override
    public void useArticle(Creature enemyCreature) {
        enemyCreature.setHp(enemyCreature.getHp()+this.getEffectValue());
    }

    public KnifeAttack() {
    }

    public KnifeAttack(String id, String description, int effectValue) {
        super(id, description, effectValue);
    }
}
