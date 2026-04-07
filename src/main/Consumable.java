package main;

public class Consumable extends Loot {
    private int restoreAmount;

    public Consumable(String name, String rarity, int restoreAmount) {
        super(name, rarity);
        this.restoreAmount = restoreAmount;
    }

    @Override
    public String getEffectDescription() {
        return String.format("The %s is a %s quality consumable that has %d uses left!", getName(), getRarity(), restoreAmount);
    }

    @Override
    public String asCsvRecord() {
        return String.format("Consumable,%s,%s,%d", getName(), getRarity(), restoreAmount);
    }
}
