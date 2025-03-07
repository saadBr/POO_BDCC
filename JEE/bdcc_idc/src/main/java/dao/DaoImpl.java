package dao;

public class DaoImpl implements IDao {

    @Override
    public double getData() {
        System.out.println("Version de base des données");
        double temp = 23;
        return temp;
    }
}
