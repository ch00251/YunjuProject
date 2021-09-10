--회원 테이블
create table users(
	userId varchar2(50) not null,		--아이디
	userPass varchar2(100) not null,	--비밀번호
	userName varchar2(30) not null,		--이름
	userPhone varchar2(20) not null,	--전화번호
	email varchar2(100) not null,		--이메일
	userAddr1 varchar2(100) not null,	--주소1(우편번호)
	userAddr2 varchar2(100) not null,	--주소2(기본주소)
	userAddr3 varchar2(100) not null,	--주소3(나머지주소)
	regidate date default sysdate,		--회원가입날짜
	birthday date not null,				--생일
	point number default 2000,			--포인트(기본값 2000(회원가입 축하))
	verify number default 0,			--회원 구분(0은 일반회원, 1은 직원)
	primary key(userId)
);

create sequence user_seq;