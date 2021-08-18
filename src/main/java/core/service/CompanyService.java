package core.service;

import core.entity.User;
import core.repository.CompanyRepository;
import core.repository.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ServiceInterface<User> {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<User> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public Optional<User> get(Integer id) {
        return companyRepository.findById(id);
    }

    @Override
    public void save(User entity) {
        companyRepository.save(entity);
    }
}
