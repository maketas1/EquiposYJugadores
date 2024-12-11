package ejercicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class EquipoDAO {
    static EntityManager em;
    static EntityTransaction tx;

    public EquipoDAO(EntityManager em, EntityTransaction tx) {
        this.em = em;
        this.tx = tx;
    }

    public static List<Equipo> getAll() {
        tx.begin();
        List<Equipo> lista = em.createQuery("select e from Equipo e").getResultList();
        tx.commit();
        return lista;
    }

    public static Equipo getById(int id) {
        tx.begin();
        Equipo equipo = em.find(Equipo.class, id);
        tx.commit();
        return equipo;
    }

    public static void add(Equipo equipo) {
        tx.begin();
        em.persist(equipo);
        tx.commit();
    }

    public static void update(Equipo equipo) {
        tx.begin();
        em.merge(equipo);
        tx.commit();
    }

    public static void delete(Equipo equipo) {
        tx.begin();
        em.remove(equipo);
        tx.commit();
    }
}
