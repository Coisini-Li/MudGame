package com.Ljh.creature;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/6/8 10:52
 * @version: 1.0
 * @modified By:
 */
public class SkillSet {
    private HashMap<String,String> skills = new HashMap<String, String>();

    public void inset(String id,String descripiton){
        skills.put(id,descripiton);
    }

    public boolean select(String id){
        Map.Entry<String,String> entry = null;
        for (Map.Entry<String,String> item:skills.entrySet()){
            if (item.getKey().equals(id)){
                entry = item;
                break;
            }
        }
        return entry != null;
    }

    public Map.Entry<String,String> select2(String id){
        Map.Entry<String,String> entry = null;
        for (Map.Entry<String,String> item:skills.entrySet()){
            if (item.getKey().equals(id)){
                entry = item;
                break;
            }
        }
        return entry;
    }


    public HashMap<String, String> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<String, String> skills) {
        this.skills = skills;
    }
}
