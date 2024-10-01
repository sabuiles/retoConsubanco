package com.consubanco.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {
    public static final Target LBL_CATEGORIA = Target.the("Categoria {0}")
            .locatedBy("//a[@id='itemc' and text()='{0}']");
    public static final Target ITEMS = Target.the("Todos los productos")
            .locatedBy("//h4/a");
    public static final Target ITEM = Target.the("Producto {0}")
            .locatedBy("//h4/a[.='{0}']");


}
