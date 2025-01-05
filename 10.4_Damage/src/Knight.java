public class Knight extends Character{
    Knight(int health) {
        super(health);
    }

    public void applyDamage(int damagePoints) {
        int smallerDamage = (int) (damagePoints * 0.9);
        super.applyDamage(smallerDamage);
    }
}
