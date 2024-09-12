package tests.local;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;


public class SearchTests extends TestBase {

    @Test
    void onboardingFirstScreenTest() {
        step("First step onboarding", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia"));
            $(id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("found the following on your device:"));
        });
    }


    @Test
    void onboardingSecondScreenTest() {
        step("First step onboarding", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Second step onboarding", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
            $(id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed."));
        });
    }

    @Test
    void onboardingThirdScreenTest() {
        step("First step onboarding", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Second step onboarding", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Third step onboarding", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
            $(id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("You can make reading lists from articles you want to read later"));
        });
    }

    @Test
    void onboardingFourthScreenTest() {
        step("First step onboarding", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Second step onboarding", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Third step onboarding", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Fourth step onboarding", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Data & Privacy"));
            $(id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("We believe that you should not have to provide personal information to participate in the free knowledge movement. Usage data collected for this app is anonymous. Learn more about our privacy policy and terms of use."));
        });
    }


    @Test
    void successfulSearchTest() {
        step("Skip onboarding screen", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
            //back();
        });
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
        });
        step("Verify content found", () -> {
            $$(id("org.wikipedia.alpha:id/search_results_list")).shouldHave(sizeGreaterThan(0));
        });
    }
}
