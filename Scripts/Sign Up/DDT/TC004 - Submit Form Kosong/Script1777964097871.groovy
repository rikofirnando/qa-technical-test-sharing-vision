import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import myApp.CSWeb

CSWeb.openBrowser("")

CSWeb.navigateToUrl(GlobalVariable.base_url)

CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)
	
CSWeb.click("//button[text()='Sign Up']")

CSWeb.setText("[name='nama']", fullName)

CSWeb.setText("[name='tempat_lahir']", placeOfBirth)

CSWeb.setText("[name='tanggal_lahir']", dateOfBirth)

CSWeb.setText("[name='nomor_ktp']", noKTP)

CSWeb.setText("[name='nomor_hp']", phoneNumber)

CSWeb.setText("[name='email']", email)

CSWeb.setText("[name='tanggal_join']", dateJoined)

CSWeb.setText("[name='alamat']", address)

CSWeb.setText("[name='domisili']", domicileAddress)

CSWeb.verifyFieldEmpty("[name='nama']")

CSWeb.verifyFieldEmpty("[name='tempat_lahir']")

CSWeb.verifyFieldEmpty("[name='tanggal_lahir']")

CSWeb.verifyFieldEmpty("[name='nomor_ktp']")

CSWeb.verifyFieldEmpty("[name='nomor_hp']")

CSWeb.verifyFieldEmpty("[name='email']")

CSWeb.verifyNotClickable("[type='submit']")

CSWeb.takeScreenshot()

CSWeb.closeBrowser()
