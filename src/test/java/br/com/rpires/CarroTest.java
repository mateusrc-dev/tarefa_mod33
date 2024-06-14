package br.com.rpires;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.rpires.dao.AcessorioDao;
import br.com.rpires.dao.CarroDao;
import br.com.rpires.dao.IAcessorioDao;
import br.com.rpires.dao.ICarroDao;
import br.com.rpires.dao.IMarcaDao;
import br.com.rpires.domain.Acessorio;
import br.com.rpires.domain.Carro;
import br.com.rpires.domain.Marca;
import br.com.rpires.dao.MarcaDao;

public class CarroTest {
	private IMarcaDao marcaDao;
	private ICarroDao carroDao;
	private IAcessorioDao acessorioDao;
	
	public CarroTest() {
		marcaDao = new MarcaDao();
		carroDao = new CarroDao();
		acessorioDao = new AcessorioDao();
	}
	@Test
	public void cadastrar() {
		Carro carro = new Carro();
		Marca marca = criarMarca("A1");
		Acessorio acessorio = criarAcessorio("A1");
		carro.setCodigo("A1");
		carro.setNome("Gol");
		carro.setMarca(marca);
		carro.setPreco(10.000d);
		carro.addAcessorio(acessorio);
		
		carro = carroDao.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
	}
	
	private Acessorio criarAcessorio(String codigo) {
		Acessorio acessorio = new Acessorio();
		acessorio.setCodigo(codigo);
		acessorio.setNome("Pneu");
		acessorio.setPreco(100d);
		return acessorioDao.cadastrar(acessorio);
	}
	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setNome("Nissan");
		return marcaDao.cadastrar(marca);
	}
}
