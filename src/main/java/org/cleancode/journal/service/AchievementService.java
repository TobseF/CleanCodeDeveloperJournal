package org.cleancode.journal.service;

import com.google.gson.Gson;
import org.cleancode.journal.domain.Achievement;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AchievementService implements IAchievementService {

    @Override
    public List<Achievement> loadAllAchievements() {
        Gson gson = new Gson();
        String gradeFilePath = "/achievements.json";
        Achievement[] achievements = gson.fromJson(new InputStreamReader(getClass().getResourceAsStream(gradeFilePath)), Achievement[].class);
        return List.of(achievements);
    }

    @Override
    public Map<Achievement.Group, List<Achievement>> loadAllAchievementsInGroups() {
        return loadAllAchievements().stream().collect(Collectors.groupingBy(Achievement::getGroup));
    }
}
