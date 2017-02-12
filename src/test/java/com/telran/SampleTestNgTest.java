package com.telran;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTestNgTest extends TestNgTestBase {

  private Login homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, Login.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    //Assert.assertFalse("".equals(homepage.header.getText()));
  }
}
