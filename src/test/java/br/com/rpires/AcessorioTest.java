package br.com.rpires;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.rpires.dao.AcessorioDao;
import br.com.rpires.dao.CarroDao;
import br.com.rpires.dao.IAcessorioDao;
import br.com.rpires.dao.ICarroDao;
import br.com.rpires.dao.IMarcaDao;
import br.com.rpires.dao.MarcaDao;
import br.com.rpires.domain.Acessorio;
import br.com.rpires.domain.Carro;
import br.com.rpires.domain.Marca;

public class AcessorioTest {
	private IAcessorioDao acessorioDao;
	private ICarroDao carroDao;
	private IMarcaDao marcaDao;
	
	public AcessorioTest() {
		acessorioDao = new AcessorioDao();
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
	}
	@Test
	public void cadastrar() {
		Acessorio acessorio = new Acessorio();
		acessorio.setCodigo("A1");
		acessorio.setNome("Pneu");
		acessorio.setPreco(100d);
		
		acessorio = acessorioDao.cadastrar(acessorio);
		
		assertNotNull(acessorio);
		assertNotNull(acessorio.getId());
		
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
		carro.addAcessorio(acessorio);
		
		carro = carroDao.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
	}
}
