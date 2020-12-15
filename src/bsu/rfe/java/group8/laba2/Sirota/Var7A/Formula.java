package bsu.rfe.java.group8.laba2.Sirota.Var7A;

public class Formula {
}
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.io.IOException;

public class Formula extends JFrame{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 400;
    //текстовые поля для считывания х, у, z и результата
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;
    private JTextField textFieldResult;
    public double sum = 0;
    public JTextField Temp4;
    //радио кнопки
    private ButtonGroup radioButtons = new ButtonGroup();
    //Контейнер для отображения радио кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    //идентификатор выбранной формулы
    private int formulaId = 1;
    //Формула 1 для расчета
    public Double Formula_1 (double x, double y, double z){
        return (Math.pow(Math.log(1+z)*Math.log(1+z) + Math.cos(3.14159*y*y*y),1/4))/(Math.pow(Math.pow(Math.cos(2.718),x)+Math.pow(1/x,1/2)+Math.pow(2.718,x*x),Math.sin(x)));
    }
    //Формула 2 для расчета
    public Double Formula_2 (double x, double y, double z){
        return (Math.sin(Math.pow(z,y)) * Math.sin(Math.pow(z,y)) / Math.pow(1+x*x*x,1/2));
    }
