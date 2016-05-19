package com.jiang;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;

/**
 * Created by 17204 on 2016/5/19.
 */
public class LoginAction {
    private String name;
    private String pwd;
    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    public String execute() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(" from UserLoginEntity as u");
        java.util.List<UserLoginEntity> userLoginEntities = query.list();
        for (UserLoginEntity userLoginEntity : userLoginEntities) {
           if (userLoginEntity.getName().equals(name) && userLoginEntity.getPwd().equals(pwd)) {
                session.close();
               return "success";
            }
        }
        session.close();
        return "error";
    }

    public String regist(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        userLoginEntity.setName(name);
        userLoginEntity.setPwd(pwd);
        Query query = session.createQuery(" from UserLoginEntity as u where u.name=:name");
        query.setString("name",name);
        java.util.List<UserLoginEntity> userLoginEntities = query.list();
        if (userLoginEntities.isEmpty() == true){
            session.save(userLoginEntity);
            session.getTransaction().commit();
            session.close();
            return "success";
        }
        else {
            session.close();
            return "error";
        }

    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
