package com.example.xpgainer;

public class UserLeaderboard {

    private String username;
    private Integer xp;
    private Integer level;

    public UserLeaderboard(String username, Integer xp, Integer level){
        this.username = username;
        this.xp = xp;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
