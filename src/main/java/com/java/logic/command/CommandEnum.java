package com.java.logic.command;

import com.java.logic.command.course.CreateCourse;
import com.java.logic.command.course.DeleteCourse;
import com.java.logic.command.course.PrepareCourseRegForm;
import com.java.logic.command.course.ReadCourse;
import com.java.logic.command.course.ReadCourses;
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
import com.java.logic.command.user.ReadUsers;
import com.java.logic.command.user.RegUserForCourse;
import com.java.logic.command.user.UpdateUser;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
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

	READ_USERS {
		{
			this.command = new ReadUsers();
		}
	},
	READ_COURSES {
		{
			this.command = new ReadCourses();
		}
	},

	READ_COURSE {
		{
			this.command = new ReadCourse();
		}
	},

	READ_USER {
		{
			this.command = new ReadUser();
		}
	},
	READ_USER_COURSES {
		{
			this.command = new ReadUserCourses();
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
	PREPARE_COURSE_REG_FORM {
		{
			this.command = new PrepareCourseRegForm();
		}
	},
	REG_USER_FOR_COURSE {
		{
			this.command = new RegUserForCourse();
		}
	};

	// update_user
	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
