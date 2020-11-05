package Tests;

import Pages.BasePage;
import Pages.TablePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTable extends  BasePage{

    TablePage tablePage;

    @Before
    public void setUp() throws Exception {
        BasePage.webConnection();
        tablePage = new TablePage();
        tablePage.visitWebTable();
    }

    @After
    public void tearDown() throws Exception {
        BasePage.closeBrowser();
    }

    @Test
    public void testSortByName() {
        tablePage.sortNameAscending();
        Assert.assertTrue(tablePage.hasRemoveSort().isDisplayed());
    }

    @Test
    public void testEditGender() {
        tablePage.sortNameAscending();
        tablePage.clickEdit();
        tablePage.editGender("Male");
        tablePage.clickSave();
        Assert.assertNotNull(tablePage.getEditButton());
        Assert.assertEquals("Male", tablePage.getGenderElementCell().getText());
    }

    @Test
    public void testCancelEdition() {
        tablePage.sortNameAscending();
        tablePage.clickEdit();
        tablePage.editGender("Male");
        tablePage.clickCancel();
        String gender = tablePage.getGenderElementCell().getText();
        Assert.assertTrue(tablePage.getEditButton().isDisplayed());
        Assert.assertEquals(gender, tablePage.getGenderElementCell().getText());
    }

    @Test
    public void testDeleteRow() {
        tablePage.sortNameAscending();
        String name = tablePage.getEmailElementCell().getText();
        tablePage.clickDelete();
        Assert.assertNotEquals(name, tablePage.getEmailElementCell().getText());
    }
}
