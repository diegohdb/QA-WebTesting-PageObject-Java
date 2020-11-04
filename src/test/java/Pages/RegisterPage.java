package Pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    By etFirstName = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input");
    By etLastName = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input");
    By taAddress = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea");
    By etEmail = By.xpath("//*[@id=\"eid\"]/input");
    By etPhone = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input");
    By btLogin = By.id("btnLogin");
    By rbGender = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input");
    By ddCountry = By.xpath("//*[@id=\"countries\"]");
    By ddCountry2 = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span");
    By etCountry = By.xpath("/html/body/span/span/span[1]/input");
    By opCountry = By.xpath("//*[@id=\"select2-country-results\"]/li");
    By ddLanguage = By.xpath("//*[@id=\"msdd\"]");
    By ddYear = By.xpath("//*[@id=\"yearbox\"]");
    By ddMonth = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select");
    By ddDay = By.xpath("//*[@id=\"daybox\"]");
    By etPassword = By.xpath("//*[@id=\"firstpassword\"]");
    By etConfPassword = By.xpath("//*[@id=\"secondpassword\"]");
    By btSubmit = By.id("submitbtn");
    By toast = By.partialLinkText("Please fill out this field.");
    By btUpload = By.id("imagesrc");


    public void visitRegisterPage() {
        this.Visit("http://demo.automationtesting.in/Register.html");
    }

    public void insertFirstName(String firstName) {
        this.SendText(etFirstName, firstName);
    }

    public void insertLastName(String lastName) {
        this.SendText(etLastName, lastName);
    }

    public void insertEmail(String email) {
        this.SendText(etEmail, email);
    }

    public void insertPhone(String phone) {
        this.SendText(etPhone, phone);
    }

    public void insertAddress(String address) {
        this.SendText(taAddress, address);
    }

    public void chooseGender() {
        this.Click(rbGender);
    }

    public void selectLanguage(String value) {
        this.SelectByLi(ddLanguage, value);
    }

    public void selectCountry(String value) {
        this.Select(ddCountry, value);
    }

    public void selectCountry2(String value) {
        this.SelectAutoComplete(ddCountry2, etCountry, opCountry, "India");
    }

    public void selectBirth(String year, String month, String day) {
        this.Select(ddYear, year);
        this.Select(ddMonth, month);
        this.Select(ddDay, day);
    }

    public void insertPassword(String password) {
        this.SendText(etPassword, password);
        this.SendText(etConfPassword, password);
    }

    public void clickSubmit() {
        this.Click(btSubmit);
    }

    public String getToastNameMessage() {
        return this.GetValidationMessage(etFirstName);
    }

    public String getToastEmailMessage() {
        return this.GetValidationMessage(etEmail);
    }

    public void uploadFile(String filePath){
        this.SendText(btUpload, filePath);
    }
}
