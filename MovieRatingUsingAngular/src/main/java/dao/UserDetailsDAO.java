package dao;

import java.util.List;

public interface UserDetailsDAO {

	public void addUser(UserDet user);
	 
    public List<UserDet> getAllUsers();
 
    public void deleteUsers(Integer userId);
 
    public UserDet updateUser(UserDet user);
 
    public UserDet getUser(Integer userId);
    
    public void insertUser(UserDet user);
}
