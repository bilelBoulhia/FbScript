package org.example;

import Builder.Command;
import Builder.SelectorBuilder;
import Builder.WebDriveBuilder;
import org.openqa.selenium.*;


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
    public static   String Leave_Btn = selectorBuilder(new Selectordata("menuitem",null,"Leave Group","x1i10hfl xjbqb8w x1ejq31n xd10rxx x1sy0etr x17r0tee x972fbf xcfux6l x1qhh985 xm0m39n xe8uvvx x1hl2dhg xggy1nq x1o1ewxj x3x9cwd x1e5q0jg x13rtm0m x87ps6o x1lku1pv x1a2a7pz xjyslct x9f619 x1ypdohk x78zum5 x1q0g3np x2lah0s x1i6fsjq xfvfia3 xnqzcj9 x1gh759c x1n2onr6 x16tdsg8 x1ja2u2z x6s0dn4 x1y1aw1k xwib8y2 x1q8cg2c xnjli0"));
    public static   String Leave_Confirm_btn =selectorBuilder(new Selectordata(null,"Leave Group",null,null));



    public static void main(String[] args) {

        if(!Script()){
            new Throwable("errror");
            driver.quit();
        }
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
                    cmd.clickAction(Leave_Btn,"ByXPath",true);
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

