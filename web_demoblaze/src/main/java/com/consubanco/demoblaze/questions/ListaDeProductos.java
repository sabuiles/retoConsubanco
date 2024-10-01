package com.consubanco.demoblaze.questions;

import com.consubanco.demoblaze.userinterfaces.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class ListaDeProductos implements Question<List<String>> {
    @Override
    public List<String> answeredBy(Actor actor) {
        return ProductsPage.ITEMS.resolveAllFor(actor).textContents();
    }

    public static ListaDeProductos enLaCategoriaSeleccionada(){
        return new ListaDeProductos();
    }
}
