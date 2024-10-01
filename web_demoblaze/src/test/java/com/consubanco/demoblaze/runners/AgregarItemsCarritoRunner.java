package com.consubanco.demoblaze.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/agregar_items_carrito.feature",
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    glue = "com.consubanco.demoblaze.stepdefinitions")
public class AgregarItemsCarritoRunner {
}
