package fr.paul.temp.converter;

import fr.paul.temp.data.model.TempsModel;
import fr.paul.temp.domain.entity.TempEntity;
import fr.paul.temp.presentation.rest.response.GetAllResponse;

import java.util.ArrayList;
import java.util.List;

public class TempConverter {
    public static List<TempEntity> TempsModelToEntity(List<TempsModel> list)
    {
        List<TempEntity> res = new ArrayList<>();
        for (TempsModel i : list)
        {
            res.add(new TempEntity(i.date, i.temp, i.hum));
        }
        return res;
    }

    public static List<GetAllResponse> tempModelToResp(List<TempEntity> list)
    {
        List<GetAllResponse> res = new ArrayList<>();
        for (TempEntity i : list)
        {
            res.add(new GetAllResponse(i.date, i.temp, i.hum));
        }
        return res;
    }
}
