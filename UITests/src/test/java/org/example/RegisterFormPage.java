package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class RegisterFormPage {
    @FindBy(id = "firstName")
    private WebElement userFirstNameField;

    @FindBy(id = "lastName")
    private WebElement userLastNameField;

    @FindBy(id = "userEmail")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    private WebElement userGenderMale;

    @FindBy(id = "userNumber")
    private WebElement userMobileNumberField;

    @FindBy(id = "dateOfBirthInput")
    private WebElement userDateOfBirthInput;

    @FindBy(id = "subjectsInput")
    private WebElement userSubjectsField;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")
    private WebElement userHobbiesSports;

    @FindBy(id = "currentAddress")
    private WebElement userCurrentAddressField;

    @FindBy(id = "state")
    private WebElement userState;

    @FindBy(id = "city")
    private WebElement userCity;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]")
    private WebElement firstDayOfBirthInList;

    @FindBy(id = "uploadPicture")
    private WebElement Picture;

    @FindBy(id = "closeLargeModal")
    private WebElement closeButtonOnFinalForm;

    public void inputFirstName(String firstName) {
        userFirstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        userLastNameField.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        userEmailField.sendKeys(email);
    }

    public void setGender() {
        userGenderMale.click();
    }

    public void inputMobileNumber(String mobileNumber) {
        userMobileNumberField.sendKeys(mobileNumber);
    }

    public void setDateOfBirth(){
        userDateOfBirthInput.click();
        firstDayOfBirthInList.click();
    }

    //ToDo: Не реализован выбор из выпадающего списка, т.к. верстка сайта не позволяет прочитать тег выпадающего списка
    // (при попытке посмотреть тег списка он сворачивается и пропадает тег из верстки. Не помогла даже приостановка
    // выполнения сценария)
    public void inputSubjects(String subjects) {
        userSubjectsField.sendKeys(subjects);
    }

    public void setHobbies() {
        userHobbiesSports.click();
    }

    public void inputCurrentAddress(String currentAddress) {
        userCurrentAddressField.sendKeys(currentAddress);
    }

    public void uploadPicture(String contentRootPath){
        String filePath = System.getProperty("user.dir") + "\\"  + contentRootPath;
        System.out.println(filePath);
        Picture.sendKeys(filePath);
    }

    public void clickSubmitButton() {
        //Уменьшение масштаба страницы, т.к. при зуме 100% некликабельна кнопка Submit
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '0.75'");
        executor.executeScript("arguments[0].click();", submitButton);
    }

    public void checkingAppearanceOfTheForm(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", submitButton);
    }

    public WebDriver driver;

    public RegisterFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
