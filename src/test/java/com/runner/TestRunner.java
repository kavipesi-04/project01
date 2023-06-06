package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src\\test\\resources\\Features\\fbLoginPage.feature",glue="com.step")
public class TestRunner extends AbstractTestNGCucumberTests {

}