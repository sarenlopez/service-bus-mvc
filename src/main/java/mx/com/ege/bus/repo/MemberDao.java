package mx.com.ege.bus.repo;

import java.util.List;

import mx.com.ege.bus.domain.Member;

public interface MemberDao
{
    public Member findById(Long id);

    public Member findByEmail(String email);

    public List<Member> findAllOrderedByName();

    public void register(Member member);
}
