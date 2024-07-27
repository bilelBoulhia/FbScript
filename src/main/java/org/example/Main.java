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

/*
*


        String More_btn = SelectorBuilder.create()
                .withRole("button")
                .withAriaLabel("More")
                .build();






        String List_element = SelectorBuilder.create()
                .withRole("listitem")
                .withClass("x9f619 x78zum5 x1r8uery xdt5ytf x1iyjqo2 xs83m0k x150jy0e x1e558r4 xjkvuk6 x1iorvi4 xnpuxes")
                .build();

        String Leave_Btn =  SelectorBuilder.create()
                  .withRole("menuitem")
                  .withSpanText("Leave group")
                  .build();

         String Leave_Confirm_btn =  SelectorBuilder.create()
                   .withAriaLabel("Leave Group")
                   .build();

        System.out.println(List_element);



        List<WebElement> listchilds = driver.findElements(By.xpath(List_element));




        while (listchilds.size() > 0) {

            cmd.clickAction(More_btn,"ByXPath",true);

            boolean leaveGroupExist = false;
            int attempts = 0;
            int maxAttempts = 5;

            while (!leaveGroupExist && attempts < maxAttempts) {
                try {
                    WebElement leaveGroup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Leave_Btn)));

                    leaveGroup.click();
                    leaveGroupExist = true;
                } catch (TimeoutException e) {
                    driver.navigate().refresh();
                    cmd.clickAction(More_btn,"ByXPath",true);

                    attempts++;
                }
            }

            if (leaveGroupExist) {
                WebElement ConfirmLeaveGroup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Leave_Confirm_btn)));
                ConfirmLeaveGroup.click();
            } else {
                System.out.println("error");
                driver.quit();
            }

            driver.navigate().refresh();
        }



        driver.quit();


*
* */