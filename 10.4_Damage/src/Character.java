public class Character implements Damageable{
    protected int health;

    Character(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void applyDamage(int damagePoints) {
        this.health -= damagePoints;  
    }
}
