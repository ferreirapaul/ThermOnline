package fr.paul.temp.data.repository;

import fr.paul.temp.data.model.TempsModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TempsRepo implements PanacheRepository<TempsModel> {
    public TempsModel findById(long id)
    {
        return find("id", id).firstResult();
    }
}
