package core.controller.config;

import core.entity.Enterprise;
import core.entity.User;
import core.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config/enterprise")
public class EnterpriseController
{

	@Autowired
	private EnterpriseService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Enterprise> get() {
		Enterprise enterprise = service.get();

		if (enterprise == null) {
			return ResponseEntity.notFound().build();
		}

		return new ResponseEntity<Enterprise>(enterprise, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Enterprise enterprise)
	{
		service.save(enterprise);
	}

}
