package javaCourse.levelTwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javaCourse.levelTwo.entity.PeriodicEdition;
import javaCourse.levelTwo.entity.Reader;
import javaCourse.levelTwo.entity.Subscription;
import javaCourse.levelTwo.services.PaymentService;
import javaCourse.levelTwo.services.PeriodicEditionService;
import javaCourse.levelTwo.services.ReaderService;
import javaCourse.levelTwo.services.SubscriptionService;


@Controller
@RequestMapping
public class UserController {
	@Autowired
	private PeriodicEditionService periodicEditionService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private ReaderService readerService;

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
			@RequestParam(value = "period") int period,
			@RequestParam(value = "username") String login) {
		PeriodicEdition periodicEdition = (PeriodicEdition) periodicEditionService.findById(issn);
		Reader reader = (Reader) readerService.findByLogin(login);
		int id= reader.getId();
		Subscription subscription = new Subscription(id, issn, period);
		double coast = paymentService.calculate(issn, period);
		subscriptionService.create(subscription);
				
		model.addAttribute("title", periodicEdition.getTitle());
		model.addAttribute("period", period);
		model.addAttribute("coast", coast);
		model.addAttribute("user", login);
		return "user/userPayment";
	}
	
	
}