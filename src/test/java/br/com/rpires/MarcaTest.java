package br.com.rpires;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.rpires.dao.CarroDao;
import br.com.rpires.dao.MarcaDao;
import br.com.rpires.dao.ICarroDao;
import br.com.rpires.dao.IMarcaDao;
import br.com.rpires.domain.Carro;
import br.com.rpires.domain.Marca;

public class MarcaTest {
	
	private ICarroDao carroDao;
	private IMarcaDao marcaDao;
	
	public MarcaTest() {
		marcaDao = new MarcaDao();
		carroDao = new CarroDao();
	}
	
	@Test
	public void cadastrar() {
		Marca marca = new Marca();
		marca.setCodigo("A1");
		marca.setNome("Nissan");
		
		marca = marcaDao.cadastrar(marca);
		
		assertNotNull(marca);
		assertNotNull(marca.getId());
		
		Carro carro = new Carro();
		carro.setCodigo("A1");
		carro.setNome("Gol");
		carro.setMarca(marca);
		carro.setPreco(100.000d);
		
		carro = carroDao.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
	}
}
