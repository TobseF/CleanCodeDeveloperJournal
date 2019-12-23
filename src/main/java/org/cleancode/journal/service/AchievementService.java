package org.cleancode.journal.service;

import com.google.gson.Gson;
import org.cleancode.journal.domain.Achievement;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AchievementService implements IAchievementService {

    private List<Achievement> achievements;

    @PostConstruct
    private void loadAchievementsFromFile() {
        Gson gson = new Gson();
        String gradeFilePath = "/achievements.json";
        achievements = List.of(gson.fromJson(new InputStreamReader(getClass().getResourceAsStream(gradeFilePath)), Achievement[].class));
    }

    @Override
    public List<Achievement> loadAllAchievements() {
        return achievements;
    }

    @Override
    public Map<Achievement.Group, List<Achievement>> loadAllAchievementsInGroups() {
        return loadAllAchievements().stream().collect(Collectors.groupingBy(Achievement::getGroup));
    }

    @Override
    public List<Achievement> loadAllAchievementsByGroup(Achievement.Group group) {
        return loadAllAchievementsInGroups().get(group);
    }
}
