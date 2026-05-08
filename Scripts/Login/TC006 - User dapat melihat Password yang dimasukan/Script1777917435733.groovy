import internal.GlobalVariable
import myApp.CSWeb

CSWeb.openBrowser("")

CSWeb.navigateToUrl(GlobalVariable.base_url)

CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)

def username = GlobalVariable.username
def password = GlobalVariable.password

// Global Variable
CSWeb.setText("[type='text']", username)
CSWeb.setEncryptedText("[type='password']", password)

CSWeb.takeScreenshot()

CSWeb.click("[class='MuiSvgIcon-root visibilityStatus']")

CSWeb.verifyFieldNotEmpty("[placeholder='Masukkan username atau email anda...']")

CSWeb.verifyFieldNotEmpty("[placeholder='Masukkan password anda..']")

CSWeb.takeScreenshot()



