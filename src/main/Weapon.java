package main;

public class Weapon extends Loot {
    
    private int damage;

    public Weapon(String name, String rarity, int damage) {
        super(name, rarity);
        this.damage = damage;
    }

    @Override
    public String getEffectDescription() {
        return String.format("This %s %s that can deal a massive %d points of damage!", getRarity(), getName(), damage);
    }

    @Override
    public String asCsvRecord() {
        return String.format("Weapon,%s,%s,%d", getName(), getRarity(), damage);
    }
}
