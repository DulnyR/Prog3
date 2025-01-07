public class Document extends File implements Printable, Shareable {
    Document(String name, int size) {
        super(name, size);
    }

    public void print() {
        System.out.println("The document is being printed.");
    }

    public void share(String platform) {
        System.out.println("The document has been shared to " + platform + ".");
    }
}
