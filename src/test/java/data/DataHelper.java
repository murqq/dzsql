package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DataHelper {
    private DataHelper() {
    }

    static Faker faker = new Faker();

    public static RegisteredUser getRegisteredUser() {
        return new RegisteredUser("vasya", "qwerty123");
    }
    public static RegisteredUser getRegisteredUserWithRandomPassword(){
        return new RegisteredUser("vasya", getRandomPassword());
    }


    public static String getRandomLogin() {
        String login = String.valueOf(faker.name().firstName());
        return login;
    }

    public static String getRandomPassword() {
        String password = String.valueOf(faker.internet().password());
        return password;
    }

    public static RegisteredUser getRandomUser() {
        return new RegisteredUser(getRandomLogin(), getRandomPassword());
    }

    public static VerificationCode getRandomVerificationCode() {
        return new VerificationCode(faker.numerify("####"));
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class InfoCard {
        String numberCard;
        String testId;
    }

    @Value
    public static class RegisteredUser {
        String login;
        String password;
    }
}
