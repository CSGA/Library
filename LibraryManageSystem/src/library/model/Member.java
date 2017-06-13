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
		System.out.println("借书成功！借书记录为："+loan.getMember().getName()+"于"+loan.getLoanDate()+"借书《"+loan.getBook().getTitle()+"》，应还日期为："+loan.getDateForReturn());
		getLoans().add(loan);
		return loan;
	}else {
		System.out.print("借书失败！");
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
