public class App {
    public static void main(String[] args) throws Exception {
        Person john = new Person("John", 1.80, 73);
        Person bob = new Person("Bob", 1.92, 97);
        Person matt = new Person("Matt", 1.72, 122);

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
            double bmi = person.getBMI();
            if (bmi > 0) {
                System.out.println(person.getName() + "'s BMI is " + person.getBMI());
            } else {
                System.out.println("Not enough data to compute BMI.");
            }
            
        }

        System.out.println("The tallest person is " + tallest.getName() + ". The heaviest person is " + heaviest.getName());
    }
}
