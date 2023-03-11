package _10_03_Proje;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _proje_2 extends BaseDriver {
    @Test
    public void test2() throws AWTException {

//    Test Case:2
//            ➢ https://shopdemo.e-junkie.com/ sitesine gidiniz//
                driver.get("https://shopdemo.e-junkie.com/");
//            ➢ E-book add to cart butonuna tıklatınız.
            WebElement ebook= driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));

            ebook.click();
//            ➢ Pay using debit card a tıklatınız.
//        WebElement payment= driver.findElement(By.xpath("(//button[starts-with(@class,'Payment-Button')])[2]"));
//        payment.click();

        Robot robot=new Robot();

        MyFunc.Bekle(2);
        for (int i = 0; i < 19; i++) {
            MyFunc.Bekle(1);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);



        for (int i = 0; i < 9; i++) {
            MyFunc.Bekle(1);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        MyFunc.Bekle(2);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);



        WebElement frame= driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(frame);
//        WebElement frame2= driver.findElement(By.xpath("//*[starts-with(@name,'__privateStripeMetricsContr')]"));
//        driver.switchTo().frame(frame2);

        WebElement txt= driver.findElement(By.xpath("//*[text()='Invalid Email']"));
        System.out.println(txt.isDisplayed());
        System.out.println(txt.getText());
        Assert.assertTrue(txt.isDisplayed());



//            ➢ Pay butonuna tıklatınız.
//➢ Invalid Email, Invalid Email, invalid billing name mesajlarının görüldüğünü doğrulayınız.
    }
}
