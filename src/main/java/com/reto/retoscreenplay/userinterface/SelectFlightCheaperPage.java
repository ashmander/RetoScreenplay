package com.reto.retoscreenplay.userinterface;

import com.reto.retoscreenplay.utils.JavaScriptClick;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.reto.retoscreenplay.utils.TransformText.getFinalPrice;

public class SelectFlightCheaperPage {

    public static String priceCheaper;

    public static Target FLIGHT_CHEAPER() {
        String id = getFlightCheaper(getFlights());
        return Target
                .the("Select the flight cheaper")
                .located(By.id(id));
    }

    public static final Target CONTINUE = Target
            .the("Continue")
            .locatedBy("div[class*='next-button'] button");

    public static final Target DETAIL_FLIGHT = Target
            .the("Select the detail of the flight")
            .locatedBy("div[class*='viva']:not([class*='super']):not([class*='max']) button");

    public static Map<String, Integer> getFlights() {
        List<WebElement> flights = new WebDriverWait(SerenityWebdriverManager.inThisTestThread().getCurrentDriver(), 20)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='flights']/div")));
        Map<String, Integer> prices = new HashMap<>();
        for(WebElement flight : flights) {
            String id = flight.getAttribute("id");
            WebElement possibleFlightCheaper = flight.findElement(By.xpath("//div[@id='"+id+"']//div[@class='segment-lowest-price']/div[@class='from-price']"));
            Integer priceConverted = Integer.parseInt(getFinalPrice(possibleFlightCheaper.getText()));
            prices.put(id, priceConverted);
        }
        return prices;
    }

    public static String getFlightCheaper(Map<String, Integer> prices) {
        Map<String, Integer> orderAscendent = prices.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        priceCheaper = String.valueOf(orderAscendent.entrySet().stream().findFirst().get().getValue());
        return orderAscendent.entrySet().stream().findFirst().get().getKey();
    }
}
