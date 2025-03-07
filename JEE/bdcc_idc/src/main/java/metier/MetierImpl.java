package metier;

import dao.DaoImpl;
import dao.IDao;

public class MetierImpl implements IMetier {

    private IDao dao;
    @Override
    public double calcula() {
        double t = dao.getData();
        double res = t * 23;
        return res;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
