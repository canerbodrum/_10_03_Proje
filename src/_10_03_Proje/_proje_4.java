package _10_03_Proje;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class _proje_4 extends BaseDriver {


    @Test
    public void test4() throws AWTException {
        //    Test Case: 4
//            ➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
        driver.get("https://shopdemo.e-junkie.com/");
        WebElement ebook= driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        ebook.click();
//            ➢ E-book add to cart butonuna tıklatınız.

//            ➢ Pay using debit card a tıklatınız.
        WebElement frame= driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        driver.switchTo().frame(frame);

        MyFunc.Bekle(1);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Payment-Button CC']")));

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-option='CC']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement debit= driver.findElement(By.xpath("//button[@data-option='CC']"));
        debit.click();


        //iframe[@class='EJIframeV3 EJOverlayV3']

        WebElement email= driver.findElement(By.xpath("//input[@placeholder='Email']"));

        email.sendKeys("tester@gmail.com");

        WebElement confirm= driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));

        confirm.sendKeys("tester@gmail.com");

        WebElement name= driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));

        name.sendKeys("tester techno");

        WebElement gsm= driver.findElement(By.xpath("//input[@autocomplete='phone']"));
        gsm.sendKeys("05555555555");

        WebElement company= driver.findElement(By.xpath("//input[@autocomplete='company']"));
        company.sendKeys("techno study");


        //driver.switchTo().frame(frame2);

        WebElement frame3= driver.findElement(By.xpath("//*[starts-with(@name,'__privateStripeFrame')]"));
        driver.switchTo().frame(frame3);

        WebElement cc= driver.findElement(By.xpath("//*[@autocomplete='cc-number']"));

        cc.sendKeys("4242 4242 4242 4242");

        WebElement expirydate= driver.findElement(By.xpath("//input[@placeholder='AA / YY']"));

        expirydate.sendKeys("1223");

        WebElement cvc= driver.findElement(By.xpath("//input[@placeholder='CVC']"));

        cvc.sendKeys("000");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(frame);

//        WebElement frame2= driver.findElement(By.xpath("//*[starts-with(@name,'__privateStripeMetricsController')]"));
//        driver.switchTo().frame(frame2);

        MyFunc.Bekle(1);
        WebElement buton= driver.findElement(By.xpath("(//button[@type='button'])[1]"));

        buton.click();

        MyFunc.Bekle(11);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='green_text_margin']")));


        WebElement orderiscomfirm= driver.findElement(By.xpath("//span[@class='green_text_margin']"));

        System.out.println(orderiscomfirm.isDisplayed());
        System.out.println(orderiscomfirm.getText());


        Assert.assertTrue("test hatalı",orderiscomfirm.getText().contains("confirmed"));
//    expdate, cvc kodu bilgilerini doldurunuz
//➢ Pay butonuna tıklayınız
//➢ “Your order is confirmed. Thank you!” mesajının görüldüğünü doğrulayınız
    }
}
