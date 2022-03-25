package com.github.kadehar.config;

import com.github.kadehar.config.model.Config;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseHelper {
    private static class Helper {
        private static final BaseHelper helper = new BaseHelper();
    }

    private BaseHelper() {}

    public static BaseHelper yaml() {
        return Helper.helper;
    }

    public Base readConfig() {
        Yaml yaml = new Yaml();

        InputStream is;
        try {
            is = Files.newInputStream(Paths.get("src/test/resources/base.yml"));
        } catch (IOException e) {
            return null;
        }

        return yaml.loadAs(is, Base.class);
    }
}
