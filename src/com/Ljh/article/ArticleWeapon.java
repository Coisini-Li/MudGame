package com.Ljh.article;

import com.Ljh.creature.Creature;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:58
 * @version: 1.0
 * @modified By:
 */
public abstract class ArticleWeapon extends Article{

    public void useArticle(Creature enemyCreature){
        enemyCreature.setHp(enemyCreature.getHp()+this.getEffectValue());
    }

    public ArticleWeapon() {
    }

    public ArticleWeapon(String id, String description, int effectValue) {
        super(id, description, effectValue);
    }
}
