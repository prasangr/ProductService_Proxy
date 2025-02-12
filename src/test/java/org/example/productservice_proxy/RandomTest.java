package org.example.productservice_proxy;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {

    @Test
    public  void RandomTest() {
        // Flaky Test
        Random random = new Random();
        int randomInt = random.nextInt(10);
        assert (randomInt<5);

    }
}
