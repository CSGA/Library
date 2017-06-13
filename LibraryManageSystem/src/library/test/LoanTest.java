package library.test;
import org.junit.Test;
import library.model.Book;
import library.model.Member;

public class LoanTest {
	@Test
	public void test() {
		Member m1=new Member();
		m1.setId("m01");
		m1.setName("张三");
		Book b1=new Book("b01","978-7-111-47950-5","系统分析与设计");
		Book b2=new Book("b02","978-7-5641-1421-3","深入浅出面向对象分析与设计");
		Book b3=new Book("b03","978-7-115-37675-6","领域驱动设计:软件核心复杂性应对之道");
		Book b4=new Book("b04","978-7-111-47950-5","系统分析与设计");
		Book b5=new Book("b05","978-7-111-47950-1","Java语言基础");
		
		m1.Loan(b1);
		m1.Loan(b2);
		m1.Loan(b3);
		m1.Loan(b5);
	}	
}
