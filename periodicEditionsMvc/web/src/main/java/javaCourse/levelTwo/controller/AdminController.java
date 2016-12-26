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
	private final int defaultPeriodicalsNumber = 3;
	private final int defaultCurrentPage = 1;

	@RequestMapping(value = "/periodicEditionsAdmin", method = RequestMethod.GET)
	public String periodicEditionsAdminPage(ModelMap model) {
		List<PeriodicEdition> periodicEditionsList = periodicEditionService.findAll(defaultPeriodicalsNumber,
				defaultCurrentPage);
		int pagesCount = periodicEditionService.getPageCount(defaultPeriodicalsNumber);
		model.put("periodicEditionsList", periodicEditionsList);
		model.put("periodicalsNumber", defaultPeriodicalsNumber);
		model.put("currentPage", defaultCurrentPage);
		model.put("pagesCount", pagesCount);
		return "admin/periodicEditionsAdmin";
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String defaultPageNumber(ModelMap model, @RequestParam(value = "periodicalsNumber") int periodicalsNumber) {
		List<PeriodicEdition> periodicEditionsList = periodicEditionService.findAll(periodicalsNumber,
				defaultCurrentPage);
		int pagesCount = periodicEditionService.getPageCount(periodicalsNumber);
		model.put("periodicEditionsList", periodicEditionsList);
		model.put("periodicalsNumber", periodicalsNumber);
		model.put("currentPage", defaultCurrentPage);
		model.put("pagesCount", pagesCount);
		return "admin/periodicEditionsAdmin";
	}

	@RequestMapping(value = "/pageNumber", method = RequestMethod.GET)
	public String pageNumber(ModelMap model, @RequestParam(value = "periodicalsNumber") int periodicalsNumber,
			@RequestParam(value = "currentPage") int currentPage) {
		List<PeriodicEdition> periodicEditionsList = periodicEditionService.findAll(periodicalsNumber, currentPage);
		int pagesCount = periodicEditionService.getPageCount(periodicalsNumber);
		model.put("periodicEditionsList", periodicEditionsList);
		model.put("periodicalsNumber", periodicalsNumber);
		model.put("currentPage", currentPage);
		model.put("pagesCount", pagesCount);
		return "admin/periodicEditionsAdmin";
	}

	@RequestMapping(value = "/readers", method = RequestMethod.GET)
	public String usersListAdminPage(ModelMap model) {
		List<Reader> readers = readerService.findAll();
		model.put("readers", readers);
		return "admin/readers";
	}

	@RequestMapping(value = "/delete/periodic-{periodicEdition.id}", method = RequestMethod.GET)
	public String deletePeriodicEdition(ModelMap model, @PathVariable(value = "periodicEdition.id") int id) {
		periodicEditionService.deleteById(id);
		List<PeriodicEdition> periodicEditionsList = periodicEditionService.findAll();
		model.put("periodicEditionsList", periodicEditionsList);
		return "admin/periodicEditionsAdmin";
	}

	@RequestMapping(value = "/delete/reader-{reader.login}", method = RequestMethod.GET)
	public String deleteUser(ModelMap model, @PathVariable(value = "reader.login") String login) {
		Reader reader = (Reader) readerService.findByLogin(login);
		int id = reader.getId();
		readerService.deleteById(id);
		List<Reader> readers = readerService.findAll();
		model.put("readers", readers);
		return "admin/readers";
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
