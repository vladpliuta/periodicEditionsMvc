package javaCourse.levelTwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javaCourse.levelTwo.entity.PeriodicEdition;
import javaCourse.levelTwo.services.PaymentService;
import javaCourse.levelTwo.services.PeriodicEditionService;

@Controller
@RequestMapping
public class UserController {
	@Autowired
	private PeriodicEditionService periodicEditionService;
	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/periodicEditionsUser", method = RequestMethod.GET)
	public String periodicEditionsUserPage(ModelMap model) {
		List<PeriodicEdition> periodicEditionsList = periodicEditionService.findAll();
		model.put("periodicEditionsList", periodicEditionsList);
		PeriodicEdition periodicEdition = new PeriodicEdition();
		if (periodicEditionsList.size() > 1) {
			periodicEdition = periodicEditionsList.get(0);
		}
		model.put("periodicEdition", periodicEdition);
		return "user/periodicEditionsUser";
	}

	@RequestMapping(value = "/subscriptionCreate", method = RequestMethod.GET)
	public String subscriptionCreate(ModelMap model, @RequestParam(value = "idPeriodicEdition") int issn,
			@RequestParam(value = "period") int period) {
		PeriodicEdition periodicEdition = (PeriodicEdition) periodicEditionService.get(issn);
		model.addAttribute("title", periodicEdition.getTitle());
		double coast = paymentService.calculate(issn, period);
		model.addAttribute("period", period);
		model.addAttribute("coast", coast);
		return "user/userPayment";
	}
}