package core.service;

import core.entity.User;
import core.repository.ServiceInterface;
import core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements ServiceInterface<User>
{

	@Autowired
	private UserRepository repository;

	@Override
	public void save(User user)
	{
		try
		{
			if (isValidUser(user))
			{
				Integer id = user.getId();
				if (id != null)
				{
					if (repository.existsById(id))
					{
						// FIXME Fazer validação de usuário já existe
					}
				}
				repository.save(user);
			}
		}
		catch (Exception e)
		{
			System.out.println("erro ao salvar usuário " + e);
		}
	}

	@Override
	public List<User> getAll()
	{
		return repository.findAll();
	}

	@Override
	public Page<User> getAll(Pageable pageable)
	{
		return repository.findAll(pageable);
	}

	@Override
	public Optional<User> get(Integer id)
	{
		return repository.findById(id);
	}

	private boolean isValidUser(User user)
	{
		String login = user.getLogin();
		return user != null && login != null && user.getPassword() != null
			&& getUserByLogin(login) == null;
	}

	public Integer validateLogin(String login, String password)
	{
		return repository.validate(login, password);
	}

	public User getUserByLogin(String login)
	{
		return repository.findByLogin(login);
	}
}
