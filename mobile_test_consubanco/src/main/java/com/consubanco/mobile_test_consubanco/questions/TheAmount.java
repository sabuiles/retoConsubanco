package com.consubanco.mobile_test_consubanco.questions;

import com.consubanco.mobile_test_consubanco.userinterface.ResultadoCotizacionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheAmount implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String amount = ResultadoCotizacionPage.PRIMER_MONTO.resolveFor(actor).getAttribute("text");
        return amount.replaceAll("[$,]", "").split("\\.")[0];
    }

    public static TheAmount displayed(){
        return new TheAmount();
    }
}
