package com.consubanco.mobile_test_consubanco.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/cotizador.feature",
        glue = "mobile_test_consubanco.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CotizarRunner {
}
