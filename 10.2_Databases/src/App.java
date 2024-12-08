import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<DatabaseService> databaseServices = new ArrayList<>();

        databaseServices.add(new MySQLDatabaseService());
        databaseServices.add(new PostgreSQLDatabseService());

        for(DatabaseService db : databaseServices) {
            db.connect();
        }
    }
}
