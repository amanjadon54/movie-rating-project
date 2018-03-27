package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import dao.UserDetailsDAO;


@Component
public class UserDetailsImpl implements UserDetailsDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private HibernateTemplate hibernateTemplate;  
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernarteTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void addUser(UserDet user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserDet> getAllUsers() {
		List<UserDet> list = sessionFactory.getCurrentSession().createQuery("from hibernateBeans.UserDet").list();
		return list;
	}
	
	@Transactional
	public void deleteUsers(Integer userId) {
		UserDet user = (UserDet)sessionFactory.getCurrentSession().load(UserDet.class, 1);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
        else
        {
        	System.out.println("user is null thats y nothing happened");
        }
		
	}
	
	@Transactional
	public UserDet updateUser(UserDet user) {
		sessionFactory.getCurrentSession().update(user);
        return user;
	}
	
	@Transactional
	public UserDet getUser(Integer userId) {
//		return (UserDet) sessionFactory.getCurrentSession().get(UserDet.class, userId);
		return hibernateTemplate.get(UserDet.class, userId);
	}
	
	@Transactional
	public void insertUser(UserDet user)
	{
		System.out.println("insert user from user detailsimpl got called");
		hibernateTemplate.save(user);
	}
	
	

}
