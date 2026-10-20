import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*
 * TC04 - Persistencia JPA y Validación de Sesión Relacional
 * Módulo 3 - Pruebas DevSecOps y QA
 *
 * Objetivo: Validar que el inicio de sesión contra PostgreSQL mediante Spring Data JPA
 * autentique correctamente, cargue la información del expediente persistido y verifique
 * la presencia de la identidad visual oficial (Logo SNM).
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

TestObject panelExpediente = new TestObject('panelExpediente')
panelExpediente.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'panelCard')

TestObject logoBrand = new TestObject('logoBrand')
logoBrand.addProperty('css', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'img.gov-logo, .brand-logo-img')

// Autenticación con credencial registrada en la base de datos PostgreSQL
WebUI.setText(txtEmail, 'usuario@migracion.pa')
WebUI.setText(txtPassword, 'Pa2026!')
WebUI.click(btnLogin)

WebUI.delay(1)

// Verificar despliegue del panel con datos relacionales y presencia del logotipo oficial
WebUI.verifyElementVisible(panelExpediente)
WebUI.verifyElementVisible(logoBrand)

WebUI.closeBrowser()
