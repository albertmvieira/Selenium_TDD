package br.amv.core;

import static br.amv.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.amv.pages.LoginPage;

public class BaseTest {
	
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testname = new TestName();
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		page.setEmail("albert@teste.com");
		page.setSenha("teste123");
		page.entrar();
	}
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testname.getMethodName() + ".jpg"));
		
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
