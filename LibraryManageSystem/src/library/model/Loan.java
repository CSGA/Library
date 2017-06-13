package library.model;

import java.time.LocalDateTime;

public class Loan {
private String Id;
private LocalDateTime LoanDate,DateForReturn,ReturnDate;
private Book book;
private Member Member;
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public LocalDateTime getLoanDate() {
	return LoanDate;
}
public void setLoanDate(LocalDateTime loanDate) {
	LoanDate = loanDate;
}
public LocalDateTime getDateForReturn() {
	return DateForReturn;
}
public void setDateForReturn(LocalDateTime dateForReturn) {
	DateForReturn = dateForReturn;
}
public LocalDateTime getReturnDate() {
	return ReturnDate;
}
public void setReturnDate(LocalDateTime returnDate) {
	ReturnDate = returnDate;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public Member getMember() {
	return Member;
}
public void setMember(Member member) {
	Member = member;
}


public boolean HasNotBeenReturned(){
	return ReturnDate == null;
}
public void MarkAsReturned(){
	ReturnDate=LocalDateTime.now();
}
}
