package com.mhosler.d20_campaign_manager.controller;

import com.mhosler.d20_campaign_manager.dto.CreateSceneRequest;
import com.mhosler.d20_campaign_manager.dto.SceneResponse;
import com.mhosler.d20_campaign_manager.dto.UpdateSceneRequest;
import com.mhosler.d20_campaign_manager.service.SceneService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scene")
public class SceneController {

    private final SceneService sceneService;

    public SceneController(SceneService sceneService) {
        this.sceneService = sceneService;
    }

    @GetMapping
    public List<SceneResponse> getScenesBySessionId(@RequestParam Long sessionId) {
        return sceneService.getScenesBySessionId(sessionId);
    }

    @PostMapping
    public SceneResponse createScene(@Valid @RequestBody CreateSceneRequest request) {
        return sceneService.createScene(request);
    }

    @PutMapping("/{id}")
    public SceneResponse updateScene(@PathVariable Long id, @Valid @RequestBody UpdateSceneRequest request) {
        return sceneService.updateScene(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteScene(@PathVariable Long id) {
        sceneService.deleteScene(id);
    }
}
