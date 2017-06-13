package library.specification;

import library.model.Member;

public interface Specification {
	public boolean IsSatisfiedBy(Member member);
}
