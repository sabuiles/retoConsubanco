package com.consubanco.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.HtmlAlert;

public class LaAlerta implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return HtmlAlert.text().answeredBy(actor);
    }

    public static LaAlerta mostradaEnPantalla(){
        return new LaAlerta();
    }
}
