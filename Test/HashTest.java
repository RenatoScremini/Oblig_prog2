import Tads.MyClosedHash;
import Tads.MyHash;
import org.junit.jupiter.api.Test;


public class HashTest {
    @Test
    public void hashPush(){
        MyHash<Integer, Integer> hashTest = new MyClosedHash<>();

        hashTest.put(1,1);
    }
}
