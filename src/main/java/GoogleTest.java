import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
public class GoogleTest {
    @BeforeSuite
    public void beforeSuite() {
        Configuration.baseUrl = "https://www.google.com";
        Configuration.browser = "chrome";
    }
//Проверка на количество результатов на странице поиска.
    @Test
    public void googleTest(){
        var title = "Selenide тест";
        open("/");
        $(byName("q")).val("selenide").pressEnter();

        var resultCollection = $$(".LC20lb.MBeuO.DKV0Md");
        resultCollection.shouldHave(size(8));

        $(".LC20lb.MBeuO.DKV0Md", 0).shouldHave(text(title));

    }
}
