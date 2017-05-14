package cz.zcu.kiv.si.sportbot.service;

import org.springframework.stereotype.Service;

/**
 * @author Marek Rasocha
 *         date 26.04.2017.
 */
@Service
public class BasicServiceImpl implements BasicService {

    public String getIndex() {
        return "index";
    }
}
