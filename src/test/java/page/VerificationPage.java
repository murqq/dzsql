package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private SelenideElement codeField =$("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");
    private SelenideElement blockedUser = $("");

    public VerificationPage(){
    }

    public DashboardPage validVerify(String verificationCode){
        codeField.shouldBe(visible);
        codeField.setValue(verificationCode);
        verifyButton.click();
        return new DashboardPage();
    }
    public void errorVerify(String verificationCode){
        codeField.shouldBe(visible);
        codeField.setValue(verificationCode);
        verifyButton.click();
        error();
    }
    public void error(){
        errorNotification.shouldBe(visible);
        errorNotification.$$(" .notification_content").findBy(exactText("Ошибка! Неверно указан логин или пароль"));
    }
}
