package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.*;



import java.util.concurrent.TimeUnit;


public class RegisterFormTest {
    public static WebDriver driver;
    public static RegisterFormPage registerFormPage;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/automation-practice-form");
        registerFormPage = new RegisterFormPage(driver);
    }

    @Test
    public void registerFormTest() {
        registerFormPage.inputFirstName("Vladislav");
        registerFormPage.inputLastName("Ushakov");
        registerFormPage.inputEmail("someEmail@mail.ru");
        registerFormPage.setGender();
        registerFormPage.inputMobileNumber("9992239561");
        registerFormPage.setHobbies();
        registerFormPage.inputCurrentAddress("Moscow, Yogo-Zapadnaya st.");
        registerFormPage.setDateOfBirth();
        registerFormPage.uploadPicture("screen-6.jpg");
        registerFormPage.clickSubmitButton();
        registerFormPage.checkingAppearanceOfTheForm();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

//    public static void main(String[] args) {
//        setup();
//    }
}
