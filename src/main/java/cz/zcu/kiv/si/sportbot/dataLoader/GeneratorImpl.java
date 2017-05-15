package cz.zcu.kiv.si.sportbot.dataLoader;

import cz.zcu.kiv.si.sportbot.dataLoader.Generator;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Marek Rasocha
 *         date 15.05.2017.
 */
@Service
public class GeneratorImpl implements Generator {
    private static final double FALSE_PROBABILITY = 0.7d;
    @Override
    public boolean generate() {
        Random rn = new Random();
        return !(rn.nextDouble() > FALSE_PROBABILITY);
    }
}
