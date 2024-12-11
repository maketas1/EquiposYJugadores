package ejercicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidad-empresa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        EquipoDAO equipoDAO = new EquipoDAO(em, tx);
        Equipo equipo = new Equipo("real madrid", "bernabeu");
        Equipo equipo1 = new Equipo("ash ketchum", "pokemon");
        equipoDAO.add(equipo);
        equipoDAO.add(equipo1);
        System.out.println(equipoDAO.getAll());
        System.out.println(equipoDAO.getById(1));
        equipo.setNombre("pepe");
        equipoDAO.update(equipo);
        System.out.println(equipoDAO.getAll());

        equipo.setId(1);
        equipo1.setId(2);

        equipoDAO.delete(equipo);

        JugadorDAO jugadorDAO = new JugadorDAO(em, tx);
        Jugador jugador = new Jugador(1, "pikachu", 1.80F, 50F, equipo1);
        Jugador jugador1 = new Jugador(2, "charizard", 2.80F, 160F, equipo1);

        jugadorDAO.add(jugador);
        jugadorDAO.add(jugador1);
        System.out.println(jugadorDAO.getAll());
        System.out.println(jugadorDAO.getById(1));
        jugador1.setNombre("bulbasaur");
        jugadorDAO.update(jugador1);
        System.out.println(jugadorDAO.getAll());

        jugadorDAO.delete(jugador1);
    }
}
