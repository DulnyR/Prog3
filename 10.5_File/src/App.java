import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<File> files = new ArrayList<>();

        files.add(new Document("pdf", 10));
        files.add(new Image("jpg", 20));
        files.add(new APK("apk", 30));

        for(File file : files) {
            if(file instanceof Printable) {
                ((Printable) file).print();
            } else {
                System.out.println(file.getClass() + " can not be printed");
            }
            if(file instanceof Shareable) {
                ((Shareable) file).share("WhatsApp");
            } else {
                System.out.println(file.getClass() + " can not be shared");
            } 
        }
    }
}
