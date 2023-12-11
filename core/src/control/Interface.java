package control;

public class Interface {
    Button button;
    Joystick joystick;
 public Interface(int x, int y){
     button = new Button(x, y);
     joystick = new Joystick();
 }
 /*public void changeXYJ(int jx, int jy){
     joystick.changeXY(jx, jy);
 }
    public double getXJ(int index){
        joystick.getX(index);
    }
    public double getYJ(int index){
        joystick.getY(index);
    }*/
}
