package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hibernateBeans.UserDet;


@Component
public class UserDetailsImpl implements UserDetailsDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(UserDet user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}
	@SuppressWarnings("unchecked")
	public List<UserDet> getAllUsers() {
		List<UserDet> list = sessionFactory.getCurrentSession().createQuery("from UserDetails").list();
		return list;
	}

	public void deleteUsers(Integer userId) {
		UserDet user = (UserDet)sessionFactory.getCurrentSession().load(UserDet.class, userId);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
		
	}

	public UserDet updateUser(UserDet user) {
		sessionFactory.getCurrentSession().update(user);
        return user;
	}

	public UserDet getUser(Integer userId) {
		return (UserDet) sessionFactory.getCurrentSession().get(UserDet.class, userId);
	}
	@Override
	public void addUser(UserDet user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public UserDet updateUser(UserDet user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserDet getUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
