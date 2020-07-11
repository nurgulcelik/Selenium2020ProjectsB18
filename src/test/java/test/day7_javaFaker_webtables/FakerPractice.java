package test.day7_javaFaker_webtables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractice {
    @Test
    public void faker_test(){

        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName();
        System.out.println("Name: "+name);// Emory
        String lastName = faker.name().lastName(); // Barton
        System.out.println("First name: "+firstName+", Last name: "+lastName);
        String streetAddress = faker.address().streetAddress();
        // 60018 Sawayn Brooks Suite 449
        System.out.println("Street address: "+streetAddress);
        String gameOfThrones= faker.gameOfThrones().quote();
        System.out.println(gameOfThrones);
        String harrypotter = faker.harryPotter().quote();
        System.out.println(harrypotter);
    }
}
