create table inofix_sb_SketchBoard (
	uuid_ VARCHAR(75) null,
	sketchBoardId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	configuration VARCHAR(75) null,
	setup VARCHAR(75) null
);