
DROP TABLE IF EXISTS student,marks,studentgroup,subject,teacher;

CREATE TABLE IF NOT EXISTS studentgroup
(
    groupid varchar(255)  NOT NULL,
    groupname varchar(255) not null,
    CONSTRAINT studentgroup_pkey PRIMARY KEY (groupid)
)
;
commit ;

CREATE TABLE IF NOT EXISTS student
(
    student_id varchar(255) NOT NULL,
    age integer NOT NULL,
    rep_date timestamp without time zone,
    firstname  varchar(255) not null,
    surname varchar(255) not null,
    groupid varchar(255) not null,
    CONSTRAINT student_pkey PRIMARY KEY (student_id)
--    CONSTRAINT student_groupid_fk FOREIGN KEY (groupid)
--        REFERENCES studentgroup (groupid)
)
;
commit ;

CREATE TABLE IF NOT EXISTS teacher
(
    teacher_id varchar(255)  NOT NULL,
    age integer NOT NULL,
    firstname varchar(255) NOT NULL,
    surname varchar(255) NOT NULL,
    subject_id varchar(255)  NULL,
    CONSTRAINT teacher_pkey PRIMARY KEY (teacher_id)
)
;
commit ;


CREATE TABLE IF NOT EXISTS subject
(
    subject_id varchar(255)  NOT NULL,
    subjectname varchar(255) null,
    marks_id varchar(255) null,
    teacher_id varchar(255) null,
    CONSTRAINT subject_pkey PRIMARY KEY (subject_id)
--    CONSTRAINT fkdvgvxo0oxhxeepkkwug7vg4w4 FOREIGN KEY (teacher_id)
--        REFERENCES teacher (teacher_id)
)
;
commit ;

CREATE TABLE IF NOT EXISTS marks
(
    mark_id varchar(255)  NOT NULL,
    mark integer NOT NULL,
    student_id varchar(255) not null,
    subject_id varchar(255)  null,
    CONSTRAINT marks_pkey PRIMARY KEY (mark_id)
--    CONSTRAINT marks_student_fk FOREIGN KEY (student_id)
--        REFERENCES student (student_id) ,
--    CONSTRAINT marks_subject_fk FOREIGN KEY (subject_id)
--        REFERENCES subject (subject_id)
)
;
commit;

insert into studentgroup (groupid,groupname)
values
('ID-1','GROUP_1'),
('ID-2','GROUP_2')
;

insert into student (student_id, age, rep_date, firstname, surname, groupid)
values
('STUDENT_1', 50, now(), 'John', 'Bom', 'ID-1'),
('STUDENT_2', 25, now(), 'Cristofer', 'Columb', 'ID-1'),
('STUDENT_3', 30, now(), 'Kiano', 'Rivz', 'ID-2'),
('STUDENT_4', 40, now(), 'Vin', 'Diesel', 'ID-2'),
('STUDENT_5',  34, now(), 'Van', 'Gog', 'ID-2')
;

insert into teacher (teacher_id,age,firstname,surname,subject_id)
values
('TEACHER_1', 30, 'Malo', 'Salo', 'SUBJECT_1'),
('TEACHER_2', 40, 'Liza', 'Sholz', 'SUBJECT_2'),
('TEACHER_3', 35, 'Emily', 'Jones', 'SUBJECT_3'),
('TEACHER_4', 50, 'Michael', 'Jackson', 'SUBJECT_4'),
('TEACHER_5', 45, 'David', 'Hey', 'SUBJECT_5')
;

insert into subject (subject_id,subjectname,marks_id,teacher_id)
values
('SUBJECT_1',  'MATH', 'MARK_1', 'TEACHER_1'),
('SUBJECT_2',  'IT', 'MARK_2', 'TEACHER_2'),
('SUBJECT_3',  'ECONOMY', 'MARK_3', 'TEACHER_3'),
('SUBJECT_4',  'HISTORY', 'MARK_4', 'TEACHER_4'),
('SUBJECT_5',  'CULTURE', 'MARK_5', 'TEACHER_5'),
('SUBJECT_6',  'MATH', 'MARK_6', 'TEACHER_1'),
('SUBJECT_7',  'IT', 'MARK_7', 'TEACHER_2'),
('SUBJECT_8',  'ECONOMY', 'MARK_8', 'TEACHER_3'),
('SUBJECT_9',  'HISTORY', 'MARK_9', 'TEACHER_4'),
('SUBJECT_10', 'CULTURE', 'MARK_10', 'TEACHER_5'),
('SUBJECT_11', 'MATH', 'MARK_11', 'TEACHER_1'),
('SUBJECT_12', 'IT', 'MARK_12', 'TEACHER_2'),
('SUBJECT_13', 'ECONOMY', 'MARK_13', 'TEACHER_3'),
('SUBJECT_14', 'HISTORY', 'MARK_14', 'TEACHER_4'),
('SUBJECT_15', 'CULTURE', 'MARK_15', 'TEACHER_5'),
('SUBJECT_16', 'MATH', 'MARK_16', 'TEACHER_1'),
('SUBJECT_17', 'IT', 'MARK_17', 'TEACHER_2'),
('SUBJECT_18', 'ECONOMY', 'MARK_18', 'TEACHER_3'),
('SUBJECT_19', 'HISTORY', 'MARK_19', 'TEACHER_4'),
('SUBJECT_20', 'CULTURE', 'MARK_20', 'TEACHER_5'),
('SUBJECT_21', 'MATH', 'MARK_21', 'TEACHER_1'),
('SUBJECT_22', 'IT', 'MARK_22', 'TEACHER_2'),
('SUBJECT_23', 'ECONOMY', 'MARK_23', 'TEACHER_3'),
('SUBJECT_24', 'HISTORY', 'MARK_24', 'TEACHER_4'),
('SUBJECT_25', 'CULTURE', 'MARK_25', 'TEACHER_5')
;

insert into marks (mark_id, mark, student_id, subject_id)
values
('MARK_1', floor(random()*100) , 'STUDENT_1','SUBJECT_1'),
('MARK_2', floor(random()*100), 'STUDENT_1', 'SUBJECT_2'),
('MARK_3', floor(random()*100), 'STUDENT_1', 'SUBJECT_3'),
('MARK_4', floor(random()*100), 'STUDENT_1', 'SUBJECT_4'),
('MARK_5', floor(random()*100), 'STUDENT_1', 'SUBJECT_5'),
('MARK_6', floor(random()*100), 'STUDENT_2', 'SUBJECT_6'),
('MARK_7', floor(random()*100), 'STUDENT_2', 'SUBJECT_7'),
('MARK_8', floor(random()*100), 'STUDENT_2', 'SUBJECT_8'),
('MARK_9', floor(random()*100), 'STUDENT_2', 'SUBJECT_9'),
('MARK_10', floor(random()*100), 'STUDENT_2','SUBJECT_10'),
('MARK_11', floor(random()*100), 'STUDENT_3','SUBJECT_11'),
('MARK_12', floor(random()*100), 'STUDENT_3','SUBJECT_12'),
('MARK_13', floor(random()*100), 'STUDENT_3','SUBJECT_13'),
('MARK_14', floor(random()*100), 'STUDENT_3','SUBJECT_14'),
('MARK_15', floor(random()*100), 'STUDENT_3','SUBJECT_15'),
('MARK_16', floor(random()*100), 'STUDENT_4','SUBJECT_16'),
('MARK_17', floor(random()*100), 'STUDENT_4','SUBJECT_17'),
('MARK_18', floor(random()*100), 'STUDENT_4','SUBJECT_18'),
('MARK_19', floor(random()*100), 'STUDENT_4','SUBJECT_19'),
('MARK_20', floor(random()*100), 'STUDENT_4','SUBJECT_20'),
('MARK_21', floor(random()*100), 'STUDENT_5','SUBJECT_21'),
('MARK_22', floor(random()*100), 'STUDENT_5','SUBJECT_22'),
('MARK_23', floor(random()*100), 'STUDENT_5','SUBJECT_23'),
('MARK_24', floor(random()*100), 'STUDENT_5','SUBJECT_24'),
('MARK_25', floor(random()*100), 'STUDENT_5','SUBJECT_25')
;
