package com.consubanco.mobile_test_consubanco.stepdefinitions;

import com.consubanco.mobile_test_consubanco.questions.TheAmount;
import com.consubanco.mobile_test_consubanco.tasks.Cotizar;
import com.consubanco.mobile_test_consubanco.tasks.Login;
import com.consubanco.mobile_test_consubanco.userinterface.CotizadorPage;
import com.consubanco.mobile_test_consubanco.userinterface.MenuPage;
import com.consubanco.mobile_test_consubanco.userinterface.ResultadoCotizacionPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

public class CotizarStepDefinitions {

    @Managed
    private AndroidDriver hisMobile;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Sergio").whoCan(BrowseTheWeb.with(hisMobile));
    }

    @Cuando("que el usuario esta logueado")
    public void elUsuarioSeLoguea(List<Map<String, String>> credenciales) {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.conCredenciales(credenciales.get(0)));

    }
    @Cuando("el usuario crea una cotizacion")
    public void elUsuarioCreaUnaCotizacion(List<Map<String, String>> datosCotizacion) {
        OnStage.theActorInTheSpotlight().attemptsTo(Ensure.that(
                MenuPage.BTN_NUEVA_SOLICITUD).isDisplayed(),
                Click.on(MenuPage.BTN_NUEVA_SOLICITUD),
                Ensure.that(CotizadorPage.SEL_SUCURSAL).isDisplayed(),
                Ensure.that(CotizadorPage.SEL_GRUPO_DE_CONVENIOS).isDisplayed(),
                Ensure.that(CotizadorPage.SEL_CONVENIO).isDisplayed(),
                Cotizar.usandoLosDatos(datosCotizacion.get(0)));
        OnStage.theActorInTheSpotlight().remember("monto", datosCotizacion.get(0).get("monto"));
    }

    @Entonces("el usuario deberia ver los resultados de cotizaciones")
    public void elUsuarioDeberiaVerLosResultadosDeCotizaciones() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Text.of(ResultadoCotizacionPage.TITLE_RESULTADOS),
                Matchers.equalTo("Resultados de cotizaciones")));
        String monto = OnStage.theActorInTheSpotlight().recall("monto");
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheAmount.displayed(),
                Matchers.equalTo(monto)));
    }

}
