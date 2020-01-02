package org.cleancode.journal.service;

import org.cleancode.journal.domain.Achievement;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
public interface IAchievementService extends Serializable {
    List<Achievement> loadAllAchievements();

    Map<Achievement.Group, List<Achievement>> loadAllAchievementsInGroups();

    Achievement loadAchievementById(String achievementId);

    List<Achievement> loadAllAchievementsByGroup(Achievement.Group group);
}
