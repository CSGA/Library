package library.model;

import java.util.ArrayList;

import library.factory.LoanFactory;
import library.specification.HasReachMaxSpecification;
import library.specification.LoanOnlyOneSpecification;

public class Member {
private String Id,Name;
private ArrayList<Loan> loans=new ArrayList<Loan>();
public ArrayList<Loan> getLoans() {
	return loans;
}
public void setLoans(ArrayList<Loan> loans) {
	this.loans = loans;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Loan FindCurrentLoanFor(Book book){
 	for(Loan loan:loans){
		if(loan.getBook().getId().equals(book.getId())){
			return loan;
		}
	}return null;
}

public final void Return(Book book){
	Loan loan=FindCurrentLoanFor(book);
	if (loan!=null){
		loan.MarkAsReturned();
		book.setLoanTo(null);
	}
}
public final boolean CanLoan(Book book){
	return book.getLoanTo()==null;
}
public final Loan Loan(Book book){
	Loan loan=null;
	if(CanLoan(book) && this.validate(book)){
		loan=LoanFactory.CreateLoan(book, this);
		System.out.println("����ɹ��������¼Ϊ��"+loan.getMember().getName()+"��"+loan.getLoanDate()+"���顶"+loan.getBook().getTitle()+"����Ӧ������Ϊ��"+loan.getDateForReturn());
		getLoans().add(loan);
		return loan;
	}else {
		System.out.print("����ʧ�ܣ�");
		return null;
	}
	
}

public boolean validate(Book wantBook ){
	HasReachMaxSpecification hs=new HasReachMaxSpecification();
	LoanOnlyOneSpecification ls=new LoanOnlyOneSpecification(wantBook);
	if(hs.IsSatisfiedBy(this)==false && ls.IsSatisfiedBy(this)){
		return true;
	}
	return false;
	
}


}
