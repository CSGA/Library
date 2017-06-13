package library.specification;

import java.util.ArrayList;

import library.model.Loan;
import library.model.Member;

public class HasReachMaxSpecification implements Specification{

	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		ArrayList<Loan> loans=new ArrayList<Loan>();
		loans=member.getLoans();
		int i=0;
		for(Loan loan:loans){
			if(loan.getReturnDate()==null){
				i++;
			}}
			if(i<3){	
				return false;
			}	
	System.out.print("超出借书上限三本！");	
	return true;
	}
	
	
	}
	
	

