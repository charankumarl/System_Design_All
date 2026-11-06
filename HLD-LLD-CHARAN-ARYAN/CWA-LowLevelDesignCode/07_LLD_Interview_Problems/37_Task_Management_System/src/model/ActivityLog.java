package model;

import java.time.LocalDateTime;

public class ActivityLog {
    private String desc;
    private LocalDateTime time;

    public ActivityLog(String desc) {
        this.desc = desc;
        this.time = LocalDateTime.now();
    }

    public String getDesc() {
        return desc;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
