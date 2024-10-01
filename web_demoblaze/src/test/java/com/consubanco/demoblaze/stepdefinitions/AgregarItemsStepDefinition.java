package com.consubanco.demoblaze.stepdefinitions;

import com.consubanco.demoblaze.questions.ListaDeProductos;
import com.consubanco.demoblaze.questions.TodosLosProductos;
import com.consubanco.demoblaze.questions.URL;
import com.consubanco.demoblaze.tasks.*;
import com.consubanco.demoblaze.userinterfaces.CartPage;
import com.consubanco.demoblaze.userinterfaces.ProductsPage;
import com.consubanco.demoblaze.userinterfaces.TopMenuComponent;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.AlertText;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Absence;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Map;

public class AgregarItemsStepDefinition {

    @Managed
    private WebDriver hisBrowser;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Sergio").whoCan(BrowseTheWeb.with(hisBrowser));
        OnStage.theActorInTheSpotlight().attemptsTo(Open.relativeUrl("https://www.demoblaze.com/index.html"));
    }
    @Dado("que el comprador se ha registrado")
    public void queElCompradorSeHaRegistrado(Map<String,String> credenciales) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Registrarse.conDatosUsuario(credenciales));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(AlertText.currentlyVisible().thenAccept(),
                Matchers.equalTo("Sign up successful.")));

        OnStage.theActorInTheSpotlight().remember("credenciales", credenciales);
    }
    @Dado("el comprador se ha logueado con los datos de registro")
    public void elCompradorSeHaLogueadoConLosDatos() {
        Map<String,String> credenciales = OnStage.theActorInTheSpotlight().recall("credenciales");
        OnStage.theActorInTheSpotlight().attemptsTo(Login.conDatosUsuario(credenciales),
                WaitUntil.the(TopMenuComponent.LBL_USUARIO_LOGUEADO, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(Duration.ofSeconds(10)));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Text.of(TopMenuComponent.LBL_USUARIO_LOGUEADO),
                Matchers.is("Welcome " +credenciales.get("usuario"))));
    }
    @Dado("el comprador esta en la categoria {string}")
    public void elCompradorEstaEnLaCategoria(String categoria) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarCategoria.conElNombre(categoria));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ListaDeProductos.enLaCategoriaSeleccionada(),
                Matchers.containsInAnyOrder("Samsung galaxy s6",
                        "Nokia lumia 1520",
                        "Nexus 6",
                        "Samsung galaxy s7",
                        "Iphone 6 32gb",
                        "Sony xperia z5",
                        "HTC One M9")));
    }
    @Cuando("el comprador agrega el producto {string}")
    public void elCompradorAgregaElProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarAlCarrito.elProducto(producto));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(AlertText.currentlyVisible().thenAccept(),
                Matchers.equalTo("Product added.")));
        OnStage.theActorInTheSpotlight().remember("producto", producto);

    }
    @Entonces("el comprador deberia ver el producto en el carrito")
    public void elCompradorDeberiaVerElProductoEnElCarrito() {
        String producto = OnStage.theActorInTheSpotlight().recall("producto");
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(TopMenuComponent.BTN_CART));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TodosLosProductos.enElCarrito(), Matchers.hasItem(producto)));

    }
    @Cuando("el comprador remueve el producto {string} del carrito")
    public void elCompradorRemueveElDelCarrito(String string) {
        String producto = OnStage.theActorInTheSpotlight().recall("producto");
        OnStage.theActorInTheSpotlight().attemptsTo(EliminarProductoCarrito.conNombre(producto));
    }

    @Entonces("el comprador deberia ver que el producto {string} ya no esta en el carrito")
    public void elCompradorDeberiaVerQueElProductoYaNoEstaEnElCarrito(String producto) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Absence.of(CartPage.ITEM.of(producto)), Matchers.is(true)));
    }

    @Cuando("el comprador cierra la sesion")
    public void elCompradorCierraLaSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(CerrarSesion.actual());
    }

    @Entonces("el comprador no deberia ver su nombre de usuario")
    public void elCompradorNoDeberiaVerSuNombreDeUsuario() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Absence.of(TopMenuComponent.LBL_USUARIO_LOGUEADO),
                Matchers.is(true)));
    }
    @Entonces("el comprador deberia estar en la pagina principal")
    public void elCompradorDeberiaEstarEnLaPaginaPrincipal() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(URL.actual(), Matchers.equalTo("https://www.demoblaze.com/index.html")));
    }

}
