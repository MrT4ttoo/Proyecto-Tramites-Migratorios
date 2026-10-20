import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/*
 * TC03 - Acceso al expediente -> Muestra la informacion del usuario
 * Corresponde a la fila "Acceso al expediente -> Muestra la informacion
 * del usuario: OK".
 */

WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost:8080/')

TestObject txtEmail = new TestObject('txtEmail')
txtEmail.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'email')

TestObject txtPassword = new TestObject('txtPassword')
txtPassword.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'password')

TestObject btnLogin = new TestObject('btnLogin')
btnLogin.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'btnLogin')

TestObject lblCargados = new TestObject('lblCargados')
lblCargados.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'cargados')

TestObject lblEstado = new TestObject('lblEstado')
lblEstado.addProperty('id', com.kms.katalon.core.testobject.ConditionType.EQUALS, 'estado')

WebUI.setText(txtEmail, 'usuario@migracion.pa')
WebUI.setText(txtPassword, 'Pa2026!')
WebUI.click(btnLogin)

WebUI.delay(1)

// Verifica que se muestre el resumen del expediente (documentos cargados y estado)
WebUI.verifyElementText(lblCargados, '3/5')
WebUI.verifyElementText(lblEstado, 'En revision')

WebUI.closeBrowser()
