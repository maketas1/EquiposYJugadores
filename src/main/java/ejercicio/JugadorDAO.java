package ejercicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class JugadorDAO {
    static EntityManager em;
    static EntityTransaction tx;

    public JugadorDAO(EntityManager em, EntityTransaction tx) {
        this.em = em;
        this.tx = tx;
    }

    public static List<Jugador> getAll() {
        tx.begin();
        List<Jugador> lista = em.createQuery("select j from Jugador j").getResultList();
        tx.commit();
        return lista;
    }

    public static Jugador getById(int id) {
        tx.begin();
        Jugador jugador = em.find(Jugador.class, id);
        tx.commit();
        return jugador;
    }

    public static void add(Jugador jugador) {
        tx.begin();
        em.persist(jugador);
        tx.commit();
    }

    public static void update(Jugador jugador) {
        tx.begin();
        em.merge(jugador);
        tx.commit();
    }

    public static void delete(Jugador jugador) {
        tx.begin();
        em.remove(jugador);
        tx.commit();
    }
}
