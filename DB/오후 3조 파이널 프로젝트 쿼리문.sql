﻿-- 계정 생성

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER CHANNEL_KGV IDENTIFIED BY 1234;

GRANT CONNECT, RESOURCE TO CHANNEL_KGV;

ALTER USER CHANNEL_KGV DEFAULT TAbLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

DROP USER CHANNEL_KGV CASCADE;

SELECT * FROM ALL_USERS;

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "USER" (
	"USER_NO"	NUMBER(10)		NOT NULL,
	"USER_EMAIL"	VARCHAR2(100)		NOT NULL,
	"USER_PW"	VARCHAR2(500)		NOT NULL,
	"USER_NAME"	VARCHAR2(10)		NOT NULL,
	"USER_NICKNAME"	VARCHAR2(50)		NOT NULL,
	"USER_TEL"	NUMBER(11)		NOT NULL,
	"USER_ADDR"	VARCHAR2(500)		NULL,
	"USER_BIRTH"	DATE		NULL,
	"USER_GENDER"	CHAR(1)		NULL,
	"USER_REGDATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"USER_DELETE"	DATE	DEFAULT SYSDATE	NULL,
	"USER_ST"	CHAR(1)	DEFAULT 'Y'	NOT NULL,
	"USER_IMG"	VARCHAR2(500)		NULL,
	"USER_POINT"	NUMBER(11)	DEFAULT 0	NULL,
	"USER_SNS"	CHAR(1)	DEFAULT 'N'	NULL,
	"USER_CHANGE"	DATE		NULL
);

ALTER TABLE "USER" ADD CONSTRAINT "PK_USER" PRIMARY KEY (
	"USER_NO"
);

COMMENT ON COLUMN "USER"."USER_NO" IS '회원번호';

COMMENT ON COLUMN "USER"."USER_EMAIL" IS '이메일 주소 = 아이디 / 최소 6자리에서 최대 16자리, 숫자, 영어(대소문자), 특수문자(_ ! @ #$))';

COMMENT ON COLUMN "USER"."USER_PW" IS '비밀번호, 6 ~ 20자리, 숫자, 영어(대소문자), 특수문자(_ ! @ #$))';

COMMENT ON COLUMN "USER"."USER_NAME" IS '한글로만, 최소 2자리에서 최대 10자리';

COMMENT ON COLUMN "USER"."USER_TEL" IS '전화번호는 - 제외 11자리 / 휴대폰 번호만 허용';

COMMENT ON COLUMN "USER"."USER_ADDR" IS '주소, 카카오 API에서 가져오는거 저장';

COMMENT ON COLUMN "USER"."USER_BIRTH" IS '생일마다 쿠폰?? 이라고 생각해 봅니다. YYYY-MM-DD hh:mm:ss';

COMMENT ON COLUMN "USER"."USER_GENDER" IS '남자 / 여자 / 선택안함 중 1개만 찍히게끔';

COMMENT ON COLUMN "USER"."USER_REGDATE" IS '회원이 가입한 날이 찍히게끔, YYYY-MM-DD hh:mm:ss';

COMMENT ON COLUMN "USER"."USER_ST" IS '활동중 : Y / 탈퇴 또는 휴면 : N';

COMMENT ON COLUMN "USER"."USER_CHANGE" IS 'YYYY-MM-DD hh:mm:ss';


-- ===========================================================================
-- ===========================================================================


CREATE TABLE "MOVIE" (
	"MOVIE_NO"	NUMBER(10)		NOT NULL,
	"MOVIE_RUNTIME"	VARCHAR2(50)		NOT NULL,
	"MOVIE_TITLE"	VARCHAR2(100)		NOT NULL,
	"MOVIE_NATION"	VARCHAR2(100)		NOT NULL,
	"MOVIE_OPEN"	DATE	DEFAULT SYSDATE	NOT NULL,
	"MOVIE_GRADE"	VARCHAR2(20)		NOT NULL,
	"MOVIE_CONTENT"	VARCHAR2(3000)		NOT NULL,
	"MOVIE_IMG"	VARCHAR2(500)		NOT NULL,
	"MOVIE_PLAYED"	NUMBER(11)		NOT NULL,
	"MOVIE_WATCHED"	NUMBER(11)		NOT NULL,
	"MOVIE_REGDATE"	DATE	DEFAULT SYSDATE	NULL,
	"MOVIE_UPLOADER"	VARCHAR2(50)		NULL,
	"MOVIE_FIXDATE"	DATE	DEFAULT SYSDATE	NULL,
	"MOVIE_CHANGER"	VARCHAR2(50)		NULL,
	"GENRE_CODE"	NUMBER(10)		NOT NULL
);

ALTER TABLE "MOVIE" ADD CONSTRAINT "PK_MOVIE" PRIMARY KEY (
	"MOVIE_NO"
);

COMMENT ON COLUMN "MOVIE"."MOVIE_NO" IS '영화번호';

COMMENT ON COLUMN "MOVIE"."MOVIE_OPEN" IS 'YYYY-MM-DD hh:mm:ss';

COMMENT ON COLUMN "MOVIE"."MOVIE_GRADE" IS '전체이용가/12세/15세/18세/제한';

COMMENT ON COLUMN "MOVIE"."MOVIE_CONTENT" IS '영화 줄거리.. 최대 300자까지 저장?';

COMMENT ON COLUMN "MOVIE"."MOVIE_REGDATE" IS 'YYYY-MM-DD hh:mm:ss';

COMMENT ON COLUMN "MOVIE"."MOVIE_FIXDATE" IS 'YYYY-MM-DD hh:mm:ss';

COMMENT ON COLUMN "MOVIE"."GENRE_CODE" IS 'A001, A002 ...';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "PLAY" (
	"PLAY_NO"	NUMBER(10)		NOT NULL,
	"MOVIE_NO"	NUMBER(10)		NOT NULL,
	"SCREEN_NO"	NUMBER(10)		NOT NULL,
	"PLAY_START"	DATE		NOT NULL,
	"PLAY_END"	DATE		NOT NULL,
	"PLAY_REGDATE"	DATE	DEFAULT SYSDATE	NULL,
	"PLAY_UPLOADER"	VARCHAR2(50)		NULL,
	"PLAY_FIXDATE"	DATE	DEFAULT SYSDATE	NULL,
	"PLAY_CHANGER"	VARCHAR2(50)		NULL
);

ALTER TABLE "PLAY" ADD CONSTRAINT "PK_PLAY" PRIMARY KEY (
	"PLAY_NO"
);

COMMENT ON COLUMN "PLAY"."MOVIE_NO" IS '영화번호';

COMMENT ON COLUMN "PLAY"."PLAY_START" IS 'YYYY-MM-DD hh:mm:ss';

COMMENT ON COLUMN "PLAY"."PLAY_END" IS 'YYYY-MM-DD hh:mm:ss';

COMMENT ON COLUMN "PLAY"."PLAY_REGDATE" IS 'YYYY-MM-DD hh:mm:ss';

COMMENT ON COLUMN "PLAY"."PLAY_FIXDATE" IS 'YYYY-MM-DD hh:mm:ss';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "SCREEN" (
	"SCREEN_NO"	NUMBER(10)		NOT NULL,
	"SCREEN_NAME"	VARCHAR2(500)		NOT NULL,
	"SCREEN_STYLE"	VARCHAR2(50)		NOT NULL,
	"SCREEN_SEAT"	NUMBER(3)		NOT NULL
);

ALTER TABLE "SCREEN" ADD CONSTRAINT "PK_SCREEN" PRIMARY KEY (
	"SCREEN_NO"
);

COMMENT ON COLUMN "SCREEN"."SCREEN_STYLE" IS '3D/좌식/입식/와식/석식/중식/양식/한식...';

COMMENT ON COLUMN "SCREEN"."SCREEN_SEAT" IS '좌석 수';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "REVIEW" (
	"REV_NO"	NUMBER(10)		NOT NULL,
	"MOVIE_NO"	NUMBER(10)		NOT NULL,
	"USER_NO"	NUMBER(10)		NOT NULL,
	"REV_CONTENT"	VARCHAR2(1000)		NOT NULL,
	"REV_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"REV_LIKE"	NUMBER(10)		NOT NULL,
	"REV_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"REV_FIXED"	DATE	DEFAULT SYSDATE	NULL
);

ALTER TABLE "REVIEW" ADD CONSTRAINT "PK_REVIEW" PRIMARY KEY (
	"REV_NO"
);

COMMENT ON COLUMN "REVIEW"."REV_NO" IS '한 영화당 리뷰 1개';

COMMENT ON COLUMN "REVIEW"."MOVIE_NO" IS '영화번호';

COMMENT ON COLUMN "REVIEW"."USER_NO" IS '회원번호';

COMMENT ON COLUMN "REVIEW"."REV_CONTENT" IS '최소 1글자, 최대 300글자';

COMMENT ON COLUMN "REVIEW"."REV_ST" IS '작성 시 Y / 미작성시 N? 별점?';

COMMENT ON COLUMN "REVIEW"."REV_LIKE" IS '다른 사람이 내 후기에 좋아요';

COMMENT ON COLUMN "REVIEW"."REV_DATE" IS 'YYYY-MM-DD hh:mm:ss';

COMMENT ON COLUMN "REVIEW"."REV_FIXED" IS 'YYYY-MM-DD hh:mm:ss';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "LIKE" (
	"LIKE_NO"	NUMBER(10)		NOT NULL,
	"USER_NO"	NUMBER(10)		NOT NULL,
	"MOVIE_NO"	NUMBER(10)		NOT NULL
);

ALTER TABLE "LIKE" ADD CONSTRAINT "PK_LIKE" PRIMARY KEY (
	"LIKE_NO"
);

COMMENT ON COLUMN "LIKE"."USER_NO" IS '회원번호';

COMMENT ON COLUMN "LIKE"."MOVIE_NO" IS '영화번호';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "GENRE" (
	"GENRE_NO"	NUMBER(10)		NOT NULL,
	"GENRE_CODE"	NUMBER(10)		NOT NULL,
	"GENRE_NAME"	VARCHAR2(50)		NOT NULL
);

ALTER TABLE "GENRE" ADD CONSTRAINT "PK_GENRE" PRIMARY KEY (
	"GENRE_NO"
);

COMMENT ON COLUMN "GENRE"."GENRE_CODE" IS 'A001, A002 ...';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "SNS" (
	"SNS_NO"	NUMBER(4)		NOT NULL,
	"USER_NO"	NUMBER(10)		NOT NULL,
	"SNS_CAT"	VARCHAR2(50)		NULL,
	"SNS_ID"	VARCHAR2(100)		NULL
);

ALTER TABLE "SNS" ADD CONSTRAINT "PK_SNS" PRIMARY KEY (
	"SNS_NO"
);

COMMENT ON COLUMN "SNS"."SNS_NO" IS 'SEQ';

COMMENT ON COLUMN "SNS"."USER_NO" IS '회원번호';

COMMENT ON COLUMN "SNS"."SNS_CAT" IS '카카오/네이버';

COMMENT ON COLUMN "SNS"."SNS_ID" IS 'abc@naver.com';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "SEAT" (
	"SEAT_ID"	NUMBER(10)		NOT NULL,
	"SEAT_NUMBER"	VARCHAR2(10)		NOT NULL,
	"SEAT_TYPE"	VARCHAR2(50)		NOT NULL,
	"SCREEN_NO"	NUMBER(10)		NOT NULL,
	"SP_NO"	NUMBER(10)		NOT NULL,
	"DA_NO"	NUMBER(10)		NOT NULL
);

ALTER TABLE "SEAT" ADD CONSTRAINT "PK_SEAT" PRIMARY KEY (
	"SEAT_ID"
);

COMMENT ON COLUMN "SEAT"."SEAT_NUMBER" IS '8석';

COMMENT ON COLUMN "SEAT"."SEAT_TYPE" IS '일반석 / 커플석 / 장애인석';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "ASK" (
	"ASK_NO"	NUMBER(4)		NOT NULL,
	"USER_NO"	NUMBER(4)		NOT NULL,
	"ASK_TITLE"	VARCHAR2(100)		NOT NULL,
	"ASK_CONTENT"	VARCHAR2(3000)		NOT NULL,
	"ASK_FILE"	VARCHAR2(1000)		NULL
);

ALTER TABLE "ASK" ADD CONSTRAINT "PK_ASK" PRIMARY KEY (
	"ASK_NO"
);

COMMENT ON COLUMN "ASK"."USER_NO" IS '회원번호';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "EVENT" (
	"EVENT_NO"	NUMBER(4)		NOT NULL,
	"USER_NO"	NUMBER(10)		NOT NULL,
	"BOOK_NO"	NUMBER(4)		NOT NULL,
	"EVENT_TITLE"	VARCHAR2(500)		NULL,
	"EVENT_CONTENT"	VARCHAR2(500)		NULL,
	"EVENT_START"	DATE		NULL,
	"EVENT_END"	DATE		NULL,
	"EVENT_STATUS"	CHAR(1)		NOT NULL
);

ALTER TABLE "EVENT" ADD CONSTRAINT "PK_EVENT" PRIMARY KEY (
	"EVENT_NO"
);

COMMENT ON COLUMN "EVENT"."USER_NO" IS '회원번호';

COMMENT ON COLUMN "EVENT"."EVENT_STATUS" IS '등록 Y / 숨기기 N';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "DISCOUNT" (
	"DISCOUNT_NO"	NUMBER(4)		NOT NULL,
	"BOOK_NO"	NUMBER(10)		NOT NULL,
	"DISCOUNT_DAY"	VARCHAR2(20)		NULL,
	"DISCOUNT_TIME"	DATE		NULL,
	"DISCOUNT_DATE"	DATE		NULL,
	"DISCOUNT_RATE"	NUMBER(2)		NOT NULL
);

ALTER TABLE "DISCOUNT" ADD CONSTRAINT "PK_DISCOUNT" PRIMARY KEY (
	"DISCOUNT_NO"
);


COMMENT ON COLUMN "DISCOUNT"."DISCOUNT_DAY" IS '월 ~ 일 까지 모두 넣기';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "DISCOUNT_ADD" (
	"DA_NO"	NUMBER(10)		NOT NULL,
	"DA_TITLE"	VARCHAR2(50)		NOT NULL,
	"DA_RATE"	NUMBER(2)		NOT NULL
);

ALTER TABLE "DISCOUNT_ADD" ADD CONSTRAINT "PK_DISCOUNT_ADD" PRIMARY KEY (
	"DA_NO"
);

COMMENT ON COLUMN "DISCOUNT_ADD"."DA_TITLE" IS '청소년, 경로, 우대';

COMMENT ON COLUMN "DISCOUNT_ADD"."DA_RATE" IS '% 또는 숫자';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "SEAT_PRICE" (
	"SP_NO"	NUMBER(10)		NOT NULL,
	"SP_TITLE"	VARCHAR2(50)		NOT NULL,
	"SP_RATE"	NUMBER(2)		NOT NULL
);

ALTER TABLE "SEAT_PRICE" ADD CONSTRAINT "PK_SEAT_PRICE" PRIMARY KEY (
	"SP_NO"
);

COMMENT ON COLUMN "SEAT_PRICE"."SP_TITLE" IS '일반석 / 커플석 / 장애인석';

COMMENT ON COLUMN "SEAT_PRICE"."SP_RATE" IS '숫자 / %는 제외';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "BOOK" (
	"BOOK_NO"	NUMBER(10)		NOT NULL,
	"USER_NO"	NUMBER(10)		NOT NULL,
	"PLAY_NO"	NUMBER(10)		NOT NULL,
	"SEAT_ID"	NUMBER(10)		NOT NULL,
	"BOOK_DT"	DATE		NOT NULL,
	"BOOK_BEFORE"	NUMBER(10)	DEFAULT 0	NULL,
	"BOOK_DISCOUNT"	NUMBER(10)	DEFAULT 0	NULL,
	"BOOK_PRICE"	NUMBER(10)		NOT NULL,
	"BOOK_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL
);

ALTER TABLE "BOOK" ADD CONSTRAINT "PK_BOOK" PRIMARY KEY (
	"BOOK_NO"
);

COMMENT ON COLUMN "BOOK"."USER_NO" IS '회원번호';

COMMENT ON COLUMN "BOOK"."BOOK_DT" IS 'YYYY-MM-DD hh:mm:ss';

COMMENT ON COLUMN "BOOK"."BOOK_PRICE" IS '최종 결제 금액 = 기본 금액 - 할인액';

COMMENT ON COLUMN "BOOK"."BOOK_ST" IS '결제가 된 경우 Y / 아니면 N / 취소 C  // 생각해보기';

-- ===========================================================================
-- ===========================================================================


CREATE TABLE "FREQ" (
	"FREQ_NO"	NUMBER(4)		NOT NULL,
	"FREQ_TITLE"	VARCHAR2(100)		NOT NULL,
	"FREQ_CONTENT"	VARCHAR2(3000)		NOT NULL,
	"FREQ_FILE"	VARCHAR2(500)		NULL,
	"FREQ_REGDATE"	DATE		NULL,
	"FREQ_UPLOADER"	VARCHAR2(100)		NULL,
	"FREQ_FIXDATE"	DATE		NULL,
	"FREQ_CHANGER"	VARCHAR2(100)		NULL,
	"FREQ_STATUS"	CHAR(1)	DEFAULT 'Y'	NOT NULL
);

ALTER TABLE "FREQ" ADD CONSTRAINT "PK_FREQ" PRIMARY KEY (
	"FREQ_NO"
);

COMMENT ON COLUMN "FREQ"."FREQ_STATUS" IS '등록 Y / 숨기기 N';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "NOTICE" (
	"NOTICE_NO"	NUMBER(4)		NOT NULL,
	"NOTICE_TITLE"	VARCHAR2(100)		NOT NULL,
	"NOTICE_CONTENT"	VARCHAR2(3000)		NOT NULL,
	"NOTICE_FILE"	VARCHAR2(500)		NULL,
	"NOTICE_REGDATE"	DATE		NULL,
	"NOTICE_UPLOADER"	VARCHAR2(100)		NULL,
	"NOTICE_FIXDATE"	DATE		NULL,
	"NOTICE_CHANGER"	VARCHAR2(100)		NULL,
	"NOTICE_STATUS"	CHAR(1)	DEFAULT 'Y'	NOT NULL
);

ALTER TABLE "NOTICE" ADD CONSTRAINT "PK_NOTICE" PRIMARY KEY (
	"NOTICE_NO"
);

COMMENT ON COLUMN "NOTICE"."NOTICE_STATUS" IS '등록 Y / 숨기기 N';

-- ===========================================================================
-- ===========================================================================

CREATE TABLE "MANAGER" (
	"MANAGER_NO"	NUMBER(4)		NOT NULL,
	"MANAGER_ID"	VARCHAR2(100)		NOT NULL,
	"MANAGER_PW"	VARCHAR2(500)		NOT NULL,
	"MANAGER_NAME"	VARCHAR2(20)		NOT NULL,
	"MANAGER_PROFILE"	VARCHAR2(500)		NULL
);

ALTER TABLE "MANAGER" ADD CONSTRAINT "PK_MANAGER" PRIMARY KEY (
	"MANAGER_NO"
);

-- ===========================================================================
-- ===========================================================================


--시퀀스 18개;

CREATE SEQUENCE SEQ_USER_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_LIKE_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_REV_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_BOOK_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_MOVIE_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_TYPE_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_SCREEN_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_PLAY_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_SEAT_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_SNS_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_EVENT_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_ASK_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_FREQ_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_SP_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_NOTICE_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_DISCOUNT_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_DA_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
CREATE SEQUENCE SEQ_MANAGER_NO INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999 NOCYCLE NOCACHE NOORDER;
COMMIT;


-- ===========================================================================
-- ===========================================================================






























