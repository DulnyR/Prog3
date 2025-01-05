public class Wall implements Damageable{
    private int durability;

    Wall(int durability) {
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void applyDamage(int damagePoints) {
        this.durability -= damagePoints;
    }
}
