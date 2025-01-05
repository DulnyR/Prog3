public class Image extends File implements Shareable {

    Image(String name, int size) {
        super(name, size);
    }

    public void share(String platform) {
        System.out.println("The image has been shared to " + platform + ".");
    }
}
