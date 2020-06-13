package com.Ljh.article;

import com.Ljh.Sense;
import com.Ljh.creature.Creature;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:56
 * @version: 1.0
 * @modified By:
 */
public class BareHandedAttack extends ArticleAttack{

    @Override
    public void useArticle(Creature enemyCreature) {
        enemyCreature.setHp(enemyCreature.getHp()+this.getEffectValue());
    }

    public BareHandedAttack() {
    }

    public BareHandedAttack(String id, String description, int effectValue) {
        super(id, description, effectValue);
    }
}
