package dao;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.senai.sc.ti20131n.pw.introducaojpa.entity.Banda;

import Util.JpaUtil;

public class BandaDaoTest {

	public static EntityManager entityManager;
	private static BandaDao dao;
	
	@BeforeClass
	public static void init(){
		JpaUtil.initFactory();	
	}
	
	@AfterClass
	public static void finish(){
		JpaUtil.closeFactory();
	}
	
	@Before
	public void begin(){
		entityManager = JpaUtil.getEntityManager();
		entityManager.getTransaction().begin();
		dao = new BandaDao(entityManager);
	}
	
	@After
	public void close(){
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManager = null;
		dao = null;
		
	}
	
	@Test
	public void testSalvar(){
		Banda banda = new Banda();
		banda.setNome("Banda 456+45");
		banda.setHistoria("Historia da banda");
		
		dao = new BandaDao(entityManager);
		dao.salvar(banda);		
	}
	
	@Test
	public void buscarBandaPorId(){
		
		Banda banda = dao.buscarPorId(1L);
		
	}
	
}
