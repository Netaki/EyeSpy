package com.jarhax.eyespy.api.info;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class InfoBuilder {

    private InfoValue icon = InfoValue.EMPTY;
    private final Map<String, InfoValue> infos = new LinkedHashMap<>();

    public <T extends InfoValue> void set(String id, Function<String, T> factory) {
        this.infos.put(id, factory.apply(id));
    }

    public <T extends InfoValue> T get(String id) {
        return (T) this.infos.get(id);
    }

    public Map<String, InfoValue> infos() {
        return infos;
    }

    public Stream<InfoValue> values() {
        return this.infos.values().stream();
    }

    public InfoValue getIcon() {
        return icon;
    }

    public void setIcon(InfoValue icon) {
        this.icon = icon;
    }

    public boolean canDisplay() {
        return this.getIcon() != InfoValue.EMPTY || this.infos.values().stream().anyMatch(infoValue -> infoValue != InfoValue.EMPTY);
    }
}