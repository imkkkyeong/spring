package autowired;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	
	void insertUser();
	void updateUser();
	void getUser();
}
