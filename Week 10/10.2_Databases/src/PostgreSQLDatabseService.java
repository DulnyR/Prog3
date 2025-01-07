public class PostgreSQLDatabseService extends DatabaseService{

    @Override
    public void connect() {
        super.connect();
        System.out.println("Connected to " + this.getClass().getName());
    }
}
