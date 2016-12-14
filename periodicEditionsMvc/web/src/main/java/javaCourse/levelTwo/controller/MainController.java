package javaCourse.levelTwo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javaCourse.levelTwo.services.ReaderService;

@Controller
public class MainController {
	@Autowired
	private ReaderService readerService;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Добро пожаловать в учебный проект ПЕРИОДИЧЕСКИЕ ИЗДАНИЯ");
		return "welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public String authentication(Model model, @RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password) {
		String page = null;
		String resalt = readerService.checkLogin(login, password);
		if ("error".equals(resalt)) {
			model.addAttribute("errorLoginPassMessage", "Неверный логин или пароль");
			page = "login";
		} else if ("admin".equals(resalt)) {
			page = "admin";
		} else if ("user".equals(resalt)) {
			page = "user";
		}
		return page;
	}
}