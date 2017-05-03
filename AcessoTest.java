import static org.junit.Assert.*; 
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class AcessoTest {

	Acesso a; 
	@Before
	public void setUP(){
		a = new Acesso(17, 4, 2012, 8, 0);
	}
	
	@Test
	public void testeApenasFracoes() {
		a.setHoraSaida(8);
		a.setMinutosSaida(40);
		Assert.assertEquals(6.0f, a.calcularValor());
	}
	
	@Test
	public void testeUmaHoraCheia() {
		a.setHoraSaida(9);
		a.setMinutosSaida(0);
		Assert.assertEquals(7.0f, a.calcularValor());
	}
	
	@Test
	public void testeDuasHorasCheias(){
		a.setHoraSaida(10);
		a.setMinutosSaida(0);
		Assert.assertEquals(14.0f, a.calcularValor());
	}
	
	@Test
	public void testeNoveHoras() {
		a.setHoraSaida(17);
		a.setMinutosSaida(0);
		Assert.assertEquals(30.0f, a.calcularValor());
	}

}
