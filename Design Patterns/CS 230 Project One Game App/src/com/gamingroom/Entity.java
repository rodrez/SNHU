package com.gamingroom;

/**
 *  Entity class 
 * acts as a super class for Game, Player, and Team
 */
public abstract class Entity {

    long id;
    String name;

    /**
     * Entity constructor
     *  
     * @param id
     * @param name
     * @param team
     * 
     */
    
    public Entity() {}

    /**
     * Entity constructor
     */
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Entity getter
     *  
     * @return id
     *  
     */
    public long getId() {
        return id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

   
