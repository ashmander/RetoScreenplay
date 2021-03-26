package com.reto.retoscreenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.reto.retoscreenplay.userinterface.CloseNotificationPage.CLOSE_NOTIFICATION;
import static com.reto.retoscreenplay.userinterface.SearchCriteriaPage.SEARCH_CRITERIA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CloseNotification implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CLOSE_NOTIFICATION),
                Scroll.to(SEARCH_CRITERIA).andAlignToTop()
        );
    }

    public static CloseNotification andCloseNotificationAndScrollToSearchCriteria() {
        return instrumented(CloseNotification.class);
    }
}
