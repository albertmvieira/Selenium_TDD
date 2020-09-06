package br.amv.tests;

import org.junit.Assert;
import org.junit.Test;

import br.amv.core.BaseTest;
import br.amv.pages.HomePage;
import br.amv.pages.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();

	@Test
	public void testSaldoConta(){
		menu.acessarTelaPrincipal();
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}
}
