package visitGdansk;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class visitGdanskTest {
private WebDriver driver;
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://visitgdansk.com/");

}
	@Test
	public void CzyCenySieZgadzaja() {
		VisitGdanskUtils.klikniecieKartyTurysty(driver);
		VisitGdanskUtils.klikniecieZamow(driver);
		VisitGdanskUtils.klikniecieJednegoBiletu(driver);
		VisitGdanskUtils.waitForAjax(driver);
		VisitGdanskUtils.ustawComboNaPierwszyPakiet(driver);
		VisitGdanskUtils.waitForAjax(driver);
		
		assertEquals(VisitGdanskUtils.cost(driver), VisitGdanskUtils.total(driver));
		
	}
	
	
	
	
	
	
	
	
	
}

