package com.consubanco.demoblaze.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PopUpComponent {
    public static final Target TXT_SIGNUP_USERNAME = Target.the("Campo usuario")
            .located(By.id("sign-username"));
    public static final Target TXT_SIGNUP_PASSWORD = Target.the("Campo clave")
            .located(By.id("sign-password"));
    public static final Target BTN_SIGN_UP = Target.the("Boton sign up")
            .locatedBy("//button[.='Sign up']");

    public static final Target TXT_LOGIN_USERNAME = Target.the("Campo usuario")
            .located(By.id("loginusername"));
    public static final Target TXT_LOGIN_PASSWORD = Target.the("Campo clave")
            .located(By.id("loginpassword"));
    public static final Target BTN_LOGIN = Target.the("Boton login")
            .locatedBy("//button[.='Log in']");

}
