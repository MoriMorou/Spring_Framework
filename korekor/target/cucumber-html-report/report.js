$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:features/login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Successful Login to the page and logout after",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I open chrome browser",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to login.html page",
  "keyword": "When "
});
formatter.step({
  "name": "I provide username as \"\u003cusername\u003e\" and password as \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "I click on login button",
  "keyword": "And "
});
formatter.step({
  "name": "name should be \"\u003cname\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "click logout button",
  "keyword": "When "
});
formatter.step({
  "name": "user logged out",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "name"
      ]
    },
    {
      "cells": [
        "admin",
        "admin",
        "admin"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Successful Login to the page and logout after",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I open chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.iOpenChromeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to login.html page",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.iNavigateToLoginHtmlPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I provide username as \"admin\" and password as \"admin\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.iProvideUsernameAsAndPasswordAs(String,String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#username\"}\n  (Session info: chrome\u003d75.0.3770.142)\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027iMac-ArmanMori\u0027, ip: \u0027fe80:0:0:0:1040:6db4:6995:4945%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.5\u0027, java.version: \u00271.8.0_212\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.142, chrome: {chromedriverVersion: 75.0.3770.140 (2d9f97485c7b..., userDataDir: /var/folders/zf/8k4h4mw13qd...}, goog:chromeOptions: {debuggerAddress: localhost:60307}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: a0951557dae738d0292dc35739c064c2\n*** Element info: {Using\u003did, value\u003dusername}\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:368)\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\n\tat ru.morou.korekor.steps.LoginSteps.iProvideUsernameAsAndPasswordAs(LoginSteps.java:35)\n\tat ✽.I provide username as \"admin\" and password as \"admin\"(classpath:features/login.feature:6)\n",
  "status": "failed"
});
formatter.step({
  "name": "I click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.iClickOnLoginButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "name should be \"admin\"",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.nameShouldBe(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click logout button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.clickLogoutButton()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user logged out",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.userLoggedOut()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});