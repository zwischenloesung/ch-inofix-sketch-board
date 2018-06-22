create index IX_E788AD86 on inofix_sb_SketchBoard (groupId);
create index IX_AEB38098 on inofix_sb_SketchBoard (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8FD34D1A on inofix_sb_SketchBoard (uuid_[$COLUMN_LENGTH:75$], groupId);