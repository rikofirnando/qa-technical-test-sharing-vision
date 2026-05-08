import internal.GlobalVariable
import myApp.CSWeb

CSWeb.openBrowser("")

CSWeb.navigateToUrl(GlobalVariable.base_url)

CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)

def username = GlobalVariable.wrongUsername
def password = GlobalVariable.password

// Global Variable
CSWeb.setText("[type='text']", username)
CSWeb.setEncryptedText("[type='password']", password)

CSWeb.verifyFieldNotEmpty("[type='text']")

CSWeb.verifyFieldNotEmpty("[type='password']")

CSWeb.takeScreenshot()

CSWeb.click("//button[text()='Login']")

CSWeb.delay(1)

CSWeb.verifyTextPresent("Username and/or Password is invalid", false)

CSWeb.takeScreenshot()



