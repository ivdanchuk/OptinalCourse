package com.java.model.command;

import com.java.model.command.course.CreateCourse;
import com.java.model.command.course.DeleteCourse;
import com.java.model.command.course.ReadCourse;
import com.java.model.command.course.ReadCourses;
import com.java.model.command.course.SortCourses;
import com.java.model.command.course.UpdateCourse;
import com.java.model.command.login.LoginCommand;
import com.java.model.command.login.LogoutCommand;
import com.java.model.command.login.SignUp;
import com.java.model.command.student.ReadStudentCourses;
import com.java.model.command.student.RegStudentForCourse;
import com.java.model.command.student.UnregStudentForCourse;
import com.java.model.command.topic.CreateTopic;
import com.java.model.command.topic.DeleteTopic;
import com.java.model.command.topic.ReadTopic;
import com.java.model.command.topic.ReadTopics;
import com.java.model.command.topic.UpdateTopic;
import com.java.model.command.tutor.SetMark;
import com.java.model.command.tutor.ShowMarkForm;
import com.java.model.command.tutor.ShowTutorRegForm;
import com.java.model.command.user.CreateUser;
import com.java.model.command.user.DeleteUser;
import com.java.model.command.user.ReadUser;
import com.java.model.command.user.ReadUsers;
import com.java.model.command.user.UpdateUser;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	SIGNUP {
		{
			this.command = new SignUp();
		}
	},

	I18N {
		{
			this.command = new I18NCommand();
		}
	},

	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	CREATE_USER {
		{
			this.command = new CreateUser();
		}
	},
	CREATE_COURSE {
		{
			this.command = new CreateCourse();
		}
	},

	CREATE_TOPIC {
		{
			this.command = new CreateTopic();
		}
	},

	DELETE_USER {
		{
			this.command = new DeleteUser();
		}
	},
	DELETE_COURSE {
		{
			this.command = new DeleteCourse();
		}
	},

	DELETE_TOPIC {
		{
			this.command = new DeleteTopic();
		}
	},

	UPDATE_USER {
		{
			this.command = new UpdateUser();
		}
	},
	UPDATE_TOPIC {
		{
			this.command = new UpdateTopic();
		}
	},

	UPDATE_COURSE {
		{
			this.command = new UpdateCourse();
		}
	},

	READ_USER {
		{
			this.command = new ReadUser();
		}
	},

	READ_USERS {
		{
			this.command = new ReadUsers();
		}
	},
	READ_STUDENT_COURSES {

		{
			this.command = new ReadStudentCourses();
		}
	},

	REG_STUDENT_FOR_COURSE {
		{
			this.command = new RegStudentForCourse();
		}
	},
	UNREG_STUDENT_FOR_COURSE {
		{
			this.command = new UnregStudentForCourse();
		}
	},

	READ_COURSE {
		{
			this.command = new ReadCourse();
		}
	},

	READ_COURSES {
		{
			this.command = new ReadCourses();
		}
	},

	READ_TOPICS {
		{
			this.command = new ReadTopics();
		}
	},
	READ_TOPIC {
		{
			this.command = new ReadTopic();
		}
	},
	SORT_COURSES {
		{
			this.command = new SortCourses();
		}
	},
	SHOW_TUTOR_REG_FORM {
		{
			this.command = new ShowTutorRegForm();
		}
	},
	SHOW_MARK_FORM {
		{
			this.command = new ShowMarkForm();
		}
	},
	SET_MARK {
		{
			this.command = new SetMark();
		}
	};

	IActionCommand command;

	public IActionCommand getCurrentCommand() {
		return command;
	}

}
