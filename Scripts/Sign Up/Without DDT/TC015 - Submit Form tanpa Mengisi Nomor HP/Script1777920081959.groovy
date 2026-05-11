import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import myApp.CSWeb

CSWeb.openBrowser("")

CSWeb.navigateToUrl(GlobalVariable.base_url)

CSWeb.waitForElementPresent("[class='card shadow-lg']", 5)
	
CSWeb.click("//button[text()='Sign Up']")

String ktpPath = '/home/rikofirnando/Katalon Studio/QA Technical Test PT Sharing Vision - Riko Firnando/Pictures/sample.jpeg'
String selfiePath = '/home/rikofirnando/Katalon Studio/QA Technical Test PT Sharing Vision - Riko Firnando/Pictures/sample.jpeg'
def fullName = GlobalVariable.fullName
def placeOfBirth = GlobalVariable.placeOfBirth
def dateOfBirth = GlobalVariable.dateOfBirth
def noKTP = "1234567890123456"
def phoneNumber = ""
def email = GlobalVariable.email
def address = GlobalVariable.address
def domicileAddress = GlobalVariable.domicileAddress
def dateJoined = GlobalVariable.dateJoined

CSWeb.setText("[name='nama']", fullName)

CSWeb.setText("[name='tempat_lahir']", placeOfBirth)

CSWeb.setText("[name='tanggal_lahir']", dateOfBirth)

CSWeb.setText("[name='nomor_ktp']", noKTP)

CSWeb.setText("[name='nomor_hp']", phoneNumber)

CSWeb.setText("[name='email']", email)

CSWeb.setText("[name='tanggal_join']", dateJoined)

CSWeb.setText("[name='alamat']", address)

CSWeb.setText("[name='domisili']", domicileAddress)

CSWeb.uploadFile("[name='img_ktp']", ktpPath)

CSWeb.uploadFile("[name='img_selfie']", selfiePath)

CSWeb.verifyFieldNotEmpty("[name='nama']")

CSWeb.verifyFieldNotEmpty("[name='tempat_lahir']")

CSWeb.verifyFieldNotEmpty("[name='tanggal_lahir']")

CSWeb.verifyFieldNotEmpty("[name='nomor_ktp']")

CSWeb.verifyFieldNotEmpty("[name='nomor_hp']")

CSWeb.verifyFieldNotEmpty("[name='email']")

CSWeb.verifyNumericOnly("[name='nomor_hp']")

CSWeb.verifyMinDigitCount("[name='nomor_hp']", 10)

CSWeb.takeScreenshot()

CSWeb.click("[type='submit']")

CSWeb.takeScreenshot()

CSWeb.click("[class='swal-button swal-button--confirm']")
