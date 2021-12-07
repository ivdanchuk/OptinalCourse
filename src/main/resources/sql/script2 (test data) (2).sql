SET NAMES UTF8;
USE db_a; 

	DELIMITER $$
	CREATE PROCEDURE setCourseStatus()
	BEGIN
		UPDATE courses
		SET courses.state =
		CASE 
			WHEN start_date > curdate() THEN 1 
			WHEN ((start_date <= curdate()) and (end_date >= curdate())) THEN 2 
			ELSE 3
		END
		where courses.state <> 3;
	END$$
	DELIMITER ;

/* 1 MINUTE set for presentation purposes*/
CREATE EVENT db_a_set_status
    ON SCHEDULE EVERY 1 MINUTE
    DO
      CALL setCourseStatus();
      
CREATE TRIGGER after_m2m_insert
AFTER INSERT
ON m2m_users_courses FOR EACH ROW
update courses set counter = counter + 1
where courses.id = new.course_id;

CREATE TRIGGER after_m2m_delete
AFTER DELETE
ON m2m_users_courses FOR EACH ROW
update courses set counter = counter - 1
where courses.id = old.course_id;

insert into roles (name) values ('admin');
insert into roles (name) values ('tutor');
insert into roles (name) values ('student');
insert into roles (name) values ('blocked');

insert into users values(Default,'admin','admin','admin@admin.com','698D51A19D8A121CE581499D7B701668',1);

/* tutors */
insert into users values(Default,'Maksym','Veres','maksym@gmail.com','698D51A19D8A121CE581499D7B701668',2);
insert into users values(Default,'Dmytro','Kolesnikov','dmytro@gmail.com','698D51A19D8A121CE581499D7B701668',2);
insert into users values(Default,'Heorhii','Molchanov','heorhii.molchanov@gmail.com','698D51A19D8A121CE581499D7B701668',2);
insert into users values(Default,'TestTutor1','TestTutor1','tutor1@gmail.com','698D51A19D8A121CE581499D7B701668',2);

/* Students 6*/
insert into users values(Default,'Igor','Danchuk','ivdanchuk@gmail.com','698D51A19D8A121CE581499D7B701668',3);
insert into users values(Default,'Ivan','Petrov','ivanov@gmail.com','698D51A19D8A121CE581499D7B701668',3);
insert into users values(Default,'Victor','Snisarevskiy','victor@gmail.ua','698D51A19D8A121CE581499D7B701668',3);
insert into users values(Default,'Zoya','Korovay','zoya@gmail.com','698D51A19D8A121CE581499D7B701668',3);

insert into topics VALUES (DEFAULT,'Backend');
insert into topics VALUES (DEFAULT,'Database');
insert into topics VALUES (DEFAULT,'DevOps');
insert into topics VALUES (DEFAULT,'Frontend');

/* Finished 6*/
INSERT INTO courses VALUES (DEFAULT,'Java Core',72,'2021.09.22.','2021.11.07',1,2,DEFAULT,DEFAULT);
INSERT INTO courses VALUES (DEFAULT,'Java Core practise',36,'2021.09.22.','2021.11.07',1,3,DEFAULT,DEFAULT);

/* in Progress 6*/
INSERT INTO courses VALUES (DEFAULT,'Java Spring',12,'2021.11.09.','2021.12.20',1,2,DEFAULT,DEFAULT);
INSERT INTO courses VALUES (DEFAULT,'My SQL',24,'2021.11.01.','2021.12.20',2,3,DEFAULT,DEFAULT);
INSERT INTO courses VALUES (DEFAULT,'JS,HTML,CSS',24,'2021.11.12.','2021.12.25',4,4,DEFAULT,DEFAULT);

INSERT INTO courses VALUES (DEFAULT,'Linux',36,'2022.01.12.','2022.02.15',3,3,DEFAULT,DEFAULT);

insert into m2m_users_courses values (6,1,null,default);
insert into m2m_users_courses values (6,2,null,default);
insert into m2m_users_courses values (6,3,null,default);
insert into m2m_users_courses values (6,4,null,default);
insert into m2m_users_courses values (6,5,null,default);

insert into m2m_users_courses values (7,1,null,default);
insert into m2m_users_courses values (7,2,null,default);
insert into m2m_users_courses values (7,3,null,default);
insert into m2m_users_courses values (7,4,null,default);
insert into m2m_users_courses values (7,5,null,default);

insert into m2m_users_courses values (8,1,null,default);
insert into m2m_users_courses values (8,2,null,default);
insert into m2m_users_courses values (8,3,null,default);
insert into m2m_users_courses values (8,4,null,default);
insert into m2m_users_courses values (8,5,null,default);

insert into m2m_users_courses values (9,1,null,default);
insert into m2m_users_courses values (9,2,null,default);
insert into m2m_users_courses values (9,3,null,default);
insert into m2m_users_courses values (9,4,null,default);
insert into m2m_users_courses values (9,5,null,default);
