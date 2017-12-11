package br.com.fiap.netgifx.init;

import java.io.InputStream;

import br.com.fiap.netgifx.dao.GenericDAO;
import br.com.fiap.netgifx.dao.GifDAO;
import br.com.fiap.netgifx.entity.Gif;
import br.com.fiap.netgifx.entity.Session;
import br.com.fiap.netgifx.entity.User;
import br.com.fiap.netgifx.listener.LocalEntityManagerFactory;

public class Main {
	
	public static void main(String[] args) {
		new LocalEntityManagerFactory().contextInitialized(null);
		initDataBase();
		new LocalEntityManagerFactory().contextDestroyed(null);
	}

	private static void initDataBase() {
		System.out.println("Carga inicial de dados");
		try {
			System.out.println("Verificar usuario admin");
			GenericDAO<User> userDAO = new GenericDAO<>(User.class);
			User user = userDAO.find("select u from User u where u.login = ?", "admin");
			if (user == null) {
				user = new User("admin@gmail.com", "admin", "Admin", true);
				userDAO.save(user);
			}
			System.out.println("Verificar sessions");
			GenericDAO<Session> sessionDAO = new GenericDAO<>(Session.class);
			Session session = sessionDAO.find(1);
			if (session == null) {
				session = new Session("Exemplo");
				sessionDAO.save(session);
			}
			
			GifDAO gifDAO = new GifDAO();
			Gif gif = gifDAO.find(1);
			if (gif == null) {
				InputStream is = Main.class.getResourceAsStream("/example1.gif");
				gif = new Gif("Kill me", session, is);
				gifDAO.save(gif);
				is =  Main.class.getResourceAsStream("/example2.gif");
				gif = new Gif("Orcas", session, is);
				gifDAO.save(gif);
			}
		} catch (Exception e) {
			
		}
	}

}
