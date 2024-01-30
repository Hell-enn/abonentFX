/**
 * Класс AbonentSQLService реализует интерфейс AbonentService,
 * включает ссылку на объект репозитория - AbonentRepository,
 * с помощью которого переопределяет методы интерфейса AbonentService.
 */


package com.company.abonentfx.service.impl;

import com.company.abonentfx.entity.Abonent;
import com.company.abonentfx.repository.AbonentRepository;
import com.company.abonentfx.repository.impl.AbonentSQLRepository;
import com.company.abonentfx.service.AbonentService;

import java.util.List;

public class AbonentSQLService implements AbonentService {

    private final AbonentRepository abonentRepository = new AbonentSQLRepository();


    public AbonentRepository getAbonentRepository() {
        return abonentRepository;
    }

    @Override
    public void save(Abonent abonent) {

        abonentRepository.save(abonent);

    }

    @Override
    public void update(Abonent abonent) {

        abonentRepository.update(abonent);

    }

    @Override
    public List<Abonent> get(int contractId) {

        return abonentRepository.get(contractId);

    }

    @Override
    public void delete(Abonent abonent) {

        abonentRepository.delete(abonent);

    }
}
