import Tads.Hash.MyClosedHash;
import Tads.Hash.MyHash;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class HashTest {
    @Test
    public void putTest(){
        MyHash<Integer, Integer> newHash = new MyClosedHash<>(10);

        assertEquals(0, newHash.getSize());

        newHash.put(1, 1);
        newHash.put(2, 2);
        newHash.put(3, 3);
        newHash.put(4, 4);
        newHash.put(5, 5);
        newHash.put(6,6);
        newHash.put(7,7);
        newHash.put(8,8);
        newHash.put(9,9);
        newHash.put(10,10);
        newHash.put(11,11);


        assertEquals(11, newHash.getSize());




    }
}
