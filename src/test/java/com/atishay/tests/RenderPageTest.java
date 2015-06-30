package com.atishay.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ATISHAY on 27-06-2015.
 */
public class RenderPageTest extends BaseTest {

    @Test
    public void correctPageLoaded(){
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Your instant delivery app | Online Grocery Shopping"));
    }

}
