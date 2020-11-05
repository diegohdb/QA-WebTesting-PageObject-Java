package Tests;

import Pages.BasePage;
import Pages.RegisterPage;
import Pages.TablePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRegister extends  BasePage{

    RegisterPage registerPage;

    @Before
    public void setUp() {
        BasePage.webConnection();
        registerPage = new RegisterPage();
        registerPage.visitRegisterPage();
    }

    @After
    public void tearDown() {
        BasePage.closeBrowser();
    }

    @Test
    public void testValidRegister() throws InterruptedException {
        registerPage.insertFirstName("Tester");
        registerPage.insertLastName("Test");
        registerPage.insertEmail("tester@tester.com");
        registerPage.insertPhone("7737137223");
        registerPage.chooseGender();
        registerPage.insertAddress("Tester");
        registerPage.selectLanguage("Portuguese");
        registerPage.selectLanguage("English");
        registerPage.selectCountry("Brazil");
        registerPage.selectCountry2("India");
        registerPage.selectBirth("1989", "April", "1");
        registerPage.insertPassword("Tester123");
        //registerPage.uploadFile(ADD THE ABSOLUTE PATH TO resources/README2.md);
        registerPage.clickSubmit();
        TablePage webtablePage = new TablePage();
        Thread.sleep(4000);
        Assert.assertEquals("WebTable", webtablePage.getActive());
    }

    @Test
    public void testInvalidName() {
        registerPage.insertFirstName("");
        registerPage.insertLastName("Test");
        registerPage.insertEmail("tester@tester.com");
        registerPage.insertPhone("7737137223");
        registerPage.chooseGender();
        registerPage.insertAddress("Tester");
        registerPage.selectLanguage("Portuguese");
        registerPage.selectLanguage("English");
        registerPage.selectCountry("Brazil");
        registerPage.selectCountry2("India");
        registerPage.selectBirth("1989", "April", "1");
        registerPage.insertPassword("Tester123");
        registerPage.clickSubmit();
        Assert.assertEquals("Please fill out this field.", registerPage.getToastNameMessage());
    }

    @Test
    public void testInvalidEmail() {
        registerPage.insertFirstName("Tester");
        registerPage.insertLastName("Test");
        String email = "tester.com";
        registerPage.insertEmail(email);
        registerPage.insertPhone("7737137223");
        registerPage.chooseGender();
        registerPage.insertAddress("Tester");
        registerPage.selectLanguage("Portuguese");
        registerPage.selectLanguage("English");
        registerPage.selectCountry("Brazil");
        registerPage.selectCountry2("India");
        registerPage.selectBirth("1989", "April", "1");
        registerPage.insertPassword("Tester123");
        registerPage.clickSubmit();
        Assert.assertEquals("Please include an '@' in the email address. '"+email+"' is missing an '@'.", registerPage.getToastEmailMessage());
    }

}
