import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

import model.Groups;
import model.Resource;
import model.User;

public class App {

    public static void main( String[] args )
    {
	Resource r1 = new Resource();
	r1.setrId(2);
	r1.setrName("Pantry");
	r1.setrPermissions("Enter");
	
	JSONObject res=new JSONObject();    
	res.put("rId",11);    
	res.put("rName","Pantry");    
	res.put("rPermission","Enter");    
	
	Groups g1=new Groups();
	g1.setgId("GP1");
	g1.setgName("Senior Employees");
	g1.setgDescription("Access to maximum things");
	g1.setgResource(res.toString());
	g1.setgArbitraryAttributes(res.toString());
	List<Groups> gList = new ArrayList<Groups>();
	gList.add(g1);
	
	//mandatory attribute
	JSONObject manAtt=new JSONObject();    
	manAtt.put("email","nishant@gmail.com");    
	
	//arbt attribute
	JSONObject arbAtt=new JSONObject();    
	arbAtt.put("bakwas","blahblah"); 
		
	User u1=new User();
	u1.setuId("EMP01");
	u1.setuName("Aditi Giri");
	u1.setuPassword("Hello");
	u1.setuGroups(gList);
	u1.setuResource(res.toString());
	u1.setuMandatoryAttributes(manAtt.toString());
	u1.setuArbitraryAttributes(arbAtt.toString());
	
	
	Configuration com = new Configuration().configure().addAnnotatedClass(Resource.class).addAnnotatedClass(User.class).addAnnotatedClass(Groups.class);
    SessionFactory sf = com.buildSessionFactory();
    Session session = sf.openSession();
    Transaction t = session.beginTransaction();
    session.save(r1);
    session.save(g1);
    session.save(u1);
    t.commit();
    session.close();
    }
}
