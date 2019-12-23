package org.cleancode.journal.service;

import org.cleancode.journal.domain.Achievement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IAchievementService {
    List<Achievement> loadAllAchievements();

    Map<Achievement.Group, List<Achievement>> loadAllAchievementsInGroups();
}
