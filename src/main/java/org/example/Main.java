package org.example;

import Builder.Command;
import Builder.SelectorBuilder;
import Builder.WebDriveBuilder;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;



@SuppressWarnings("ALL")
public class Main {
    public  record Selectordata(String role,String AriaLabel,String Text,String classname){}
    public static WebDriver driver = WebDriveBuilder.create().build();
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    public static Command cmd = new Command(driver);
    public static   String More_btn = selectorBuilder(new Selectordata("button","More",null,null));
    public static    String List_element = selectorBuilder(new Selectordata("listitem",null,null,null));
    public static   String Leave_Btn = selectorBuilder(new Selectordata("menuitem",null,"Leave Group",null));
    public static   String Leave_Confirm_btn =selectorBuilder(new Selectordata(null,"Leave Group",null,null));



    public static void main(String[] args) {


        driver.quit();

    }


    ;public static Boolean Script(){

        while (cmd.findElements(List_element,"ByXPath").size() > 0) {

            cmd.clickAction(More_btn,"ByXPath",true);

            boolean leaveGroupExist = false;
            int attempts = 0;
            int max = 2;

            while (!leaveGroupExist && attempts < max) {
                try {
                    //if this doesnt work
                   cmd.clickAction(Leave_Btn,"ByXPath",true);

                   //use this
//                 WebElement wb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='menuitem']/descendant::span[text()='Leave group']")));
//                 wb.click();

                    leaveGroupExist = true;
                } catch (TimeoutException e) {


                    driver.navigate().refresh();
                    cmd.clickAction(More_btn,"ByXPath",true);

                    attempts++;
                }
            }

            if (leaveGroupExist) {
                cmd.clickAction(Leave_Confirm_btn,"ByXPath",true);
            } else {
                driver.quit();
                return  false;
            }

            driver.navigate().refresh();
        }
        return  true;
    }

    public  static  String selectorBuilder(Selectordata data){

        String selector = SelectorBuilder.create()
                .withRole(data.role)
                .withAriaLabel(data.AriaLabel)
                .withClass(data.classname)
                .withSpanText(data.classname)
                .build();

                return selector;
    };



}

