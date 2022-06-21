package mock;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class GeoServiceImplMock implements GeoService {

    boolean Rus = true;

    public GeoServiceImplMock(boolean Rus) {
        this.Rus = Rus;
    }

    @Override
    public Location byIp(String ip) {

        if (Rus) {
            return new Location("Moscow", Country.RUSSIA, null, 0);
        } else {
            return new Location("New York", Country.USA, null, 0);
        }

    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return null;
    }

}
