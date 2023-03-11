package _10_03_Proje;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class _proje_1 extends BaseDriver {
//    Test Case 1:
//            ➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
     @Test
    public void test1() throws AWTException {
         driver.get("https://shopdemo.e-junkie.com/");
         Actions aksiyonlar=new Actions(driver);

         WebElement ebook= driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));

         ebook.click();
         WebElement frame= driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
         driver.switchTo().frame(frame);



         Robot robot=new Robot();

         MyFunc.Bekle(2);
         for (int i = 0; i < 15; i++) {
             MyFunc.Bekle(1);
             robot.keyPress(KeyEvent.VK_TAB);
             robot.keyRelease(KeyEvent.VK_TAB);
         }

         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);

         MyFunc.Bekle(1);
         WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

             //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class,'Promo-Box')]")));
         WebElement inputpromo= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
         inputpromo.sendKeys("test");
//
         WebElement applyclick= driver.findElement(By.xpath("(//button[@type='button'])[3]"));
         applyclick.click();

         WebElement cikanmesaj= driver.findElement(By.id("SnackBar"));
         System.out.println(cikanmesaj.getText());

         WebElement bucocugu= driver.findElement(By.xpath("//div[@id='SnackBar']/span"));
          //div[@id='SnackBar']/span
          Assert.assertTrue(bucocugu.isDisplayed());



         System.out.println(bucocugu.isDisplayed());
     }

//            ➢ E-book add to cart butonuna tıklatınız.
//            ➢ Add promo code butonuna tıklatıp veri giriniz.
//➢ Apply butonuna tıklayınız.
//➢ Invalid promo code yazısının görüldüğünü doğrulayınız
//    Test Case:2
//            ➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
//            ➢ E-book add to cart butonuna tıklatınız.
//            ➢ Pay using debit card a tıklatınız.
//            ➢ Pay butonuna tıklatınız.
//➢ Invalid Email, Invalid Email, invalid billing name mesajlarının görüldüğünü doğrulayınız.
//    Test Case:3
//            ➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
//            ➢ E-book add to cart butonuna tıklatınız.
//            ➢ Pay using debit card a tıklatınız.
//            ➢ Card numarasına “1111 1111 1111 1111” giriniz
//➢ “Your card number is invalid” mesajının görüldüğünü doğrulayınız.
//    Test Case: 4
//            ➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
//            ➢ E-book add to cart butonuna tıklatınız.
//            ➢ Pay using debit card a tıklatınız.
//            ➢ Email, confirm Email, name, telefon, company, Card number(“4242 4242 4242 4242” ) giriniz,
//    expdate, cvc kodu bilgilerini doldurunuz
//➢ Pay butonuna tıklayınız
//➢ “Your order is confirmed. Thank you!” mesajının görüldüğünü doğrulayınız
//    Test Case:5
//            ➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
//            ➢ ContactUs butonuna tıklattınız
//➢ Name, Email, Subject ve mesaj kısımlarını doldurun
//➢ Send butonuna tıklatın
//➢ Alert in görüldüğünü doğrulayın ve alert I kapatın
}
