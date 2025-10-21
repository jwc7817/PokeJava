public class Move {

    private String name;
    private Types type;
    private int power;
    private int accuracy;
    private MoveType moveType;
    private boolean hasSpecialConditions;

    public Move(String name, Types type){
        this.name = name;
        this.type = type;
        this.power = 10;
        this.accuracy = 100;
        this.moveType = MoveType.Physical;
        this.hasSpecialConditions = false;
    }




    @Override
    public String toString() {
        return name + ", " + type + ", power=" + power +  ", accuracy=" + accuracy + ", moveType=" + moveType;
    }


    public Types getType() {
        return this.type;
    }
}
