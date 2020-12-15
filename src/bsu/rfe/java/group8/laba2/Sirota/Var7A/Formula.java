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

    //метод для добавления радио кнопок
    private void addRadioButton(String buttonName, final int formulaId){
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                Formula.this.formulaId = formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }
    public Formula(){
        //вызов конструктора предка
        super("Вычисление формулы");


        //установка размера и положения окна
        setSize(WIDTH,HEIGHT);
        //для получения ряда характеристик
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH) / 2,(kit.getScreenSize().height - HEIGHT) / 2);


        //Добавление радио-кнопок выбора формул
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(),true);
        hboxFormulaType.add(Box.createHorizontalGlue());

        //Добавление текстовых полей для переменных
        JLabel labelX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelZ = new JLabel("z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(50));
        hboxVariables.add(labelY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(50));
        hboxVariables.add(labelZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());

        //Добавление области для вывода рузультатов
        JLabel labelResult = new JLabel("Результат:");
        textFieldResult = new JTextField("0",15);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        textFieldResult.setEditable(false);
//создание кнопок
        JButton buttonVichislit = new JButton("Вычислить");
        buttonVichislit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                try{
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    if (formulaId == 1)
                        result = Formula_1(x, y, z);
                    else
                        result = Formula_2(x, y, z);
                    textFieldResult.setText(result.toString());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(Formula.this,"Ошибка в формате записи числа с " +
                            "плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonErase = new JButton("Очистить поля");
        buttonErase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });
        //создание МС кнопки
        JButton buttonMC = new JButton("MC");
        buttonMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                Temp4.setText("0");
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });
        //создание М+ кнопки
        JButton buttonM = new JButton("M+");
        buttonM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                double temp2 = 0;
                try{
                    String temp = textFieldResult.getText();
                    if(temp.isEmpty()){
                        throw new IOException("Incorrect format");
                    }
                    temp2 = Double.valueOf(temp);
                }
                catch (IOException e){
                    System.out.println("Please enter numbers");
                }
                sum += temp2;
                String temp3 = Double.toString(sum);
                Temp4.setText(temp3);
            }
        });
        Box hboxButtons = Box.createHorizontalBox(); //создать коробку с горизонтальной укладкой
        hboxButtons.add(Box.createHorizontalGlue()); //добавить "клей" C4-H1 с левой стороны
        hboxButtons.add(buttonVichislit); // Добавить кнопку "Вычислить" в компоновку
        hboxButtons.add(Box.createHorizontalStrut(40)); // Добавить распорку
        hboxButtons.add(buttonErase);
        hboxButtons.add(Box.createHorizontalStrut(40)); // Добавить распорку
        hboxButtons.add(buttonMC);
        hboxButtons.add(Box.createHorizontalStrut(40)); // Добавить распорку
        hboxButtons.add(buttonM);
        hboxButtons.add(Box.createHorizontalGlue());

        
