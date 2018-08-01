package itovp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblManagementLevels")
public class ManagementLevel {

    @Id
    @GeneratedValue
    int lvlId;

    @NotNull
    @Column(unique = true)
    int lvl;

    @NotNull
    @Column(unique = true)
    String lvlName;

    public void setLvlId(int lvlId) {
        this.lvlId = lvlId;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setLvlName(String lvlName) {
        this.lvlName = lvlName;
    }
}
