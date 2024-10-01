package com.consubanco.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ItemPage {

    public static final Target LBL_PRODUCT= Target.the("Nombre del producto")
            .locatedBy("//div[@id='tbodyid']/h2");
    public static final Target LBL_PRODUCT_DESCRIPTION = Target.the("Titulo Product description")
            .locatedBy("//*[@id='more-information']/strong");
    public static final Target BTN_ADD_TO_CART = Target.the("Boton agregar producto al carrito")
            .locatedBy("//a[text()='Add to cart']");
}
