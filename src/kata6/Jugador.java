
package kata6;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name = "Jugador")

public class Jugador {
    private String Name;
    private String Teamabrev; //no queria complicar las cosas añadiendo mas clases
    private String Team;
    private String Position;
    private int Weight;
    public Jugador(String Name, String teamabrev, String team,
     String position,int weight) {
        this.Name=Name;
        this.Teamabrev=teamabrev;
        this.Team = team;
        this.Position = position;
        this.Weight = weight;
    }
    public Jugador(String Name, String teamabrev, String team,
    String position) {
        this.Name=Name;
        this.Teamabrev=teamabrev;
        this.Team = team;
        this.Position = position;
    }
    public Jugador(){
    }

    public String getName() {
        return Name;
    }
    
    
    public String getTeamabrev() {
        return Teamabrev;
    }

    public String getTeam() {
        return Team;
    }

    public String getPosition() {
        return Position;
    }
    
    public int getWeight() {
        return Weight;
    }
    
    @XmlElement(name = "Name")
    public void setName(String Name) {
        this.Name = Name;
    }
    
    @XmlElement(name = "Teamabrev")
    public void setTeamabrev(String Teamabrev) {
        this.Teamabrev = Teamabrev;
    }
    
    @XmlElement(name = "Team")
    public void setTeam(String Team) {
        this.Team = Team;
    }
    
    @XmlElement(name = "Position")
    public void setPosition(String Position) {
        this.Position = Position;
    }

    @XmlAttribute(name = "Weight",required=false)
    public void setWeight(int Weight) {
        this.Weight = Weight;
    }

    @Override
    public String toString() {
        return "Player{" + "Name=" + Name + 
                ", Teamabrev=" + Teamabrev +
                ", Team=" + Team +
                ", Position=" + Position +
                ", Weight=" + Weight + '}';
    }    
}
