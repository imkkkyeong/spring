package ioc;
/**
 * ProductDao 인터페이스를 구현한 클래스이다.
 * JDBC기술을 이용해서 ProductDao인터페이스에 정의한 기능을 구현하였다.
 * 
 * @author nakyeong
 *
 */
public class ProductJdbcDao implements ProductDao {
	
	@Override
	public void insertProduct() {
		System.out.println("JDBC기술을 이용해서 상품정보를 저장한다");
		
	}
	@Override
	
	public void getProduct() {
		System.out.println("JDBC기술을 이용해서 상품정보를 조회한다");
	}
	
	
	@Override
	public void updateProduct() {
		System.out.println("JDBC기술을 이용해서 상품정보를 변경한다");
		
	}
}
