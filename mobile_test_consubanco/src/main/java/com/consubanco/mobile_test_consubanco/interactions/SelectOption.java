package com.consubanco.mobile_test_consubanco.interactions;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

import static net.serenitybdd.core.Serenity.getDriver;

public class SelectOption implements Interaction {
    private String value;
    private Target target;

    public SelectOption(String value, Target target) {
        this.value = value;
        this.target = target;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        AndroidDriver driver = ((AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver());
        actor.attemptsTo(
                Enter.theValue(value).into(target)
                );
        actor.attemptsTo(Click.on(target));
        Rectangle rect = target.resolveFor(actor).getRect();
        int bottomLeftX = rect.getX() + (rect.getWidth()/2);
        int bottomLeftY = rect.getY() + rect.getHeight() + (rect.getHeight()/2);
        tap(driver, bottomLeftX + (rect.getHeight()/2), bottomLeftY);
    }

    public static SelectOption withValueAndTarget(String value, Target target) {
        return Tasks.instrumented(SelectOption.class, value, target);
    }

    private void tap(AndroidDriver driver, int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(150)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }
}
