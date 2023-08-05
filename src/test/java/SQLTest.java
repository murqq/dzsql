import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import page.DashboardPage;
import page.LoginPage;
import page.VerificationPage;
import data.DataHelper;
import data.SQLHelper;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;


import com.codeborne.selenide.SelenideElement;

public class SQLTest {


    @AfterAll
    static void clearBase(){
        SQLHelper.cleareDB();
    }

    @Test
    void SuccessLoginUser() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var user = DataHelper.getRegisteredUser();
        var verificationPage = loginPage.validLogin(user);
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }

    @Test
    void errorNotificationIfLoginWithRandomLoginMissingFromBase(){
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var user = DataHelper.getRandomUser();
        loginPage.validLogin(user);
        loginPage.errorLogin();
    }

    @Test
    void errorVerificationCodeWithSuccessLoginUser() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var user = DataHelper.getRegisteredUser();
        var verificationPage = loginPage.validLogin(user);
        var verificationCode = DataHelper.getRandomVerificationCode();
        verificationPage.errorVerify(verificationCode.getCode());
    }
}
