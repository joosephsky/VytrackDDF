package com.vytrack.tests;

import com.vytrack.pages.LoginP;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.MyExcelUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestClasswMyExcelUtil {

    @BeforeMethod
    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @DataProvider
    public Object [][] logindata(){
       String path="src/test/resources/Vytracktestdata.xlsx";
        MyExcelUtil.XSSF userdata=new MyExcelUtil(path,"QA3-short",true).new XSSF();
        String[][] usercredentials =userdata.getDataArray();


        return usercredentials;
    }
    @Test(dataProvider = "logindata")   //
    public void datadriventestforlogin(String username, String password,String firstName, String lastName) throws InterruptedException {
        System.out.println(username+" "+password+" "+firstName+" "+lastName);

        LoginP loginp=new LoginP();
        loginp.login(username,password);
    }

//automate web browser    selenium dependency       webdriver manager
    //open a webpage
   //pull data from excel sheet   // xls- apache poi   xlsx-   apache poi ooxml
   //test                //   testNG







}
