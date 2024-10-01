package com.consubanco.mobile_test_consubanco.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class ResultadoCotizacionPage {
 public static final Target TITLE_RESULTADOS = Target.the("Titulo")
         .located(By.id("com.consubanco.ecsb:id/textView1"));
 public static final Target PRIMER_MONTO = Target.the("Primer monto")
         .locatedBy("(//android.widget.TextView[@resource-id='com.consubanco.ecsb:id/textViewLoanAmount'])[1]");
}

