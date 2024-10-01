package com.consubanco.demoblaze.tasks;

import com.consubanco.demoblaze.userinterfaces.ProductsPage;
import net.serenitybdd.model.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleccionarCategoria implements Task {
    private String categoria;

    public SeleccionarCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ProductsPage.LBL_CATEGORIA.of(categoria)));
        new InternalSystemClock().pauseFor(500);
    }

    public static SeleccionarCategoria conElNombre(String categoria){
        return Tasks.instrumented(SeleccionarCategoria.class, categoria);
    }
}
