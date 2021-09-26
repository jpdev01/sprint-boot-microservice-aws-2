package core.service;

import core.entity.Enterprise;
import core.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseService
{
	@Autowired
	private EnterpriseRepository repository;

	public Enterprise get()
	{
		return (Enterprise)repository.findAll().get(0);
	}

	public void save(Enterprise enterprise)
	{
		repository.save(enterprise);
	}

}
