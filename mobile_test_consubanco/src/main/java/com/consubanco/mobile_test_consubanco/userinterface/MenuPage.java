package com.consubanco.mobile_test_consubanco.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class MenuPage {
    public static final Target BTN_NUEVA_SOLICITUD = Target.the("Boton nueva solicitud")
            .located(By.id("com.consubanco.ecsb:id/btnNewRequest"));
}
