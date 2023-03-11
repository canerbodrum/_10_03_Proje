package _10_03_Proje;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _proje_3 extends BaseDriver {
    @Test
    public void test3() throws AWTException {
        //    Test Case:3
//            ➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
        driver.get("https://shopdemo.e-junkie.com/");
//            ➢ E-book add to cart butonuna tıklatınız.
        driver.get("https://shopdemo.e-junkie.com/");
//            ➢ E-book add to cart butonuna tıklatınız.
        WebElement ebook= driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));

        ebook.click();


        Robot robot=new Robot();

        MyFunc.Bekle(2);
        for (int i = 0; i < 19; i++) {
            MyFunc.Bekle(1);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

        MyFunc.Bekle(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


//            ➢ Pay using debit card a tıklatınız.

        for (int i = 0; i < 6; i++) {
            MyFunc.Bekle(1);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }


        for (int i = 0; i < 16; i++) {
            MyFunc.Bekle(1);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
        }




        WebElement frame3= driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(frame3);
        WebElement txt= driver.findElement(By.xpath("//*[@id='SnackBar']/span"));


        System.out.println(txt.getText());


        Assert.assertTrue(txt.isDisplayed());

//            ➢ Card numarasına “1111 1111 1111 1111” giriniz
//➢ “Your card number is invalid” mesajının görüldüğünü doğrulayınız.
    }
}
