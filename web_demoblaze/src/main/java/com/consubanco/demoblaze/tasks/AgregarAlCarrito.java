package com.consubanco.demoblaze.tasks;

import com.consubanco.demoblaze.userinterfaces.ItemPage;
import com.consubanco.demoblaze.userinterfaces.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AgregarAlCarrito implements Task {
    private String producto;

    public AgregarAlCarrito(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ProductsPage.ITEM.of(producto)),
                Ensure.that(ItemPage.LBL_PRODUCT).hasTextContent(producto),
                Ensure.that(ItemPage.LBL_PRODUCT_DESCRIPTION).isDisplayed(),
                Click.on(ItemPage.BTN_ADD_TO_CART),
                WaitUntil.the(ExpectedConditions.alertIsPresent()).forNoMoreThan(Duration.ofSeconds(3)));
    }

    public static AgregarAlCarrito elProducto(String producto){
        return Tasks.instrumented(AgregarAlCarrito.class, producto);
    }
}
