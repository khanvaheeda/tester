package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
@FindBy(name = "q")
private WebElement searchBox;
public WebElement getSearchBox() {
	return searchBox;
}
	
	@FindBy(xpath = "//*[@id='container']/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[1]/div[2]/form/div/button")
	private WebElement searchButton;
	public WebElement getSearchButton() {
		return searchButton;
		
	
}
	@FindBy(xpath = "//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div")
	private WebElement laptopDell;
	public WebElement getlaptopDell(){
		return laptopDell;
		
	}
	
	
}
