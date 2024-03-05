package autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	// 내가 조립하고 싶은 객체의 타입과 멤버변수 지정
	
	@Autowired
	private UserDao userDao;

	// setter 메서드를 적는다. 
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	//dao에 조립 한 다음 사용할 꺼야. 본체에 모니터를 연결할 잭을 미리 만들어 놔
	public void 회원가입() {
		userDao.getUser();
		userDao.insertUser();
	}
	
}


// 그럼 그 모니터를 연결할 잭을 미리 만다는게 set메서드라는건가?