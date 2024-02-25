package fr.paul.temp.domain.service;

import fr.paul.temp.converter.TempConverter;
import fr.paul.temp.data.model.TempsModel;
import fr.paul.temp.data.repository.TempsRepo;
import fr.paul.temp.domain.entity.TempEntity;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class TempService {
    private TempsRepo tempsRepo;

    public void AddTemp(String t, String h)
    {
        TempsModel temps = new TempsModel();
        temps.temp = t;
        temps.hum = h;
        temps.date = LocalDateTime.now();
        tempsRepo.persist(temps);
    }

    public List<TempEntity> getAllTemps()
    {
        PanacheQuery<TempsModel> values = tempsRepo.findAll();
        List<TempsModel> res = values.stream()
                .sorted((i,j) -> i.date.isBefore(j.date) ? 1 : -1)
                .toList();
        return TempConverter.TempsModelToEntity(res);
    }
    public TempService()
    {
        this.tempsRepo = new TempsRepo();
    }
}
