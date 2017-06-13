package library.model;

import java.lang.reflect.Member;

public class Book {
private String Id,ISBN,Title;


public Book(String id, String iSBN, String title) {
	super();
	Id = id;
	ISBN = iSBN;
	Title = title;
}

public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public String getISBN() {
	return ISBN;
}

public void setISBN(String iSBN) {
	ISBN = iSBN;
}

public String getTitle() {
	return Title;
}

public void setTitle(String title) {
	Title = title;
}
private Member LoanTo;

public Member getLoanTo() {
	return LoanTo;
}

public void setLoanTo(Member member) {
	LoanTo = member;
}

}
