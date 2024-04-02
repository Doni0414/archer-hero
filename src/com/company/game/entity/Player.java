package com.company.game.entity;

public class Player extends Entity {
    //TODO BOW
    public Player(String name, String path, int hp, int maxHP, String idlePath, String preAttackPath, String attackPath, double desiredWidth, double desiredHeight) {
        super(name, path, hp, maxHP, idlePath, preAttackPath, attackPath, desiredWidth, desiredHeight);
    }
}
