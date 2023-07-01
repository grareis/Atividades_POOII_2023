package controler;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Automovel;
import entities.Marca;
import entities.Modelo;

public class Teste {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Marca marca = new Marca();
        marca.setNome("Marca 1");

        Modelo modelo = new Modelo();
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
    
        session.getTransaction().commit();
        session.close();
    }
}
