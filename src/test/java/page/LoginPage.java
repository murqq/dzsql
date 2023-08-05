package page;
import data.DataHelper;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private SelenideElement errorNotification = $("[data-test-id=error-notification]");
    public VerificationPage validLogin(DataHelper.RegisteredUser user){
        $("[data-test-id=login] input").setValue(user.getLogin());
        $("[data-test-id=password] input").setValue(user.getPassword());
        $("[data-test-id=action-login]").click();
        return new VerificationPage();
    }
    public void errorLogin(){
        errorNotification.shouldBe(visible);
        errorNotification.$$(" .notification_content").findBy(exactText("Ошибка! Неверно указан логин или пароль"));
    }
}