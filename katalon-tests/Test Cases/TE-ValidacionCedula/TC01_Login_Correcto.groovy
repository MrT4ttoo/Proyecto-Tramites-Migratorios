import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*
 * TC01 - Login correcto -> Accede a la pantalla principal
 * Corresponde a la fila "Login correcto -> Accede a la pantalla principal: OK"
 *
 * Requisito: el servidor TramitesApp debe estar corriendo en
 * http://localhost:8080  (java TramitesApp.java)
 */

WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost:8080/')

TestObject txtEmail = new TestObject('txtEmail')
txtEmail.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'email')

TestObject txtPassword = new TestObject('txtPassword')
txtPassword.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'password')

TestObject btnLogin = new TestObject('btnLogin')
btnLogin.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'btnLogin')

TestObject panelExpediente = new TestObject('panelExpediente')
panelExpediente.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'panelCard')

WebUI.setText(txtEmail, 'usuario@migracion.pa')
WebUI.setText(txtPassword, 'Pa2026!')
WebUI.click(btnLogin)

WebUI.delay(1)

// Verifica que se muestre la pantalla principal del expediente
WebUI.verifyElementVisible(panelExpediente)

WebUI.closeBrowser()
