package com.consubanco.mobile_test_consubanco.userinterface;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target TXT_USERNAME = Target.the("Campo usuario")
            .located(By.id("com.consubanco.ecsb:id/editTextUser"));
    public static final Target TXT_CLAVE= Target.the("Campo clave")
            .located(By.id("com.consubanco.ecsb:id/editTextPass"));
    public static final Target BTN_INICIAR_SESION = Target.the("Boton iniciar sesion")
            .located(By.id("com.consubanco.ecsb:id/btnLogin"));
    public static final Target LOADER = Target.the("Cargando")
            .locatedBy("//android.widget.FrameLayout[@resource-id='com.consubanco.ecsb:id/customPanel']//android.widget.ProgressBar[@resource-id='com.consubanco.ecsb:id/progressBar']");
}
