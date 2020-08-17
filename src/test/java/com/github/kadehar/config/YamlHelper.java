package com.github.kadehar.config;

import com.github.kadehar.config.model.Config;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class YamlHelper {
    private static class Helper {
        private static final YamlHelper helper = new YamlHelper();
    }

    private YamlHelper() {}

    public static YamlHelper yaml() {
        return Helper.helper;
    }

    public Config readConfig() {
        Yaml yaml = new Yaml();

        InputStream is;
        try {
            is = Files.newInputStream(Paths.get("src/test/resources/config.yml"));
        } catch (IOException e) {
            return null;
        }

        return yaml.loadAs(is, Config.class);
    }
}
