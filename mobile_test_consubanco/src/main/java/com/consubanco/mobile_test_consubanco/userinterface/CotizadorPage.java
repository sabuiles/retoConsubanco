package com.consubanco.mobile_test_consubanco.userinterface;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CotizadorPage {
    public static final Target SEL_SUCURSAL = Target.the("Campo sucursal")
            .located(By.id("com.consubanco.ecsb:id/selectorAgreementSucursal"));
    public static final Target SEL_GRUPO_DE_CONVENIOS= Target.the("Campo grupo de convenios")
            .located(By.id("com.consubanco.ecsb:id/selectorAgreementGroups"));
    public static final Target SEL_CONVENIO = Target.the("Campo convenio")
            .located(By.id("com.consubanco.ecsb:id/selectorAgreements"));
    public static final Target BTN_NO_RENOVACION_INTERCOMPANIA = Target.the("Boton no es una renovacion")
            .located(By.id("com.consubanco.ecsb:id/buttonNo"));
    public static final Target SEL_TIPO_MONTO = Target.the("Campo como desea cotizar")
            .located(By.id("com.consubanco.ecsb:id/selectorQuoterType"));
    public static final Target TXT_MONTO = Target.the("Campo como desea cotizar")
            .located(By.id("com.consubanco.ecsb:id/editTextAmountLoan"));
    public static final Target BTN_COTIZAR = Target.the("Boton cotizar")
            .located(By.id("com.consubanco.ecsb:id/btnNext"));
    public static final Target LOADER_NO_TARDAMOS = Target.the("Loader no tardamos")
            .locatedBy("//android.widget.TextView[@text='Estamos validando la información']");

}
