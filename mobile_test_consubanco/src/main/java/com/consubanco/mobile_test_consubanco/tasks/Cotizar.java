package com.consubanco.mobile_test_consubanco.tasks;

import com.consubanco.mobile_test_consubanco.interactions.SelectOption;
import com.consubanco.mobile_test_consubanco.interactions.WaitToDissapear;
import com.consubanco.mobile_test_consubanco.userinterface.CotizadorPage;
import com.consubanco.mobile_test_consubanco.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

public class Cotizar implements Task {
    private Map<String,String> datosCotizacion;

    public Cotizar(Map<String, String> dataCotizacion) {
        this.datosCotizacion = dataCotizacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectOption.withValueAndTarget(datosCotizacion.get("sucursal"), CotizadorPage.SEL_SUCURSAL),
                WaitToDissapear.theTarget(LoginPage.LOADER),
                SelectOption.withValueAndTarget(datosCotizacion.get("grupo de convenios"), CotizadorPage.SEL_GRUPO_DE_CONVENIOS),
                WaitToDissapear.theTarget(LoginPage.LOADER),
                SelectOption.withValueAndTarget(datosCotizacion.get("convenio"), CotizadorPage.SEL_CONVENIO),
                WaitToDissapear.theTarget(LoginPage.LOADER),
                Click.on(CotizadorPage.BTN_NO_RENOVACION_INTERCOMPANIA),
                SelectOption.withValueAndTarget(datosCotizacion.get("tipo cotizacion"), CotizadorPage.SEL_TIPO_MONTO),
                Enter.theValue(datosCotizacion.get("monto")).into(CotizadorPage.TXT_MONTO),
                Click.on(CotizadorPage.BTN_COTIZAR),
                WaitToDissapear.theTarget(CotizadorPage.LOADER_NO_TARDAMOS)
                );
    }

    public static Cotizar usandoLosDatos(Map<String,String> dataCotizacion){
        return Tasks.instrumented(Cotizar.class, dataCotizacion);
    }
}
