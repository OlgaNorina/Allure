import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryNewDateTest {
    private Faker faker;
    private

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    @Test
    void shouldSubmitRequest() {

        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=city] input").setValue(faker.address().city());
        form.$(".input__icon").click();
        $$("td").find(exactText("21")).click();
        form.$("[data-test-id=name] input").setValue(faker.name().lastName()).setValue(" ").setValue(faker.name().firstName());
        form.$("[data-test-id=phone] input").setValue("+7").setValue(faker.phoneNumber().cellPhone());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();

        form.$(".input__icon").click();
        $$("td").find(exactText("23")).click();
        form.$(".button").click();
        $$(".button").find(exactText("Перепланировать")).click();
    }
}
