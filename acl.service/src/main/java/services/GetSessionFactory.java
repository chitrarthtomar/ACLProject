package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetSessionFactory {
	@Autowired
	private static SessionFactory sessionFactory;
	
	private GetSessionFactory() {}
	
	public static SessionFactory createSessionFactory() {
		if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
            registry.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
             
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }
         
        return sessionFactory;
    }
	
	public Session startSession(SessionFactory sf) {
		return sf.openSession();
	}
}
