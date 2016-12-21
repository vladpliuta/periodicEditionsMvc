package javaCourse.levelTwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "admin/periodicEditionsAdmin";
	}

	@RequestMapping(value = "/usersList", method = RequestMethod.GET)
	public String usersListAdminPage(ModelMap model) {
		List<Reader> readersList = readerService.findAll();
		model.put("usersList", readersList);
		return "admin/usersList";
	}

	@RequestMapping(value = "/delete-{periodicEdition.id}", method = RequestMethod.GET)
	public String deletePeriodicEdition(ModelMap model, @PathVariable(value = "periodicEdition.id") int id) {
		periodicEditionService.deleteById(id);
		List<PeriodicEdition> periodicEditionsList = periodicEditionService.findAll();
		model.put("periodicEditionsList", periodicEditionsList);
		return "admin/periodicEditionsAdmin";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String createPeriodicEdition(ModelMap model, @RequestParam(value = "ISSN") int id,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "shortDescription") String shortDescription,
			@RequestParam(value = "monthPeriodicity") int monthPeriodicity,
			@RequestParam(value = "monthPrice") double monthPrice,
			@RequestParam(value = "discountQuarteryear") int discountQuarteryear,
			@RequestParam(value = "discountHalfyear") int discountHalfyear) {
		PeriodicEdition periodicEdition = new PeriodicEdition(id, title, shortDescription, monthPeriodicity, monthPrice,
				discountQuarteryear, discountHalfyear);
		periodicEditionService.create(periodicEdition);
		List<PeriodicEdition> periodicEditionsList = periodicEditionService.findAll();
		model.put("periodicEditionsList", periodicEditionsList);
		return "admin/periodicEditionsAdmin";
	}
}
