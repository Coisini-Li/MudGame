package com.Ljh;

import com.Ljh.creature.Monster;
import java.util.HashMap;



/**
 * @description:
 * @author: LiJiaHao
 * @date: Created in 2020/5/30 15:25
 * @version: 1.0
 * @modified By:
 */
public class Room {
    private String id;
    private String description;
    private Monster monster;

    private HashMap<String, Room> roomExits = new HashMap<>();

    public Room() {
    }

    public void setExits(String dir, Room room){
        roomExits.put(dir, room);
    }

    public Room(String id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getExitDesc(){
        StringBuffer sb = new StringBuffer();
        for (String dir : roomExits.keySet()){
            sb.append(dir);
            sb.append(' ');
        }
        return sb.toString();
    }

    public Room getExit(String direction){
        return roomExits.get(direction);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public HashMap<String, Room> getRoomExits() {
        return roomExits;
    }

    public void setRoomExits(HashMap<String, Room> roomExits) {
        this.roomExits = roomExits;
    }
}
