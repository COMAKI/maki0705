CREATE TABLE T_HRD(
	TITLE VARCHAR2(200), --string	제목	<title></title>
	TITLE_ICON VARCHAR2(500), --string	제목 아이콘	<titleIcon></titleIcon>
	IMG_GUBUN	VARCHAR2(20), --string	제목 아이콘 구분	<imgGubun></imgGubun> 
	SUB_TITLE VARCHAR2(200), --string	부 제목	<subTitle></subTitle>
	ADDRESS	VARCHAR2(500), --string	주소	<address></address>
	TEL_NO	VARCHAR2(20), --string	전화번호	<telNo></telNo>
	CONTENTS	VARCHAR2(100), --string	컨텐츠	<contents></contents>
	SUPER_VISER	VARCHAR2(100),--string	주관부처	<superViser></superViser>
	TRAIN_TARGET VARCHAR2(50),	--string	주훈련대상	<trainTarget></trainTarget>
	YARD_MAN	VARCHAR2(5), --string	모집인원(정원)	<yardMan></yardMan>
	REAL_MAN	VARCHAR2(20), --string	실제훈련비	<realMan></realMan>
	COURSE_MAN	VARCHAR2(20),--string	정부지원금	<courseMan></courseMan>
	REG_COURSE_MAN	VARCHAR2(10), --string	수강신청 인원	<regCourseMan></regCourseMan>
	TRA_END_DATE	VARCHAR2(10), --string	훈련종료일자	<traEndDate></traEndDate>
	TRA_START_DATE	VARCHAR2(10), --string	훈련시작일자	<traStartDate></traStartDate>
	GRADE	VARCHAR2(20), --string	등급	<grade></grade>
	NCS_CD	VARCHAR2(20), --string	NCS_CD	<ncsCd></ncsCd>
	INST_CD	VARCHAR2(20), --string	훈련기관 코드	<instCd></instCd>
	TRPR_ID	VARCHAR2(30) NOT NULL, --string	훈련과정ID	<trprId></trprId>
	TRPR_DEGR VARCHAR2(5) NOT NULL, --string	훈련과정 순차	<trprDegr></trprDegr>
	CONSTRAINT PK_Hrd PRIMARY KEY (TRPR_ID,TRPR_DEGR)
); 