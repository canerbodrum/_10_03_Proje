package _10_03_Proje;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _proje_5 extends BaseDriver {
    //    Test Case:5
//            ➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
    @Test
    public void test5(){
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement contact= driver.findElement(By.xpath("//a[@class='contact']"));
        contact.click();

        WebElement id= driver.findElement(By.id("sender_name"));
        id.sendKeys("grup14");

        WebElement email= driver.findElement(By.id("sender_email"));
        email.sendKeys("grup14@gmail.com");

        WebElement subject= driver.findElement(By.id("sender_subject"));
        subject.sendKeys("KONU TEST");

        WebElement message= driver.findElement(By.id("sender_message"));
        message.sendKeys("grup14 den selamlar çok kolaydı hocam...");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send_message_button")));
        WebElement idsend= driver.findElement(By.id("send_message_button"));
        idsend.click();
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());

    }
//            ➢ ContactUs butonuna tıklattınız
//➢ Name, Email, Subject ve mesaj kısımlarını doldurun
//➢ Send butonuna tıklatın
//➢ Alert in görüldüğünü doğrulayın ve alert I kapatın
}
