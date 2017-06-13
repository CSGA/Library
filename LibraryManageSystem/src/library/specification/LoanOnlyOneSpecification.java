package library.specification;

import java.util.ArrayList;

import library.model.Book;
import library.model.Loan;
import library.model.Member;

public class LoanOnlyOneSpecification implements Specification {

	private Book wantBook;
	
	public Book getWantBook() {
		return wantBook;
	}

	public void setWantBook(Book wantBook) {
		this.wantBook = wantBook;
	}

	
	public LoanOnlyOneSpecification(Book wantBook) {
		super();
		this.wantBook = wantBook;
	}

	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		ArrayList<Loan> loans=new ArrayList<Loan>();
		loans=member.getLoans();
		for(Loan loan:loans){
			if(loan.getBook().getISBN()==wantBook.getISBN() && loan.getReturnDate()==null){
				System.out.print("同一书只能借一本！");
				return false;
			}
		}				
		return true;
	}

}
