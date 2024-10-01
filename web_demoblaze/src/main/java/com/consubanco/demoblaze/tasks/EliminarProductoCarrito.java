package com.consubanco.demoblaze.tasks;

import com.consubanco.demoblaze.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

public class EliminarProductoCarrito implements Task {
    private String producto;

    public EliminarProductoCarrito(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CartPage.BTN_DELETE_ITEM.of(producto)));
        BrowseTheWeb.as(actor).getDriver().navigate().refresh();
        actor.attemptsTo(
                WaitUntil.the(CartPage.ITEM.of(producto), WebElementStateMatchers.isNotVisible()).forNoMoreThan(Duration.ofSeconds(3))
                );
    }

    public static EliminarProductoCarrito conNombre(String producto){
        return Tasks.instrumented(EliminarProductoCarrito.class, producto);
    }
}
