package com.consubanco.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
    public static final Target ITEMS_CART = Target.the("Todos los productos en el carrito")
            .locatedBy("//tr[@class='success']/td[2]");
    public static final Target ITEM = Target.the("Producto {0}")
            .locatedBy("//tr[@class='success']/td[2 and text()='{0}']");

    public static final Target BTN_DELETE_ITEM = Target.the("Boton eliminar del producto {0}")
            .locatedBy("//tr[@class='success']/td[2 and text()='Samsung galaxy s6']//following-sibling::td/a");
}
