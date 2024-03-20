package application;

import dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Program {
    public static void main(String[] args){
//        Pessoa p1 = new Pessoa(null, "Carlos", " carlos@gmail.com");
//        Pessoa p2 = new Pessoa(null, "Maria", " Maria@gmail.com");
//        Pessoa p3 = new Pessoa(null, "Antonio", " Antonio@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        //Salvando no banco de dados
//        em.getTransaction().begin();
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);
//        em.getTransaction().commit();

        // Buscando por Id
        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);

        //removendo do banco por Id
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Pronto!");
        em.close();
        emf.close();
    }
}