package visitGdansk;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisitGdanskUtils {

	public static void klikniecieKartyTurysty(WebDriver driver) {
		WebElement przycisk = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[7]/a"));
		przycisk.click();

	}

	public static void klikniecieZamow(WebDriver driver) {
		WebElement button = driver.findElement(By.xpath("//*[@id=\"responsive-menu\"]/li[9]/span"));
		button.click();
	}

	public static void klikniecieJednegoBiletu(WebDriver driver) {
		WebElement plusik = driver
				.findElement(By.xpath("//*[@id=\"fLiczbaOsob\"]/div/div/div[1]/div[2]/div/div/div[1]"));
		plusik.click();
	}
	
	public static void ustawComboNaPierwszyPakiet(WebDriver driver) {
		WebElement combo = driver.findElement(By.xpath("//*[@id=\"fFormularzOsob\"]/div[2]/table/tbody/tr/td[2]/div/select"));
		Select listaRozwijana = new Select(combo);
		listaRozwijana.selectByVisibleText("Family Fun Package 120h 100.00 PLN");
}
	
	public static boolean waitForAjax(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {

					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);

	}
	
	public static String cost(WebDriver driver) {
		WebElement nazwa = driver.findElement(By.xpath("//*[@id=\"fFormularzOsob\"]/div[2]/table/tbody/tr/td[3]/strong"));
		String nazwa2 = nazwa.getText();
		return nazwa2;
}
	public static String total(WebDriver driver) {
		WebElement nazwa = driver.findElement(By.xpath("//*[@id=\"podsumowanie\"]/table/tbody/tr[2]/td[2]"));
		String nazwa3 = nazwa.getText();
		return nazwa3;
}
}

