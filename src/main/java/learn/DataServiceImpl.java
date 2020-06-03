package learn;

import java.util.UUID;

public class DataServiceImpl implements DataService {
    @Override
    public String a(int i) {
        System.out.println("a is called " + i);
        String ret = UUID.randomUUID().toString();
        return ret;
    }

    @Override
    public String b(int i) {
        System.out.println("b is called " + i);
        String ret = UUID.randomUUID().toString();
        return ret;
    }
}