package javaCourse.levelTwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javaCourse.levelTwo.entity.PeriodicEdition;
import javaCourse.levelTwo.entity.Reader;
import javaCourse.levelTwo.services.PeriodicEditionService;
import javaCourse.levelTwo.services.ReaderService;

@Controller
@RequestMapping
public class AdminController {
	@Autowired
	private PeriodicEditionService periodicEditionService;
	@Autowired
	private ReaderService readerService;

	@RequestMapping(value = "/periodicEditionsAdmin", method = RequestMethod.GET)
	public String periodicEditionsAdminPage(ModelMap model) {
		List<PeriodicEdition> periodicEditionsList = periodicEditionService.findAll();
		model.put("periodicEditionsList", periodicEditionsList);
		PeriodicEdition periodicEdition = new PeriodicEdition();
		if (periodicEditionsList.size() > 1) {
			periodicEdition = periodicEditionsList.get(0);
		}
		model.put("periodicEdition", periodicEdition);
		return "admin/periodicEditionsAdmin";
	}

	@RequestMapping(value = "/usersList", method = RequestMethod.GET)
	public String usersListAdminPage(ModelMap model) {
		List<Reader> readersList = readerService.findAll();
		model.put("usersList", readersList);
		Reader reader = new Reader();
		if (readersList.size() > 1) {
			reader = readersList.get(0);
		}
		model.put("reader", reader);
		return "admin/usersList";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deletePerson(ModelMap model, int id) {
		periodicEditionService.delete(periodicEditionService.get(id));
		List<PeriodicEdition> periodicEditionsList = periodicEditionService.findAll();
		model.put("periodicEditionsList", periodicEditionsList);
		PeriodicEdition periodicEdition = new PeriodicEdition();
		if (periodicEditionsList.size() > 1) {
			periodicEdition = periodicEditionsList.get(0);
		}
		model.put("periodicEdition", periodicEdition);
		return "admin/periodicEditionsAdmin";
	}
}