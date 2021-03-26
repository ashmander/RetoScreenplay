package com.reto.retoscreenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CloseNotificationPage {

    public static final Target CLOSE_NOTIFICATION = Target.the("Close notification").located(By.id("onesignal-slidedown-cancel-button"));
}
