package com.example.user.myapp5.member;

/**
 * Created by jjjnag on 2016-06-16.
 */
public interface MemberService {
    public String signup(MemberBean member);
    public MemberBean login(MemberBean member);
    public MemberBean update(MemberBean member);
    public String delete(MemberBean member);
}
