package org.cleancode.journal.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public interface INameService extends Serializable {
    String getRandomName();
}
