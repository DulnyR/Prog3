public class App {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Person bob = new Person("Bob", 192, 97);
        Person matt = new Person("Matt", 172, 122);

        Person[] people = {john, bob, matt};
        Person tallest = people[0];
        Person heaviest = people[0];

        for (Person person : people) {
            if(person.getHeight() > tallest.getHeight()) {
                tallest = person;
            }
            if(person.getWeight() > heaviest.getWeight()) {
                heaviest = person;
            }
        }

        System.out.println("The tallest person is " + tallest.getName() + ". The heaviest person is " + heaviest.getName());
    }
}
