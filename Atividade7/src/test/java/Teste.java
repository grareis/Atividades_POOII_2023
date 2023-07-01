import java.io.IOException;

import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import entities.Automovel;
import entities.Marca;
import entities.Modelo;
import jakarta.websocket.Session;

public class Teste {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
       
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
       
        Session session = (Session) sessionFactory.openSession();
        ((SharedSessionContract) session).beginTransaction();

        Marca marca = new Marca(1, "Tucson");
        marca.setNome("Marca 1");

        Modelo modelo = new Modelo(1,"Tucson" , 2, "Audi");
        modelo.setDescricao("Modelo 1");
        modelo.setPotencia(150);
        modelo.setMarca(marca);

        Automovel automovel = new Automovel();
        automovel.setAnoFabricacao(2021);
        automovel.setAnoModelo(2022);
        automovel.setObservacoes("Nenhuma observação");
        automovel.setPreco(50000.0);
        automovel.setQuilometragem(10000);
        automovel.setModelo(modelo);
        
        ((org.hibernate.Session) session).save(marca);
        ((org.hibernate.Session) session).save(modelo);
        ((org.hibernate.Session) session).save(automovel);

        ((SharedSessionContract) session).getTransaction().commit();
        session.close();
    }
}
