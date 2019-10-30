
package org.entando.config;

import org.entando.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JhipsterConfigManager {

    private final ConfigService<JhipsterConfig> configService;

    @Autowired
    public JhipsterConfigManager(final ConfigService<JhipsterConfig> configService) {
        this.configService = configService;
    }

    public JhipsterConfig getJhipsterConfig() {
        return Optional.ofNullable(configService.getConfig())
            .orElseGet(JhipsterConfig::getDefault);
    }

    public void update(JhipsterConfig jhipsterConfig) {
        configService.updateConfig(jhipsterConfig);
    }

}

