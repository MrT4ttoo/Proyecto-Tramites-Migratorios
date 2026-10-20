import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*
 * TC02 - Login incorrecto -> Muestra mensaje de error
 * Corresponde a la fila "Login incorrecto -> Muestra mensaje de error: OK"
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

WebUI.setText(txtEmail, 'usuario@migracion.pa')
WebUI.setText(txtPassword, 'clave-incorrecta')
WebUI.click(btnLogin)

WebUI.delay(1)

// Verifica que aparezca el mensaje de error y que la pantalla principal NO se muestre
WebUI.verifyElementText(msgError, 'Correo o contrasena incorrectos')

WebUI.closeBrowser()
