import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*
 * TC05 - Auditoría DAST de Seguridad: Resistencia contra Inyección SQL en Formulario Web
 * Módulo 3 - Pruebas DevSecOps y QA
 *
 * Objetivo: Validar que un intento de bypass de autenticación mediante inyección SQL
 * clásica (' OR '1'='1) sea rechazado por el backend JPA sin romper la interfaz y sin conceder acceso.
 *
 * Requisito: TramitesApplication corriendo en http://localhost:8080
 */

WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost:8080/')

TestObject txtEmail = new TestObject('txtEmail')
txtEmail.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'email')

TestObject txtPassword = new TestObject('txtPassword')
txtPassword.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'password')

TestObject btnLogin = new TestObject('btnLogin')
btnLogin.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'btnLogin')

TestObject msgError = new TestObject('msgError')
msgError.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'msg')

TestObject panelExpediente = new TestObject('panelExpediente')
panelExpediente.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'panelCard')

// Inyección de Payload malicioso de autenticación SQLi
WebUI.setText(txtEmail, "' OR '1'='1")
WebUI.setText(txtPassword, "' OR '1'='1")
WebUI.click(btnLogin)

WebUI.delay(1)

// Comprobar que NO se ingresó al panel y que se muestra el mensaje de error controlado
WebUI.verifyElementNotPresent(panelExpediente, 2)
WebUI.verifyElementVisible(msgError)

WebUI.closeBrowser()
