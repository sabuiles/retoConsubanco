package com.consubanco.demoblaze.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class TopMenuComponent {
    public static final Target BTN_SIGN_UP = Target.the("Boton sign up")
            .located(By.id("signin2"));
    public static final Target BTN_LOGIN = Target.the("Boton Login")
            .located(By.id("login2"));
    public static final Target LBL_USUARIO_LOGUEADO= Target.the("Nombre de usuario logueado")
            .located(By.id("nameofuser"));
    public static final Target BTN_CART = Target.the("Boton carrito")
            .locatedBy("//a[text()='Cart']");
        public static final Target BTN_LOG_OUT = Target.the("Boton log out")
            .locatedBy("//a[text()='Log out']");
}
