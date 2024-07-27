package Builder;

import BuilderInterfaces.IBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class WebDriveBuilder implements IBuilder<WebDriver> {
    private final profileBuilder profileBuilder;




    public  static String  fb_group_link = "https://www.facebook.com/groups/joins/";






    private WebDriveBuilder() {

        this.profileBuilder = new profileBuilder().create();

    }



    public  static WebDriveBuilder create () {
        return  new WebDriveBuilder();
    }





    @Override
    public WebDriver build() {
        ChromeOptions options = profileBuilder.build();
        WebDriver driver = new ChromeDriver(options);

        driver.get(fb_group_link);
        return driver;
    }



}

