package com.java.logic.command;

import com.java.logic.command.course.CreateCourse;
import com.java.logic.command.course.DeleteCourse;
import com.java.logic.command.course.ReadCourse;
import com.java.logic.command.course.ReadCourses;
import com.java.logic.command.course.SortCourses;
import com.java.logic.command.course.UpdateCourse;
import com.java.logic.command.topic.CreateTopic;
import com.java.logic.command.topic.DeleteTopic;
import com.java.logic.command.topic.ReadTopic;
import com.java.logic.command.topic.ReadTopics;
import com.java.logic.command.topic.UpdateTopic;
import com.java.logic.command.user.CreateUser;
import com.java.logic.command.user.DeleteUser;
import com.java.logic.command.user.ReadUser;
import com.java.logic.command.user.ReadUserCourses;
import com.java.logic.command.user.ReadUsers2;
import com.java.logic.command.user.RegUserForCourse;
import com.java.logic.command.user.UnregUserForCourse;
import com.java.logic.command.user.UpdateUser;
import com.java.logic.command.user.setMark;
import com.java.logic.command.user.showMarkForm;
import com.java.logic.command.user.showTutorRegForm;

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

	READ_USERS2 {
		{
			this.command = new ReadUsers2();
		}
	},
	READ_USER_COURSES {

		{
			this.command = new ReadUserCourses();
		}
	},

	REG_USER_FOR_COURSE {
		{
			this.command = new RegUserForCourse();
		}
	},
	UNREG_USER_FOR_COURSE {
		{
			this.command = new UnregUserForCourse();
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
//	READ_USERS_OF_COURSE {
//		{
//			this.command = new readUsersOfCourse();
//		}
//	},
//	READ_CURRENT_USER {
//		{
//			this.command = new ReadCurrentUser();
//		}
//	},
	SHOW_TUTOR_REG_FORM {
		{
			this.command = new showTutorRegForm();
		}
	},
	SHOW_MARK_FORM {
		{
			this.command = new showMarkForm();
		}
	},
	SET_MARK {
		{
			this.command = new setMark();
		}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}

}
