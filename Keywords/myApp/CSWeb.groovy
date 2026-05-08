package myApp

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.keyword.internal.KeywordExecutor
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// import static myApp.CSWeb.cari

public class CSWeb extends WebUI {

	// ======================================================
	// LOCATOR HELPER
	// Membuat TestObject secara dinamis dari locator XPath/CSS
	// ======================================================
	static TestObject cari (String locator) {
		new TestObject().addProperty(locator.startsWith('/')||locator.startsWith('(') ? 'xpath':'css', ConditionType.EQUALS, locator)
	}

	// ======================================================
	// ACTION - CLICK
	// Klik element berdasarkan locator
	// ======================================================
	static click (String locator) {
		super.click(cari(locator))
	}

	// ======================================================
	// ACTION - INPUT TEXT
	// Mengisi text ke dalam field
	// ======================================================
	static setText (String locator, String text) {
		super.setText(cari(locator), text)
	}

	// ======================================================
	// ACTION - INPUT ENCRYPTED TEXT
	// Mengisi password atau text terenkripsi
	// ======================================================
	static setEncryptedText (String locator, String encryptedText) {
		super.setEncryptedText(cari(locator), encryptedText)
	}

	// ======================================================
	// WAIT - ELEMENT PRESENT
	// Menunggu element muncul di DOM
	// ======================================================
	static boolean waitForElementPresent(String locator, int timeout) {
		return super.waitForElementPresent(cari(locator), timeout)
	}

	// ======================================================
	// SCREENSHOT - ELEMENT
	// Mengambil screenshot khusus pada element
	// ======================================================
	static String takeElementScreenshot(String locator) {
		return (String) KeywordExecutor.executeKeywordForPlatform(
				KeywordExecutor.PLATFORM_WEB,
				"takeElementScreenshot",
				null,
				cari(locator),
				null,
				null,
				false,
				null
				)
	}

	// ======================================================
	// VERIFY - ELEMENT PRESENT
	// Verifikasi bahwa element ada
	// ======================================================
	static boolean verifyElementPresent(String locator, int timeout) throws StepFailedException {
		return (boolean) KeywordExecutor.executeKeywordForPlatform(
				KeywordExecutor.PLATFORM_WEB,
				"verifyElementPresent",
				cari(locator),
				timeout
				)
	}

	// ======================================================
	// VERIFY - ELEMENT NOT PRESENT
	// Verifikasi bahwa element tidak ada
	// ======================================================
	static boolean verifyElementNotPresent(String locator, int timeout) throws StepFailedException {
		return (boolean) KeywordExecutor.executeKeywordForPlatform(
				KeywordExecutor.PLATFORM_WEB,
				"verifyElementNotPresent",
				cari(locator),
				timeout
				)
	}

	// ======================================================
	// WAIT - ELEMENT VISIBLE
	// Menunggu element terlihat oleh user
	// ======================================================
	static boolean waitForElementVisible(String locator, int timeout) throws StepFailedException {
		return (boolean) KeywordExecutor.executeKeywordForPlatform(
				KeywordExecutor.PLATFORM_WEB,
				"waitForElementVisible",
				cari(locator),
				timeout
				)
	}

	// ======================================================
	// WAIT - ELEMENT NOT VISIBLE
	// Menunggu element tidak terlihat
	// ======================================================
	static boolean waitForElementNotVisible(String locator, int timeout) throws StepFailedException {
		return (boolean) KeywordExecutor.executeKeywordForPlatform(
				KeywordExecutor.PLATFORM_WEB,
				"waitForElementNotVisible",
				cari(locator),
				timeout
				)
	}

	// ======================================================
	// VERIFY - TEXT PRESENT
	// Verifikasi text muncul pada halaman
	// ======================================================
	static boolean verifyTextPresent(String text, boolean isRegex) throws StepFailedException {
		return (boolean) KeywordExecutor.executeKeywordForPlatform(
				KeywordExecutor.PLATFORM_WEB,
				"verifyTextPresent",
				text,
				isRegex
				)
	}

	// ======================================================
	// VERIFY - TEXT NOT PRESENT
	// Verifikasi text tidak muncul
	// ======================================================
	static boolean verifyTextNotPresent(String text, boolean isRegex) throws StepFailedException {
		return (boolean) KeywordExecutor.executeKeywordForPlatform(
				KeywordExecutor.PLATFORM_WEB,
				"verifyTextNotPresent",
				text,
				isRegex
				)
	}

	// ======================================================
	// ACTION - SCROLL
	// Scroll halaman menuju element
	// ======================================================
	static scrollToElement(String locator, int timeout) throws StepFailedException {
		KeywordExecutor.executeKeywordForPlatform(
				KeywordExecutor.PLATFORM_WEB,
				"scrollToElement",
				cari(locator),
				timeout
				)
	}

	// ======================================================
	// LOG - COMMENT
	// Menambahkan komentar ke report Katalon
	// ======================================================
	static comment (def message) {
		try {
			super.comment(message.toString())
		} catch (e) {
			e.printStackTrace()
		}
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS ENTER
	// ======================================================
	// VERSION 1
	static pressEnter() {
		def actions = new Actions(DriverFactory.getWebDriver())
		actions.sendKeys(Keys.ENTER).perform()
	}

	// VERSION 2
	static pressEnter(String locator) {
		super.sendKeys(cari(locator), Keys.chord(Keys.ENTER))
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS TAB
	// ======================================================
	static pressTab() {
		def actions = new Actions(DriverFactory.getWebDriver())
		actions.sendKeys(Keys.TAB).perform()
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS ESCAPE
	// ======================================================
	static pressEscape() {
		def actions = new Actions(DriverFactory.getWebDriver())
		actions.sendKeys(Keys.ESCAPE).perform()
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS SPACE
	// ======================================================
	static pressSpace() {
		def actions = new Actions(DriverFactory.getWebDriver())
		actions.sendKeys(Keys.SPACE).perform()
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS ARROW UP
	// ======================================================
	static pressArrowUp() {
		def actions = new Actions(DriverFactory.getWebDriver())
		actions.sendKeys(Keys.ARROW_UP).perform()
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS ARROW DOWN
	// ======================================================
	static pressArrowDown() {
		def actions = new Actions(DriverFactory.getWebDriver())
		actions.sendKeys(Keys.ARROW_DOWN).perform()
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS ARROW LEFT
	// ======================================================
	static pressArrowLeft() {
		def actions = new Actions(DriverFactory.getWebDriver())
		actions.sendKeys(Keys.ARROW_LEFT).perform()
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS ARROW RIGHT
	// ======================================================
	static pressArrowRight() {
		def actions = new Actions(DriverFactory.getWebDriver())
		actions.sendKeys(Keys.ARROW_RIGHT).perform()
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS DELETE
	// ======================================================
	static pressDelete() {
		def actions = new Actions(DriverFactory.getWebDriver())
		actions.sendKeys(Keys.DELETE).perform()
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS BACKSPACE
	// ======================================================
	static pressBackspace() {
		def actions = new Actions(DriverFactory.getWebDriver())
		actions.sendKeys(Keys.BACK_SPACE).perform()
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS ARROW (MULTIPLE TIMES)
	// Example : pressArrow("right", 5)
	// ======================================================
	static pressArrow(String direction, int times) {

		def actions = new Actions(DriverFactory.getWebDriver())

		def key

		switch(direction.toLowerCase()) {

			case "up":
				key = Keys.ARROW_UP
				break

			case "down":
				key = Keys.ARROW_DOWN
				break

			case "left":
				key = Keys.ARROW_LEFT
				break

			case "right":
				key = Keys.ARROW_RIGHT
				break

			default:
				throw new IllegalArgumentException("Invalid arrow direction: " + direction)
		}

		for(int i = 0; i < times; i++) {
			actions.sendKeys(key).perform()
		}
	}

	// ======================================================
	// SCROLL - DOWN BY PERCENTAGE
	// Example : scrollDown(10) -> scroll 10% page height
	// ======================================================
	static scrollDown(int percent) {

		def driver = DriverFactory.getWebDriver()

		JavascriptExecutor js = (JavascriptExecutor) driver

		String script = """
		var height = document.body.scrollHeight;
		window.scrollBy(0, height * ${percent} / 100);
	"""

		js.executeScript(script)
	}

	// ======================================================
	// SCROLL - DOWN TO ELEMENT
	// Scroll halaman sampai element terlihat
	// ======================================================
	static scrollDown(String locator) {

		def driver = DriverFactory.getWebDriver()

		JavascriptExecutor js = (JavascriptExecutor) driver

		js.executeScript(
				"arguments[0].scrollIntoView(true);",
				WebUI.findWebElement(cari(locator), 10)
				)
	}

	// ======================================================
	// KEYBOARD ACTION - PRESS SPACE ON ELEMENT
	// ======================================================
	static pressSpace(String locator) {
		super.sendKeys(cari(locator), Keys.SPACE)
	}

	// ======================================================
	// ACTION - ENHANCED CLICK
	// Klik element dengan metode yang lebih stabil
	// ======================================================
	static enhancedClick(String locator) throws StepFailedException {
		KeywordExecutor.executeKeywordForPlatform(
				KeywordExecutor.PLATFORM_WEB,
				"enhancedClick",
				cari(locator)
				)
	}

	// ======================================================
	// VERIFY - SINGLE FIELD EMPTY
	// Memastikan field tidak memiliki nilai (kosong)
	// ======================================================
	static verifyFieldEmpty(String locator) {

		def element = WebUI.findWebElement(cari(locator), 10)

		String value = element.getAttribute("value")

		if(value == null || value.trim() == "") {

			comment("✅ FIELD EMPTY : " + locator)
		} else {

			throw new AssertionError("❌ FIELD NOT EMPTY : " + locator + " -> " + value)
		}
	}


	// ======================================================
	// VERIFY - SINGLE FIELD NOT EMPTY
	// Memastikan field memiliki nilai (tidak kosong)
	// ======================================================
	static verifyFieldNotEmpty(String locator) {

		def element = WebUI.findWebElement(cari(locator), 10)

		String value = element.getAttribute("value")

		if(value != null && value.trim() != "") {

			comment("✅ FIELD NOT EMPTY : " + locator + " -> " + value)
		} else {

			throw new AssertionError("❌ FIELD EMPTY : " + locator)
		}
	}

	// ======================================================
	// VERIFY - MULTIPLE FIELD EMPTY
	// Memastikan beberapa field kosong
	// ======================================================
	static verifyFieldsEmpty(List<String> locators) {

		for(String locator : locators) {

			def element = WebUI.findWebElement(cari(locator), 10)

			String value = element.getAttribute("value")

			if(value == null || value.trim() == "") {

				comment("✅ FIELD EMPTY : " + locator)
			} else {

				throw new AssertionError("❌ FIELD NOT EMPTY : " + locator + " -> " + value)
			}
		}
	}

	// ======================================================
	// VERIFY - MULTIPLE FIELD NOT EMPTY
	// Memastikan beberapa field tidak kosong
	// ======================================================
	static verifyFieldsNotEmpty(List<String> locators) {

		for(String locator : locators) {

			def element = WebUI.findWebElement(cari(locator), 10)

			String value = element.getAttribute("value")

			if(value != null && value.trim() != "") {

				comment("✅ FIELD NOT EMPTY : " + locator + " -> " + value)
			} else {

				throw new AssertionError("❌ FIELD EMPTY : " + locator)
			}
		}
	}

	// ======================================================
	// VERIFY - FIELD CONTAINS ONLY LETTERS
	// Tidak boleh angka / simbol
	// ======================================================
	static verifyOnlyLetters(String locator, String fieldName) {

		def element = WebUI.findWebElement(cari(locator), 10)

		String value = element.getAttribute("value")

		if(value == null || value.trim().isEmpty()) {

			comment("⚠️ " + fieldName + " is EMPTY")
		}
		else if(value.matches('^[A-Za-z]+$')) {

			comment("✅ " + fieldName + " VALID : Only letters -> " + value)
		}
		else {

			throw new AssertionError(
			"❌ " + fieldName + " INVALID : Contains number or special character -> " + value
			)
		}
	}

	// ======================================================
	// VERIFY - MULTIPLE FIELD LETTER VALIDATION
	// ======================================================
	static verifyFieldsOnlyLetters(Map<String, String> fields) {

		fields.each { fieldName, locator ->

			def element = WebUI.findWebElement(cari(locator), 10)

			String value = element.getAttribute("value")

			if(value == null || value.trim().isEmpty()) {

				comment("⚠️ " + fieldName + " is EMPTY")
			}
			else if(value.matches('^[A-Za-z]+$')) {

				comment("✅ " + fieldName + " VALID : " + value)
			}
			else {

				throw new AssertionError(
				"❌ " + fieldName + " INVALID : Contains number or symbol -> " + value
				)
			}
		}
	}

	// ======================================================
	// VERIFY - ONLY NUMBERS
	// ======================================================
	static verifyOnlyNumbers(String locator, String fieldName) {

		def element = WebUI.findWebElement(cari(locator), 10)
		String value = element.getAttribute("value")

		if(value.matches('^[0-9]+$')) {

			comment("✅ " + fieldName + " VALID : Only numbers -> " + value)
		} else {

			throw new AssertionError(
			"❌ " + fieldName + " INVALID : Contains letters or symbols -> " + value
			)
		}
	}

	static verifyOnlyNumbers(Map<String, String> fields) {

		fields.each { fieldName, locator ->

			def element = WebUI.findWebElement(cari(locator), 10)
			String value = element.getAttribute("value")

			if(value.matches('^[0-9]+$')) {

				comment("✅ " + fieldName + " VALID : " + value)
			} else {

				throw new AssertionError(
				"❌ " + fieldName + " INVALID : Contains letters or symbols -> " + value
				)
			}
		}
	}

	// ======================================================
	// VERIFY - ALPHANUMERIC
	// ======================================================
	static verifyAlphaNumeric(String locator, String fieldName) {

		def element = WebUI.findWebElement(cari(locator), 10)
		String value = element.getAttribute("value")

		if(value.matches('^[A-Za-z0-9]+$')) {

			comment("✅ " + fieldName + " VALID : Alphanumeric -> " + value)
		} else {

			throw new AssertionError(
			"❌ " + fieldName + " INVALID : Contains special characters -> " + value
			)
		}
	}

	static verifyAlphaNumeric(Map<String, String> fields) {

		fields.each { fieldName, locator ->

			def element = WebUI.findWebElement(cari(locator), 10)
			String value = element.getAttribute("value")

			if(value.matches('^[A-Za-z0-9]+$')) {

				comment("✅ " + fieldName + " VALID : " + value)
			} else {

				throw new AssertionError(
				"❌ " + fieldName + " INVALID : Contains special characters -> " + value
				)
			}
		}
	}

	// ======================================================
	// VERIFY - SINGLE FIELD EMAIL VALID FORMAT
	// ======================================================
	static verifyEmailFormat(String locator, String fieldName) {

		def element = WebUI.findWebElement(cari(locator), 10)
		String value = element.getAttribute("value")

		if(value.matches('^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$')) {

			comment("✅ " + fieldName + " VALID EMAIL : " + value)
		} else {

			throw new AssertionError(
			"❌ " + fieldName + " INVALID EMAIL FORMAT -> " + value
			)
		}
	}

	// ======================================================
	// VERIFY - MULTIPLE FIELD EMAIL VALID FORMAT
	// ======================================================
	static verifyEmailFormat(Map<String, String> fields) {

		fields.each { fieldName, locator ->

			def element = WebUI.findWebElement(cari(locator), 10)
			String value = element.getAttribute("value")

			if(value.matches('^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$')) {

				comment("✅ " + fieldName + " VALID EMAIL : " + value)
			} else {

				throw new AssertionError(
				"❌ " + fieldName + " INVALID EMAIL FORMAT -> " + value
				)
			}
		}
	}

	// ======================================================
	// VERIFY - EMAIL INVALID FORMAT (READ EXISTING VALUE)
	// ======================================================
	static verifyEmailInvalidFormat(String locator, String fieldName) {

		def element = WebUI.findWebElement(cari(locator), 10)

		// ambil value yang sudah diisi di field
		String value = element.getAttribute("value")

		if(value == null || value.trim().isEmpty()) {

			throw new AssertionError("❌ " + fieldName + " EMPTY")
		}

		// cek apakah format email salah
		if(!value.matches('^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$')) {

			comment("✅ INVALID EMAIL FORMAT DETECTED : " + fieldName + " -> " + value)
		}
		else {

			throw new AssertionError(
			"❌ EMAIL FORMAT VALID BUT EXPECTED INVALID : " + fieldName + " -> " + value
			)
		}
	}

	// ======================================================
	// VERIFY - MULTIPLE EMAIL INVALID FORMAT
	// ======================================================
	static verifyFieldsEmailInvalidFormat(Map<String, String> fields) {

		fields.each { fieldName, locator ->

			def element = WebUI.findWebElement(cari(locator), 10)

			String value = element.getAttribute("value")

			if(value == null || value.trim().isEmpty()) {

				throw new AssertionError("❌ " + fieldName + " EMPTY")
			}

			if(!value.matches('^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$')) {

				comment("✅ INVALID EMAIL FORMAT DETECTED : " + fieldName + " -> " + value)
			}
			else {

				throw new AssertionError(
				"❌ EMAIL FORMAT VALID BUT EXPECTED INVALID : " + fieldName + " -> " + value
				)
			}
		}
	}

	// ======================================================
	// CHECK - EMAIL VALID FORMAT (Notification Only)
	// Tidak menghentikan test case, hanya lapor di Log Viewer
	// ======================================================
	static void checkEmailFormat(String locator, String fieldName) {
		String value = super.getAttribute(cari(locator), 'value')

		if (value == null) {
			value = ""
		}

		if (value.matches('^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$')) {
			KeywordUtil.logInfo("PASSED: [${fieldName}] VALID EMAIL FORMAT -> " + value)
		} else {

			KeywordUtil.markWarning("WARNING: [${fieldName}] INVALID EMAIL FORMAT -> " + value)
		}
	}

	// ======================================================
	// VERIFY - PHONE NUMBER FORMAT
	// Membaca value langsung dari field
	// ======================================================
	static verifyPhoneNumber(String locator) {

		def element = WebUI.findWebElement(cari(locator), 10)

		String value = element.getAttribute("value")

		if(value == null || value.trim().isEmpty()) {

			throw new AssertionError("❌ PHONE NUMBER EMPTY : " + locator)
		}

		if(value.matches('^[0-9]{10,13}$')) {

			comment("✅ VALID PHONE NUMBER : " + value)
		} else {

			throw new AssertionError(
			"❌ INVALID PHONE NUMBER : " + value
			)
		}
	}

	// ======================================================
	// VERIFY - MULTIPLE PHONE NUMBER FORMAT
	// ======================================================
	static verifyPhoneNumbers(List<String> locators) {

		for(String locator : locators) {

			def element = WebUI.findWebElement(cari(locator), 10)

			String value = element.getAttribute("value")

			if(value == null || value.trim().isEmpty()) {

				throw new AssertionError("❌ PHONE NUMBER EMPTY : " + locator)
			}

			if(value.matches('^[0-9]{10,13}$')) {

				comment("✅ VALID PHONE NUMBER : " + value)
			} else {

				throw new AssertionError(
				"❌ INVALID PHONE NUMBER : " + value
				)
			}
		}
	}

	// ======================================================
	// VERIFY - ONLY CHARACTER
	// Memastikan field hanya berisi huruf
	// ======================================================
	static verifyOnlyCharacter(String locator, String fieldName) {

		def element = WebUI.findWebElement(cari(locator), 10)

		String value = element.getAttribute("value")

		if(value == null || value.trim() == "") {

			throw new AssertionError("❌ " + fieldName + " EMPTY")
		}
		else if(value.matches('^[A-Za-z]+$')) {

			comment("✅ " + fieldName + " VALID : Only characters -> " + value)
		}
		else {

			throw new AssertionError(
			"❌ " + fieldName + " INVALID : Contains numbers or symbols -> " + value
			)
		}
	}

	// ======================================================
	// VERIFY - MULTIPLE FIELD ONLY CHARACTER
	// Memastikan beberapa field hanya berisi huruf
	// ======================================================
	static verifyFieldsOnlyCharacter(Map<String, String> fields) {

		fields.each { fieldName, locator ->

			def element = WebUI.findWebElement(cari(locator), 10)

			String value = element.getAttribute("value")

			if(value == null || value.trim() == "") {

				throw new AssertionError("❌ " + fieldName + " EMPTY")
			}
			else if(value.matches('^[A-Za-z]+$')) {

				comment("✅ " + fieldName + " VALID : Only characters -> " + value)
			}
			else {

				throw new AssertionError(
				"❌ " + fieldName + " INVALID : Contains numbers or symbols -> " + value
				)
			}
		}
	}

	// ======================================================
	// VERIFY - SPECIAL CHARACTERS
	// Memastikan field berisi karakter khusus
	// ======================================================
	static verifySpecialCharacters(String locator, String fieldName) {

		def element = WebUI.findWebElement(cari(locator), 10)

		String value = element.getAttribute("value")

		if(value == null || value.trim().isEmpty()) {

			throw new AssertionError("❌ " + fieldName + " EMPTY")
		}
		else if(value.matches('^[~!@#\\$%\\^&\\*()\\-_=+\\[\\]{};"\'\\\\|,<.>/?]+$')) {

			comment("✅ " + fieldName + " VALID : Special characters -> " + value)
		}
		else {

			throw new AssertionError(
			"❌ " + fieldName + " INVALID : Contains letters or numbers -> " + value
			)
		}
	}

	// ======================================================
	// VERIFY - MULTIPLE FIELD SPECIAL CHARACTERS
	// ======================================================
	static verifyFieldsSpecialCharacters(Map<String, String> fields) {

		fields.each { fieldName, locator ->

			def element = WebUI.findWebElement(cari(locator), 10)

			String value = element.getAttribute("value")

			if(value == null || value.trim().isEmpty()) {

				throw new AssertionError("❌ " + fieldName + " EMPTY")
			}
			else if(value.matches('^[~!@#\\$%\\^&\\*()\\-_=+\\[\\]{};"\'\\\\|,<.>/?]+$')) {

				comment("✅ " + fieldName + " VALID : Special characters -> " + value)
			}
			else {

				throw new AssertionError(
				"❌ " + fieldName + " INVALID : Contains letters or numbers -> " + value
				)
			}
		}
	}

	// ======================================================
	// VERIFY - REQUIRED FIELD VALIDATION
	// Memastikan field menampilkan pesan required
	// ======================================================

	static verifyRequiredField(String locator) {

		def element = WebUI.findWebElement(cari(locator), 10)

		String message = element.getAttribute("validationMessage")

		if(message != null && message.trim() != "") {

			comment("✅ REQUIRED VALIDATION APPEAR : " + message)
		} else {

			comment("❌ REQUIRED VALIDATION NOT FOUND : " + locator)

			assert false
		}
	}

	// ======================================================
	// VERIFY - VALIDATION MESSAGE
	// ======================================================

	static verifyValidationMessage(String locator, String expectedMessage) {

		def element = WebUI.findWebElement(cari(locator), 10)

		String message = element.getAttribute("validationMessage")

		if(message == expectedMessage) {

			comment("✅ VALIDATION MESSAGE MATCH : " + message)
		} else {

			comment("❌ VALIDATION MESSAGE NOT MATCH")
			comment("Expected : " + expectedMessage)
			comment("Actual : " + message)

			assert false
		}
	}

	// ======================================================
	// VERIFY - DATE (DAY / MONTH / YEAR)
	// ======================================================
	static verifyDate(String locator, String expectedDay, String expectedMonth, String expectedYear) {

		def element = WebUI.findWebElement(cari(locator), 10)

		String actualDate = element.getText().trim()

		def dateParts = actualDate.split("/")

		String actualDay = dateParts[0]
		String actualMonth = dateParts[1]
		String actualYear = dateParts[2]

		if(actualDay == expectedDay && actualMonth == expectedMonth && actualYear == expectedYear) {

			comment("✅ DATE MATCH : " + actualDate)
		} else {

			comment("❌ DATE NOT MATCH")
			comment("Expected : " + expectedDay + "/" + expectedMonth + "/" + expectedYear)
			comment("Actual : " + actualDate)

			assert false
		}
	}

	// ======================================================
	// VERIFY - TEXT PRESENT (MULTIPLE KEYWORDS)
	// Memastikan beberapa text muncul di halaman
	// ======================================================

	static verifyMultipleTextPresent(String texts, boolean isRegex) {

		def listText = texts.split(",")

		for(String text : listText) {

			String keyword = text.trim()

			try {

				WebUI.verifyTextPresent(keyword, isRegex)

				comment("✅ TEXT FOUND : " + keyword)
			} catch (Exception e) {

				comment("❌ TEXT NOT FOUND : " + keyword)

				assert false
			}
		}
	}

	// ======================================================
	// ACTION - UPLOAD FILE
	// Upload file ke input type="file"
	// ======================================================
	static uploadFile(String locator, String filePath) {
		super.uploadFile(cari(locator), filePath)
	}

	// ======================================================
	// ACTION - UPLOAD FILE (SAFE)
	// Validasi file sebelum upload
	// ======================================================
	static uploadFileSafe(String locator, String filePath) {
		File file = new File(filePath)

		if (!file.exists()) {
			throw new StepFailedException("File tidak ditemukan: " + filePath)
		}

		super.uploadFile(cari(locator), filePath)
	}

	// ======================================================
	// ACTION - UPLOAD FILE FROM PROJECT
	// Mengambil file dari folder project
	// ======================================================
	static uploadFileFromProject(String locator, String relativePath) {
		String fullPath = System.getProperty("user.dir") + "/" + relativePath
		super.uploadFile(cari(locator), fullPath)
	}

	// ======================================================
	// ACTION - UPLOAD FILE WITH WAIT
	// Tunggu element dulu baru upload
	// ======================================================
	static uploadFileWithWait(String locator, String filePath, int timeout = 10) {
		boolean isPresent = super.waitForElementPresent(cari(locator), timeout)

		if (!isPresent) {
			throw new StepFailedException("Element tidak ditemukan: " + locator)
		}

		super.uploadFile(cari(locator), filePath)
	}

	// ======================================================
	// VERIFY - MINIMUM CHARACTER LENGTH
	// Memvalidasi apakah jumlah karakter field >= minLength
	// ======================================================
	static boolean verifyMinLength(String locator, int minLength) {
		// Mengambil value dari element (input/textarea)
		String text = super.getAttribute(cari(locator), 'value')
		int totalChar = text.length()

		if (totalChar >= minLength) {
			KeywordUtil.markPassed("Validasi Sukses: Karakter ditemukan ${totalChar}, minimal yang diminta adalah ${minLength}.")
			return true
		} else {
			KeywordUtil.markFailed("Validasi Gagal: Karakter ditemukan cuma ${totalChar}, sedangkan minimal harus ${minLength}.")
			return false
		}
	}

	// ======================================================
	// CHECK - FIELD LENGTH (Murni Hanya Informasi)
	// ======================================================
	static void checkFieldLength(String locator, int expectedMin) {
		// Ambil value dari field
		String text = super.getAttribute(cari(locator), 'value')

		// Cek null untuk menghindari error
		int actualLength = (text == null) ? 0 : text.length()

		if (actualLength >= expectedMin) {
			// Jika sudah memenuhi atau lebih
			KeywordUtil.logInfo("PASSED: Field '${locator}' berisi ${actualLength} karakter. (Target minimal: ${expectedMin})")
		} else {
			// Jika kurang dari target, tetap kasih info (bukan error)
			KeywordUtil.logInfo("INFO: Field '${locator}' isinya cuma ${actualLength} karakter. (Target minimal: ${expectedMin})")
		}
	}

	// ======================================================
	// VERIFY - NUMERIC ONLY
	// Memverifikasi apakah field HANYA berisi digit angka (0-9)
	// ======================================================
	static boolean verifyNumericOnly(String locator) {
		// Mengambil value dari element
		String text = super.getAttribute(cari(locator), 'value')

		// Cek jika field kosong
		if (text == null || text.trim().isEmpty()) {
			KeywordUtil.markFailed("Validasi Gagal: Field '${locator}' kosong, tidak ada teks yang bisa dicek.")
			return false
		}

		// Regex "^[0-9]+$" artinya string HANYA boleh berisi angka dari awal sampai akhir
		if (text.matches("^[0-9]+\$")) {
			KeywordUtil.markPassed("Validasi Sukses: Field '${locator}' murni berisi angka numerik. (Isi: ${text})")
			return true
		} else {
			KeywordUtil.markFailed("Validasi Gagal: Field '${locator}' mengandung huruf/simbol! Isinya: '${text}'")
			return false
		}
	}

	// ======================================================
	// VERIFY - MINIMUM DIGIT COUNT
	// Memverifikasi apakah field mengandung minimal sejumlah digit angka
	// ======================================================
	static boolean verifyMinDigitCount(String locator, int minDigits) {
		// Mengambil value dari element
		String text = super.getAttribute(cari(locator), 'value')

		// Cek jika field kosong atau null
		if (text == null || text.trim().isEmpty()) {
			KeywordUtil.markFailed("Validasi Gagal: Field '${locator}' kosong, tidak ada angka yang bisa dihitung.")
			return false
		}

		// Magic trick: Hapus semua karakter yang BUKAN angka (0-9)
		String onlyDigits = text.replaceAll("[^0-9]", "")
		int digitCount = onlyDigits.length()

		if (digitCount >= minDigits) {
			KeywordUtil.markPassed("Validasi Sukses: Field '${locator}' mengandung ${digitCount} digit angka (Minimal: ${minDigits}).")
			return true
		} else {
			KeywordUtil.markFailed("Validasi Gagal: Field '${locator}' hanya mengandung ${digitCount} digit angka, padahal minimal harus ${minDigits}. Isinya: '${text}'")
			return false
		}
	}

	// ======================================================
	// VERIFY - ELEMENT CLICKABLE
	// Memverifikasi apakah button/element AKTIF dan BISA diklik
	// ======================================================
	static boolean verifyClickable(String locator) {
		// Menggunakan FailureHandling.OPTIONAL agar kita handle log-nya sendiri
		boolean isClickable = WebUI.verifyElementClickable(cari(locator), FailureHandling.OPTIONAL)

		if (isClickable) {
			KeywordUtil.markPassed("Validasi Sukses: Button '${locator}' AKTIF dan BISA diklik.")
			return true
		} else {
			KeywordUtil.markFailed("Validasi Gagal: Button '${locator}' DISABLED (Tidak bisa diklik).")
			return false
		}
	}

	// ======================================================
	// VERIFY - ELEMENT NOT CLICKABLE
	// Memverifikasi apakah button/element DISABLED (TIDAK BISA diklik)
	// ======================================================
	static boolean verifyNotClickable(String locator) {
		boolean isNotClickable = WebUI.verifyElementNotClickable(cari(locator), FailureHandling.OPTIONAL)

		if (isNotClickable) {
			KeywordUtil.markPassed("Validasi Sukses: Button '${locator}' DISABLED (Sesuai ekspektasi, tidak bisa diklik).")
			return true
		} else {
			KeywordUtil.markFailed("Validasi Gagal: Button '${locator}' malah AKTIF dan BISA diklik, padahal seharusnya disable.")
			return false
		}
	}

	static drawRandomSignature(String xpath) {

		WebDriver driver = DriverFactory.getWebDriver()

		WebElement canvas = driver.findElement(By.xpath(xpath))

		Actions actions = new Actions(driver)

		Random random = new Random()

		int startX = 30
		int startY = 30

		actions.moveToElement(canvas, startX, startY)
				.clickAndHold()

		for (int i = 0; i < 15; i++) {

			int offsetX = random.nextInt(25)
			int offsetY = random.nextInt(25) - 12

			actions.moveByOffset(offsetX, offsetY)

			Thread.sleep(50)
		}

		actions.release().perform()
	}

	// ======================================================
	// WAIT & VERIFY - TEXT PRESENT (FIXED)
	// Menunggu teks muncul via dinamis XPath, lalu memverifikasi
	// ======================================================
	static boolean waitVerifyForTextPresent(String expectedText, int timeout) {

		// 1. Membuat Dynamic XPath untuk mencari elemen apapun yang mengandung teks tersebut
		String dynamicXPath = "//*[contains(text(), '${expectedText}')]"

		// 2. Tunggu sampai elemen teks tersebut muncul (menggunakan waitForElementPresent)
		WebUI.waitForElementPresent(cari(dynamicXPath), timeout, FailureHandling.OPTIONAL)

		// 3. Setelah ditunggu, pastikan dengan verifikasi bawaan Katalon
		boolean isVerified = WebUI.verifyTextPresent(expectedText, false, FailureHandling.OPTIONAL)

		if (isVerified) {
			KeywordUtil.markPassed("Wait & Verify Sukses: Teks '${expectedText}' berhasil ditemukan.")
			return true
		} else {
			KeywordUtil.markFailed("Wait & Verify Gagal: Teks '${expectedText}' tidak muncul di halaman setelah ditunggu ${timeout} detik.")
			return false
		}
	}

	// ======================================================
	// ACTION - SELECT OPTION
	// Support XPath & CSS
	// ======================================================
	static selectOption(
			String locator,
			String label
	) {

		WebUI.selectOptionByLabel(
				cari(locator),
				label,
				false
				)
	}
}