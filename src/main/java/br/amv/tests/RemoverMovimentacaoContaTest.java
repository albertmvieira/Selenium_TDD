package br.amv.tests;

import org.junit.Assert;
import org.junit.Test;

import br.amv.core.BaseTest;
import br.amv.pages.ContasPage;
import br.amv.pages.MenuPage;


public class RemoverMovimentacaoContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void testExcluirContaComMovimentacao(){
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}
