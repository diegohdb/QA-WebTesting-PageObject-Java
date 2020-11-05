package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TablePage extends BasePage{

    By tbActive = By.cssSelector("li[class=\"active\"] a");
    By btNameSort = By.cssSelector("div[id*=\"0006-menu-button\"]");
    By btSortAscending = By.cssSelector("li[id=\"menuitem-0\"] button");
    By btRemoveSort = By.xpath("//*[@id=\"menuitem-2\"]/button");
    By btEdit = By.cssSelector("div[id*=\"0-uiGrid-000B-cell\"] user-click-select div button");
    By btDelete = By.cssSelector("div[id*=\"uiGrid-000B-cell\"] user-click-select del-click i");
    By btDelete2 = By.cssSelector("li[ng-click=\"grid.appScope.Delete(row)\"] button");
    By btSave = By.cssSelector("div[id*=\"uiGrid-000B-cell\"] save-click button");
    By btCancel = By.cssSelector("div[id*=\"uiGrid-000B-cell\"] user-click-select cancel-click button");
    By etGender = By.cssSelector("div[id*=\"uiGrid-0007-cell\"] input");
    By tcGender = By.cssSelector("div[id*=\"uiGrid-0007-cell\"] div");
    By tcEmail = By.cssSelector("div[id*=\"uiGrid-0005-cell\"] div");

    public void visitWebTable(){
        this.Visit("http://demo.automationtesting.in/WebTable.html");
    }

    public String getActive(){
        return this.GetElement(tbActive, 10).getText();
    }

    public void clickSortName(){
        this.Click(btNameSort);
    }

    public void sortNameAscending(){
        clickSortName();
        this.Click(btSortAscending);
    }

    public WebElement hasRemoveSort(){
        clickSortName();
        return this.GetElement(btRemoveSort, 10);
    }

    public void clickEdit(){
        this.DoubleClick(btEdit);
    }

    public void clickDelete(){
        this.RightClickSelect(btDelete);
        this.Click(btDelete2);
        this.AcceptAlert();
    }

    public void clickSave(){
        this.Click(btSave);
    }

    public void clickCancel(){
        this.Click(btCancel);
    }

    public void editGender(String gender){
        this.SendText(etGender, gender);
    }

    public WebElement getGenderElementCell(){
        return this.GetElement(tcGender, 10);
    }

    public WebElement getEmailElementCell(){
        return this.GetElement(tcEmail, 10);
    }

    public WebElement getEditButton(){
        return this.GetElement(btEdit, 10);
    }

}
