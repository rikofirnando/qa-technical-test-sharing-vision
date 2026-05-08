import internal.GlobalVariable
import myApp.CSWeb

CSWeb.openBrowser("")

CSWeb.navigateToUrl(GlobalVariable.base_url)

CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)

// Global Variable
def username = GlobalVariable.username
def password = GlobalVariable.password

CSWeb.setText("[type='text']", username)
CSWeb.setEncryptedText("[type='password']", password)

CSWeb.verifyFieldNotEmpty("[type='text']")

CSWeb.verifyFieldNotEmpty("[type='password']")

CSWeb.takeScreenshot()

CSWeb.click("//button[text()='Login']")

CSWeb.waitVerifyForTextPresent("Aplikasi HR SV Jakarta 2023", 2)

CSWeb.waitVerifyForTextPresent("Riwayat Pengajuan Cuti", 3)

CSWeb.takeScreenshot()

CSWeb.click("(//*[@class='p-0 btn'])[1]")

CSWeb.click("[placeholder='Pilih tanggal...']")

CSWeb.click("(//button[.//div[text()='11']])[1]")

CSWeb.click("(//button[.//div[text()='15']])[1]")

CSWeb.click("(//*[@placeholder='-Select-'])[1]")

CSWeb.click("[name='id_pic']")

CSWeb.click("(//*[@placeholder='-Select-'])[2]")

CSWeb.setText("[name='keterangan_cuti']", " ")

CSWeb.click("[class='btn-edit-ttd-layer']")

CSWeb.click("[class='MuiSvgIcon-root MuiSvgIcon-fontSizeSmall']")

CSWeb.verifyFieldNotEmpty("[placeholder='Pilih tanggal...']")

CSWeb.verifyFieldNotEmpty("(//*[@placeholder='-Select-'])[1]")

CSWeb.verifyFieldNotEmpty("(//*[@placeholder='-Select-'])[2]")

CSWeb.verifyFieldNotEmpty("[name='keterangan_cuti']")

CSWeb.takeScreenshot()

CSWeb.click("//*[contains(text(),'Submit')]")

CSWeb.verifyTextPresent("Keterangan Cuti tidak boleh kosong!", false)

CSWeb.click("[class='swal-button swal-button--confirm']")

CSWeb.takeScreenshot()

//CSWeb.closeBrowser()
