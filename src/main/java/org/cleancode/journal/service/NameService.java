package org.cleancode.journal.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class NameService implements INameService {

    @Override
    public String getRandomName() {
        return RandomStringUtils.randomAlphabetic(8, 8);
    }
}
