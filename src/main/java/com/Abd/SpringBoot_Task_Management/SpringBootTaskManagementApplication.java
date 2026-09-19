package com.Abd.SpringBoot_Task_Management;

import com.Abd.SpringBoot_Task_Management.controller.TaskController;
import com.Abd.SpringBoot_Task_Management.model.Priority;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringBootTaskManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootTaskManagementApplication.class, args);

		TaskController List = context.getBean(TaskController.class);
	}


}
