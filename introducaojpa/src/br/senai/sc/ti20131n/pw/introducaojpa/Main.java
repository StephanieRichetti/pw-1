package br.senai.sc.ti20131n.pw.introducaojpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.senai.sc.ti20131n.pw.introducaojpa.entity.Banda;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("introducaojpa_pu");

		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		Scanner scanner = new Scanner(System.in);
		Banda banda;

		for (int i = 0; i < 2; i++) {
			banda = new Banda();

			System.out.println("Nome da banda");
			banda.setNome(scanner.nextLine());

			// System.out.println("Historia");

			entityManager.getTransaction().begin();
			entityManager.persist(banda);
			entityManager.getTransaction().commit();
		}
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
