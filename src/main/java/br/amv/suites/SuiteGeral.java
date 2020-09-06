package br.amv.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.amv.core.DriverFactory;
import br.amv.pages.LoginPage;
import br.amv.tests.ContaTest;
import br.amv.tests.MovimentacaoTest;
import br.amv.tests.RemoverMovimentacaoContaTest;
import br.amv.tests.ResumoTest;
import br.amv.tests.SaldoTest;



@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset(){
		page.acessarTelaInicial();
		
		page.setEmail("albert@teste.com");
		page.setSenha("teste123");
		page.entrar();
		
		page.resetar();
		
		DriverFactory.killDriver();
	}
}
