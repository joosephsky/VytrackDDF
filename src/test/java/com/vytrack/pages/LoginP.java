package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginP {

    public LoginP(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(css="#prependedInput")
    public WebElement userName;
    @FindBy(css="#prependedInput2")
    public WebElement password;
    @FindBy(css="#_submit")
    public WebElement loginButton;

    public void login(String username, String password){
        userName.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }








}
