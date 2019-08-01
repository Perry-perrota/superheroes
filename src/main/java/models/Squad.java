package models;

public class Squad {
    private int squadId;
    private int squadSize;
    private String squadName;
    private String cause;

    public Squad(int squadSize, String squadName, String cause) {
        this.squadSize = squadSize;
        this.squadName = squadName;
        this.cause = cause;
    }

    public int getSquadId() {
        return squadId;
    }

    public int getSquadSize() {
        return squadSize;
    }

    public String getSquadName() {
        return squadName;
    }

    public String getCause() {
        return cause;
    }
}
