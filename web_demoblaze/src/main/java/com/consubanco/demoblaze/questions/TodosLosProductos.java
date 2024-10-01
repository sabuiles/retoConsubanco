package com.consubanco.demoblaze.questions;

import com.consubanco.demoblaze.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class TodosLosProductos implements Question<List<String>> {
    @Override
    public List<String> answeredBy(Actor actor) {
        return CartPage.ITEMS_CART.resolveAllFor(actor).textContents();
    }

    public static TodosLosProductos enElCarrito(){
        return new TodosLosProductos();
    }
}
